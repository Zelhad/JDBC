package service;
import java.util.List;

import entities.AgreementItemRef;
import entities.Product;

public interface ProductService {
	List<Product> findAll() throws java.sql.SQLException;
	List<AgreementItemRef> findAllAgreementItemRef () throws java.sql.SQLException;
	

}
