package springstore.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;
import springstore.dao.DaoFactory;
import springstore.model.ProductDto;

@Service
public class CartService {
	private DaoFactory daoFactory = DaoFactory.getDaoFactory(1);
	public static final Logger LOG = Logger.getLogger(CartService.class.getName());

	public HashMap<ProductDto, Integer> addProduct(String idBuy, String quntity,
			HashMap<ProductDto, Integer> productCartMap) {
		ProductDto product = new ProductDto();
		try {
			product = daoFactory.getProductDao().getProductByid(idBuy);
			LOG.info("product initialize");
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.info("product initialixation false");
		}

		Integer count = productCartMap.get(product);
		int qnt = 0;
		if (quntity != null) {
			qnt = Integer.parseInt(quntity);
		}

		if (count == null) {
			LOG.info("add new product");
			productCartMap.put(product, qnt);
		} else {
			LOG.info("add new product with counter++");
			productCartMap.put(product, count + qnt);
		}

		return productCartMap;
	}
	
	public HashMap<ProductDto, Integer> changeCart(String change, String quntity, HashMap<ProductDto, Integer> productCartMap){
		int qnt = 0;
		ProductDto product = new ProductDto();
		if(quntity != null) {
			 qnt = Integer.parseInt(quntity);
		}
		try {
			product = daoFactory.getProductDao().getProductByid(change);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		productCartMap.put(product, qnt);
		return productCartMap;
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
