package ua.itea.remoteCart.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import ua.itea.remoteCart.model.entity.CartProductEntity;
import ua.itea.remoteCart.repository.ProductCartRepository;
import ua.itea.remoteCart.service.ProductCartService;

@Service
public class ProductCartServiceImpl implements ProductCartService {

	@Autowired
	private ProductCartRepository repository;

	@Override
	public HashMap<Integer, Integer> getProductCart() {
		List<CartProductEntity> entityList = repository.findAll();
		HashMap<Integer, Integer> cartMap = new HashMap<>();
		for (int i = 0; i < entityList.size(); i++) {
			if (entityList.get(i).getQuantity() != 0) {
				cartMap.put(entityList.get(i).getId(), entityList.get(i).getQuantity());
			}
		}
		return cartMap;
	}

	@Override
	public CartProductEntity addProductToCart(Integer id, Integer quantity) {
		CartProductEntity entity = repository.findById(id).get();
		entity.setQuantity(entity.getQuantity() + quantity);
		repository.save(entity);
		return entity;
	}

	@Override
	public void clearAllCart() {
		List<CartProductEntity> entityList = repository.findAll();
		for (int i = 0; i < entityList.size(); i++) {
			entityList.get(i).setQuantity(0);
		}
		repository.saveAll(entityList);
	}

	@Override
	public CartProductEntity setQuantityById(Integer id, Integer quantity) {
		CartProductEntity entity = repository.findById(id).get();
		entity.setQuantity(quantity);
		repository.save(entity);
		return entity;
	}

}
