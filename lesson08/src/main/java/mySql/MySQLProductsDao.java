package mySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import daoFactory.ProductDao;
import model.ProductDto;
import myDB.ProductsDBService;

public class MySQLProductsDao implements ProductDao {

	public static final Logger LOG = Logger.getLogger(ProductsDBService.class.getName());
	private MySQLDaoFactory mySQLDaoFactory;
	public static final String SELECT_PRODUCTS = "SELECT id , name , description , price FROM products";

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

}
