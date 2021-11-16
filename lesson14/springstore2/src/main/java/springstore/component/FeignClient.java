package springstore.component;

import java.util.HashMap;


import feign.Param;
import feign.RequestLine;
import springstore.model.CartProductDto;

public interface FeignClient {
	@RequestLine("GET/")
	public HashMap<Integer, Integer> getAllProducts();

	@RequestLine("PUT /?id={id}&quantity={quantity}")
	public CartProductDto addProductToCart(@Param("id") Integer id, @Param("quantity") Integer quantity);

	@RequestLine("DELETE/")
	public CartProductDto clearAllCart();

	@RequestLine("POST /?id={id}&quantity={quantity}")
	public CartProductDto setQuantityById(@Param("id") Integer id, @Param("quantity") Integer quantity);
}
