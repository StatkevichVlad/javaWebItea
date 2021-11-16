package springstore.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springstore.model.ProductDto;
import springstore.service.RemoteCartService;

@Controller
@RequestMapping("/cart")
public class RemoteCartController {
	@Autowired
	private RemoteCartService cartService;

	@GetMapping
	public String cart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		HashMap<ProductDto, Integer> productCartMap = cartService.getAllProducts();

		session.setAttribute("allPrice", cartService.getAllPrice(productCartMap));
		session.setAttribute("productCartMap", productCartMap);
		

		return "cart";
	}

	@PostMapping(params = { "buy", "quntity" })
	public void addProduct(@RequestParam(name = "buy") String idBuy, @RequestParam(name = "quntity") String quntity,
			HttpServletResponse response) {
		cartService.addProduct(idBuy, quntity);
		try {
			response.getWriter().write(""+cartService.getProductCartMapSize(cartService.getAllProducts()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@PostMapping(params = { "change", "quntity" })
	public void changeCart(@RequestParam(name = "change") String change, @RequestParam(name = "quntity") String quntity,
			HttpServletRequest request, HttpServletResponse response) {
		
		cartService.changeCart(change, quntity);
		try {
			response.getWriter().write(""+cartService.getProductCartMapSize(cartService.getAllProducts()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
