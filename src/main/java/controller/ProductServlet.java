package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.ProductDao;
import entities.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import serviceImpl.ProductServiceImpl;

@WebServlet("/products")
public class ProductServlet extends jakarta.servlet.http.HttpServlet {

    private ProductServiceImpl productService;

    @Override
    public void init() {
     
        ProductDao dao = new ProductDao();
        productService = new ProductServiceImpl(dao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            List<Product> products = productService.findAll();

            req.setAttribute("products", products);

            req.getRequestDispatcher("products.jsp").forward(req, resp);

        } catch (SQLException e) {
            throw new ServletException("Database error in /products", e);
        }
    }
}
