package myDB;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.ProductDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductsDBService {
	public static final Logger LOG = Logger.getLogger(ProductsDBService.class.getName());
	private DBConnector connector;
	public static final String SELECT_PRODUCTS = "SELECT id , name , description , price FROM products";

	public ProductsDBService(DBConnector connector) {
		this.connector = connector;
	}

	public List<ProductDto> getProducts() {
		List<ProductDto> result = new ArrayList<>();
		Connection connection = connector.getConnection();
		PreparedStatement ps;
		ResultSet rs = null;
		LOG.info("Starting query");
		try {
			ps = connection.prepareStatement(SELECT_PRODUCTS);
			rs = ps.executeQuery();
			while (rs.next()) {

				ProductDto product = new ProductDto();
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setDescription(rs.getString(3));
				product.setPrice(rs.getInt(4));

				result.add(product);
			}
			LOG.info("Query succes");
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, "DB error" + e.getMessage(), e);
			
		}

		return result;
	}
}
