package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import entities.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import serviceImpl.ProductServiceImpl;

@jakarta.servlet.annotation.WebServlet("/products")
public class ProductServlet extends jakarta.servlet.http.HttpServlet {
	private ProductServiceImpl productServiceImpl;

	@Override
	public void init() {
		productServiceImpl = new ProductServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			List<Product> products = productServiceImpl.findAll();
			resp.setContentType("text/html");
			req.setAttribute("products", products);

			req.getRequestDispatcher("../WEB-INF/views/products.jsp").forward(req, resp);


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
