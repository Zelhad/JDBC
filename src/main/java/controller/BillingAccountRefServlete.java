package controller;

import java.io.IOException;
import java.util.List;

import dao.ProductDao;
import entities.BillingAccountRef;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProductService;
import serviceImpl.ProductServiceImpl;

@WebServlet("/billingsAccountRefs")
public class BillingAccountRefServlete extends HttpServlet {
	
	private ProductService productService;

	@Override
	public void init() {

		ProductDao dao = new ProductDao();
		productService = new ProductServiceImpl(dao);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			List<BillingAccountRef> billingAccountRefs = productService.findBillingAccountRef();
			resp.setContentType("text/html");
			req.setAttribute("billingAccountRefs", billingAccountRefs);
			req.getRequestDispatcher("billingAccountRef.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
