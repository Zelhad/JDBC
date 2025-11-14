package serviceImpl;

import java.sql.ResultSet;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.CreateStatementType_Forward_Only;

import entities.Product;
import service.ProductService;

public class ProductServiceImpl implements ProductService {
	// The conversion from sql type to java type we will for it after

	@Override
	public List<Product> findAll() throws java.sql.SQLException {
		List<Product> products = new ArrayList<>();
		CreateStatementType_Forward_Only createStatementType_Forward_Only = new CreateStatementType_Forward_Only();
		String query = "SELECT * FROM  product";
		ResultSet resultSet = createStatementType_Forward_Only.getStmt().executeQuery(query);

		while (resultSet.next()) {
			String id = resultSet.getString("id");
			String href = resultSet.getString("href");
			String description = resultSet.getString("description");
			boolean is_bundle = resultSet.getBoolean("is_bundle");
			boolean is_customer_visible = resultSet.getBoolean("is_customer_visible");
			String name = resultSet.getString("name");
			OffsetDateTime order_date = resultSet.getTimestamp("order_date").toInstant().atOffset(ZoneOffset.UTC);
			String product_serial_number = resultSet.getString("product_serial_number");
			OffsetDateTime start_date = resultSet.getTimestamp("start_date").toInstant().atOffset(ZoneOffset.UTC);
			OffsetDateTime termination_date = resultSet.getTimestamp("termination_date").toInstant()
					.atOffset(ZoneOffset.UTC);

			products.add(new Product(id, href, description, is_bundle, is_customer_visible, name, order_date,
					product_serial_number, start_date, termination_date

			));
		}
		return products;
	}

}