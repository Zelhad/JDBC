package service;
import java.util.List;

import entities.Product;

public interface ProductService {
	List<Product> findAll() throws java.sql.SQLException;

}
