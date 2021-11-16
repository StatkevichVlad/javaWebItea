package springstore.component;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

public class TestClass {

	public static void main(String[] args) {
		FeignClient feignClient = Feign.builder()
				  .client(new OkHttpClient())
				  .encoder(new GsonEncoder())
				  .decoder(new GsonDecoder())
				  .logger(new Slf4jLogger(FeignClient.class))
				  .target(FeignClient.class, "http://localhost:8090/cart");
			
		
		System.out.println(feignClient.getAllProducts());
		System.out.println(feignClient.addProductToCart(1, 1));
		System.out.println(feignClient.getAllProducts());
		System.out.println(feignClient.setQuantityById(2, 2));
		System.out.println(feignClient.getAllProducts());
		System.out.println(feignClient.getAllProducts());






		
	}

}
