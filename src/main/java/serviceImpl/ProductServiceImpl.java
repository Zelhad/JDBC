package serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDao;
import entities.AgreementItemRef;
import entities.Product;
import service.ProductService;

public class ProductServiceImpl implements ProductService {

	public final ProductDao dao;

	public ProductServiceImpl(ProductDao productDao) {
		this.dao = productDao;
	}

	@Override
	public List<Product> findAll() throws java.sql.SQLException {

		List<Product> products = new ArrayList<>();

		String sql = "SELECT id, href, description, is_bundle, is_customer_visible, "
				+ "name, order_date, product_serial_number, start_date, termination_date " + "FROM product";

		try (Connection conn = dao.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet resultSet = stmt.executeQuery()) {

			while (resultSet.next()) {

				String id = resultSet.getString("id");
				String href = resultSet.getString("href");
				String description = resultSet.getString("description");
				boolean is_bundle = resultSet.getBoolean("is_bundle");
				boolean is_customer_visible = resultSet.getBoolean("is_customer_visible");
				String name = resultSet.getString("name");

				Timestamp orderTS = resultSet.getTimestamp("order_date");
				Timestamp startTS = resultSet.getTimestamp("start_date");
				Timestamp termTS = resultSet.getTimestamp("termination_date");

				OffsetDateTime order_date = orderTS == null ? null : orderTS.toInstant().atOffset(ZoneOffset.UTC);

				OffsetDateTime start_date = startTS == null ? null : startTS.toInstant().atOffset(ZoneOffset.UTC);

				OffsetDateTime termination_date = termTS == null ? null : termTS.toInstant().atOffset(ZoneOffset.UTC);

				String product_serial_number = resultSet.getString("product_serial_number");

				products.add(new Product(id, href, description, is_bundle, is_customer_visible, name, order_date,
						product_serial_number, start_date, termination_date));
			}
		}

		return products;
	}

	@Override
	public List<AgreementItemRef> findAllAgreementItemRef() throws java.sql.SQLException{
		List<AgreementItemRef> agreementItemRefs = new ArrayList<>();
		String sql = "SELECT *  FROM agreement_item_ref";
		try (Connection conn = dao.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				String href = resultSet.getString("href");
				String agreement_item_id = resultSet.getString("agreement_item_id");
				String name = resultSet.getString("name");
				String base_type = resultSet.getString("base_type");
				String schema_location = resultSet.getString("schema_location");
				String type = resultSet.getString("type");
				String referred_type = resultSet.getString("referred_type");
				
				agreementItemRefs.add(new AgreementItemRef(id, href, agreement_item_id, name, base_type,
						schema_location, type, referred_type

				));

			}

			return agreementItemRefs;
		} 
	}
}
