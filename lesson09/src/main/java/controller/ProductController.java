package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoFactory.DaoFactory;
import model.ProductDto;

public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<ProductDto> productList;
	private ProductDto product;
 
    public ProductController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
		String id = request.getParameter("id");
		RequestDispatcher rd;
		DaoFactory daoFactory = DaoFactory.getDaoFactory(1);
		
		if(id != null && !id.isEmpty()) {
			rd = request.getRequestDispatcher("WEB-INF/views/product.jsp");
			try {
				product = daoFactory.getProductDao().getProductByid(id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("product", product);
			
		}
		else {
			rd = request.getRequestDispatcher("WEB-INF/views/products.jsp");
			try {
				productList = daoFactory.getProductDao().getProductByCategory(category);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			request.setAttribute("productList", productList);
		}

		rd.forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
