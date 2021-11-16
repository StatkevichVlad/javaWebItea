package ua.itea.remoteCart.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ua.itea.remoteCart.model.dto.CartProductDto;

@RestController
@RequestMapping("/cart/")
public interface CartController {
	public ResponseEntity<CartProductDto> addProductToCart(@RequestParam Integer id, @RequestParam Integer quantity);
}
