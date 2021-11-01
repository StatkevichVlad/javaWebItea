package springstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springstore.service.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {


	@Autowired
	private ProductService productService;
	
	@RequestMapping
	public String getAllProducts(ModelMap modelMap) {	
		modelMap.addAttribute("productList" , productService.getProductsByCategory(null));
		return "products";
	}

	@RequestMapping(params = { "id" })
	public String getProductById(ModelMap modelMap, @RequestParam(name = "id") String id) {	
		modelMap.addAttribute("id", productService.getProductById(id));
		return "product";
	}
	
	@RequestMapping(params = {"category"} )
	public String getProducts(ModelMap modelMap, @RequestParam(name = "category") String category ) {
		modelMap.addAttribute("productList" , productService.getProductsByCategory(category));
		return "products";
	}
}
