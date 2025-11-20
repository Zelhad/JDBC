package controller;

import java.io.IOException;
import java.util.List;

import dao.ProductDao;
import entities.RelatedPlaceRefOrValue;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProductService;

@WebServlet("/places")
public class RelatedPlaceRefOrValueServlet extends HttpServlet {

	ProductDao dao;
	ProductService productService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		dao=new ProductDao();
		productService = new serviceImpl.ProductServiceImpl(dao);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			List<RelatedPlaceRefOrValue> relatedPlaceRefOrValues = productService.findRelatedPlaceRefOrValues();
			req.setAttribute("relatedPlaceRefOrValues" , relatedPlaceRefOrValues);
			resp.setContentType("text/html");
			req.getRequestDispatcher("relatedValues.jsp").forward(req, resp);
		
		
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		}
	}

}
