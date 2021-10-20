package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoFactory.DaoFactory;
import model.ProductDto;

public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger LOG = Logger.getLogger(CartController.class.getName());
	private HashMap<ProductDto, Integer> productCartMap;
	private DaoFactory daoFactory = DaoFactory.getDaoFactory(1);
	private HttpSession session;
	private ProductDto product;
	private String idBuy;
	private String idChange;
	private String qntString;

	public CartController() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOG.info("Start cart controlle doGet");
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/cart.jsp");

		if (productCartMap != null) {
			session.setAttribute("allPrice", getAllPrice());
		}
		
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		idBuy = request.getParameter("buy");
		idChange = request.getParameter("change");
		qntString = request.getParameter("quntity");

		session = request.getSession();

		if (idBuy != null && !idBuy.isEmpty()) {
			int qnt = Integer.parseInt(qntString);
			LOG.info("Get product");
			try {
				product = daoFactory.getProductDao().getProductByid(idBuy);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			productCartMap = (HashMap<ProductDto, Integer>) session.getAttribute("productCartMap");

			if (productCartMap == null) {
				LOG.info("cartList == null, creating new CartMap");
				productCartMap = new HashMap<>();
			}
			Integer count = productCartMap.get(product);

			if (count == null) {
				LOG.info("add new product");
				productCartMap.put(product, qnt);
			} else {
				LOG.info("add new product with counter++");
				productCartMap.put(product, count + qnt);
			}

			session.setAttribute("productCartMap", productCartMap);
			session.setAttribute("productCartMapSize", getProductCartMapSize());

			LOG.info("Done");
		}
		
		 if(idChange != null && !idChange.isEmpty()) {
			int qnt = Integer.parseInt(qntString);
			
			try {
				product = daoFactory.getProductDao().getProductByid(idChange);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			productCartMap.put(product, qnt);
			
		}
		 
		 
		response.getWriter().write(""+getProductCartMapSize());
	}

	private int getProductCartMapSize() {
		int productCartMapSize = 0;
		for (Map.Entry<ProductDto, Integer> entry : productCartMap.entrySet()) {
			productCartMapSize += entry.getValue();
		}

		return productCartMapSize;
	}

	private int getAllPrice() {
		int allPrice = 0;
		for (Map.Entry<ProductDto, Integer> entry : productCartMap.entrySet()) {
			allPrice += (entry.getKey().getPrice() * entry.getValue());
		}
		return allPrice;

	}

}
