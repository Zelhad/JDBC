package utils;
import java.util.List;

import dao.ProductDao;
import entities.BillingAccountRef;
import serviceImpl.ProductServiceImpl;
public class TestWithSystemOutPrintln {
	public static void main(String[] args)  throws java.sql.SQLException{
		
		ProductDao dao = new ProductDao();
		ProductServiceImpl productServiceImpl= new ProductServiceImpl(dao);
		
		List<BillingAccountRef> billingAccountRefs = productServiceImpl.findBillingAccountRef();
		
		billingAccountRefs.forEach(System.out::println);
	}
}
