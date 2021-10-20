package daoFactory;

import java.util.List;

import model.ProductDto;

public interface ProductDao {
	
	public List<ProductDto> getProducts();
	
	public List<ProductDto> getProductByCategory(String category);
	
	public ProductDto getProductByid(String productId);

	
}
