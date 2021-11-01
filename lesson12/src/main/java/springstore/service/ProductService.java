package springstore.service;

import java.sql.SQLException;
import java.util.List;


import org.springframework.stereotype.Service;

import springstore.dao.DaoFactory;
import springstore.model.ProductDto;



@Service
public class ProductService {
	private DaoFactory daoFactory = DaoFactory.getDaoFactory(1);
	private ProductDto product;
	private List<ProductDto> productList;

	public ProductDto getProductById(String id) {
		try {
			product = daoFactory.getProductDao().getProductByid(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return product;
	}

	public List<ProductDto> getProductsByCategory(String category) {
		try {
			productList = daoFactory.getProductDao().getProductByCategory(category);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productList;
	}

}
