package springstore.mySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import springstore.dao.ProductDao;
import springstore.model.ProductDto;



public class MySQLProductsDao implements ProductDao {

	public static final Logger LOG = Logger.getLogger(MySQLProductsDao.class.getName());
	private MySQLDaoFactory mySQLDaoFactory;
	public static final String SELECT_PRODUCTS = 
			"SELECT p.id, p.name, p.description, p.price, p2c.product_id, p2c.category_id, c.name "
			+ "FROM products p ";
	
	public static final String SELECT_PRODUCTS_BY = 
			SELECT_PRODUCTS 
			+ "JOIN product2category p2c on p2c.product_id = p.id "
			+ "JOIN categories c on c.id = p2c.category_id ";
			
	
	public static final String SELECT_PRODUCTS_BY_ID = 
			SELECT_PRODUCTS_BY
			+ "WHERE p.id = ?";
	
	public static final String SELECT_PRODUCTS_BY_CATEGORY = 
			SELECT_PRODUCTS_BY 
			+ "WHERE c.name = ?";

	public MySQLProductsDao() {

	}

	@Override
	public List<ProductDto> getProducts() {
		List<ProductDto> result = new ArrayList<>();

		Connection connection = mySQLDaoFactory.getInstance().getConnection();

		PreparedStatement ps;
		ResultSet rs;
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

	@Override
	public List<ProductDto> getProductByCategory(String category) {
		List<ProductDto> result = new ArrayList<>();

		Connection connection = mySQLDaoFactory.getInstance().getConnection();

		PreparedStatement ps = null;
		ResultSet rs;
		LOG.info("Starting query");

		try {
			if (category != null && !category.isEmpty()) {
				ps = connection.prepareStatement(SELECT_PRODUCTS_BY_CATEGORY);
				ps.setString(1, category);
			} else {
				ps = connection.prepareStatement(SELECT_PRODUCTS_BY);

			}

			rs = ps.executeQuery();
			while (rs.next()) {
				ProductDto product = new ProductDto();
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setDescription(rs.getString(3).substring(0,30) + "...");
				product.setPrice(rs.getInt(4));

				result.add(product);
			}
			LOG.info("Query succes");
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, "DB error" + e.getMessage(), e);

		}

		return result;
	}

	@Override
	public ProductDto getProductByid(String productId) {
		ProductDto result = null;

		Connection connection = mySQLDaoFactory.getInstance().getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;
		LOG.info("Starting query");

		try {
			if (productId != null && !productId.isEmpty()) {
				ps = connection.prepareStatement(SELECT_PRODUCTS_BY_ID);
				ps.setString(1, productId);
				rs = ps.executeQuery();
			} 

			
			while (rs != null && rs.next()) {
				ProductDto product = new ProductDto();
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setDescription(rs.getString(3));
				product.setPrice(rs.getInt(4));

				result = product;
			}
			LOG.info("Query succes");
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, "DB error" + e.getMessage(), e);

		}

		return result;
	}

}
