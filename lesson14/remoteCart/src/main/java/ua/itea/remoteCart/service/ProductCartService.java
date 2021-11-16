package ua.itea.remoteCart.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import ua.itea.remoteCart.model.entity.CartProductEntity;

@Service
public interface ProductCartService {
	
	public HashMap<Integer, Integer> getProductCart();
	
	public CartProductEntity addProductToCart(Integer id , Integer quantity);
	
	public void clearAllCart();
	
	public CartProductEntity setQuantityById(Integer id,Integer quantity);
	
}
