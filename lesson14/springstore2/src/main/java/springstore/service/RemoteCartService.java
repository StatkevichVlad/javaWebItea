package springstore.service;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import springstore.component.FeignClient;
import springstore.dao.DaoFactory;
import springstore.model.ProductDto;

@Service
public class RemoteCartService {
	private DaoFactory daoFactory = DaoFactory.getDaoFactory(1);
	
	public FeignClient  getFeingClient() {
		FeignClient feignClient = Feign.builder()
				  .client(new OkHttpClient())
				  .encoder(new GsonEncoder())
				  .decoder(new GsonDecoder())
				  .logger(new Slf4jLogger(FeignClient.class))
				  .target(FeignClient.class, "http://localhost:8090/cart");
		return feignClient;
		}
	
	public HashMap<ProductDto, Integer> getAllProducts(){
		HashMap<ProductDto, Integer> productCartMap = new HashMap<ProductDto, Integer>();
		 HashMap<Integer, Integer> remoteCart = new  HashMap<Integer, Integer>();
		 remoteCart = getFeingClient().getAllProducts();
		 for (Map.Entry<Integer, Integer> entry : remoteCart.entrySet()) {
			 try {
				productCartMap.put(daoFactory.getProductDao().getProductByid(""+entry.getKey()), entry.getValue());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}
		 
		 return productCartMap;
		 
	}
	
	public void addProduct(String idBuy, String quntity) {
		
		int id = Integer.parseInt(idBuy);
		int qnt = Integer.parseInt(quntity);
		getFeingClient().addProductToCart(id, qnt);
	}
	
	public void changeCart(String change, String quntity){

		getFeingClient().setQuantityById(Integer.parseInt(change), Integer.parseInt(quntity));		
	}
	
	public int getProductCartMapSize(HashMap<ProductDto, Integer> productCartMap) {
		int productCartMapSize = 0;
		for (Map.Entry<ProductDto, Integer> entry : productCartMap.entrySet()) {
			productCartMapSize += entry.getValue();
		}

		return productCartMapSize;
	}

	public int getAllPrice(HashMap<ProductDto, Integer> productCartMap) {
		int allPrice = 0;
		for (Map.Entry<ProductDto, Integer> entry : productCartMap.entrySet()) {
			allPrice += (entry.getKey().getPrice() * entry.getValue());
		}
		return allPrice;

	}

}
