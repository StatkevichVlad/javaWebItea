package ua.itea.remoteCart.controller.iml;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ua.itea.remoteCart.component.mapper.ProductCartMapper;
import ua.itea.remoteCart.component.mapper.impl.ProductCartMapperImpl;
import ua.itea.remoteCart.controller.CartController;
import ua.itea.remoteCart.model.dto.CartProductDto;
import ua.itea.remoteCart.service.ProductCartService;

@RestController
public class CartControllerImpl implements CartController {

	@Autowired
	private ProductCartService service;

	@PutMapping
	public ResponseEntity<CartProductDto> addProductToCart(@RequestParam Integer id, @RequestParam Integer quantity) {
		ProductCartMapper mapper = new ProductCartMapperImpl();
		return new ResponseEntity<CartProductDto>(mapper.entityToDto(service.addProductToCart(id, quantity)),
				HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<HashMap<Integer, Integer>> getAllProducts() {
		return new ResponseEntity<HashMap<Integer, Integer>>(service.getProductCart(), HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<CartProductDto> clearAllCart() {
		service.clearAllCart();
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CartProductDto> setQuantityById(@RequestParam Integer id, @RequestParam Integer quantity) {
		ProductCartMapper mapper = new ProductCartMapperImpl();

		return new ResponseEntity<CartProductDto>(mapper.entityToDto(service.setQuantityById(id, quantity)),
				HttpStatus.OK);

	}
}
