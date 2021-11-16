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
import springstore.service.CartService;

@Controller
@RequestMapping("cart1")
public class CartController {

	@Autowired
	private CartService cartService;

	@GetMapping
	public String cart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		HashMap<ProductDto, Integer> productCartMap = (HashMap<ProductDto, Integer>) session.getAttribute("productCartMap");
		if(productCartMap!=null) {
		session.setAttribute("allPrice", cartService.getAllPrice(productCartMap));
		}
		return "cart";
	}

	@PostMapping(params = { "buy", "quntity" })
	public void addProduct(@RequestParam(name = "buy") String idBuy, @RequestParam(name = "quntity") String quntity,
			HttpServletRequest request) {
		HttpSession session = request.getSession();

		HashMap<ProductDto, Integer> productCartMap = (HashMap<ProductDto, Integer>) session.getAttribute("productCartMap");

		if (productCartMap == null) {
			productCartMap = new HashMap<ProductDto, Integer>();
		}
		productCartMap = cartService.addProduct(idBuy, quntity, productCartMap);
		session.setAttribute("productCartMap", productCartMap);
		session.setAttribute("productCartMapSize", cartService.getProductCartMapSize(productCartMap));
	}
	
	@PostMapping(params = { "change", "quntity" })
	public void changeCart(@RequestParam(name = "change") String change, @RequestParam(name = "quntity") String quntity,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		HashMap<ProductDto, Integer> productCartMap = (HashMap<ProductDto, Integer>) session.getAttribute("productCartMap");

		if (productCartMap == null) {
			productCartMap = new HashMap<ProductDto, Integer>();
		}
		productCartMap = cartService.changeCart(change, quntity, productCartMap);
		session.setAttribute("productCartMap", productCartMap);
		session.setAttribute("productCartMapSize", cartService.getProductCartMapSize(productCartMap));
		session.setAttribute("allPrice", cartService.getAllPrice(productCartMap));
		try {
			response.getWriter().write(""+cartService.getProductCartMapSize(productCartMap));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
