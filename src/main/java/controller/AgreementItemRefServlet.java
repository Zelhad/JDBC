package controller;

import java.io.IOException;

import dao.ProductDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import serviceImpl.ProductServiceImpl;

@WebServlet("/agreements")
public class AgreementItemRefServlet extends jakarta.servlet.http.HttpServlet {
	
    private ProductServiceImpl productService;

    @Override
    public void init() {
     
        ProductDao dao = new ProductDao();
        productService = new ProductServiceImpl(dao);
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			java.util.List<entities.AgreementItemRef> agreementItemRefs = productService.findAllAgreementItemRef();
			resp.setContentType("text/html");
			req.setAttribute("agreementItemRefs", agreementItemRefs);
			req.getRequestDispatcher("agreementItemRef.jsp").forward(req, resp);

		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		}
	}

}
