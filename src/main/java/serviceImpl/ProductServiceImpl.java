package serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDao;
import entities.AgreementItemRef;
import entities.BillingAccountRef;
import entities.Product;
import entities.RelatedPlaceRefOrValue;
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
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}

	@Override
	public List<AgreementItemRef> findAllAgreementItemRef() throws java.sql.SQLException {
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

	@Override
	public List<BillingAccountRef> findBillingAccountRef() throws SQLException {
		List<BillingAccountRef> billingAccountRefs = new ArrayList<>();
		String sql = "SELECT * FROM  billing_account_ref";
		try (Connection comm = dao.getConnection();
				PreparedStatement statement = comm.prepareStatement(sql);
				ResultSet resultSet = statement.executeQuery();) {
			while (resultSet.next()) {
				/*
				 * id base_type referred_type schema_location type href name
				 * 
				 */
				String id = resultSet.getString("id");
				String base_type = resultSet.getString("base_type");
				String referred_type = resultSet.getString("referred_type");
				String schemaLocation = resultSet.getString("schema_location");
				String type = resultSet.getString("type");
				String href = resultSet.getString("name");
				String name = resultSet.getString("name");
				billingAccountRefs
						.add(new BillingAccountRef(id, base_type, referred_type, schemaLocation, type, href, name));
			}
			return billingAccountRefs;

		} catch (SQLException exception) {
			exception.printStackTrace();
		}

		return billingAccountRefs;
	}

	@Override
	public List<RelatedPlaceRefOrValue> findRelatedPlaceRefOrValues() throws SQLException {
		List<RelatedPlaceRefOrValue> placesRefOrValues = new ArrayList<>();
		String sql = "SELECT * FROM related_place_ref_or_value";
		try (Connection conn = dao.getConnection();
				PreparedStatement statement = conn.prepareStatement(sql);
				ResultSet res = statement.executeQuery();

		) {
			while (res.next()) {
				String id = res.getString("id");
				String href = res.getString("href");
				String name = res.getString("name");
				String role = res.getString("role");
				String base_type = res.getString("base_type");
				String schema_location = res.getString("schema_location");
				String type = res.getString("type");
				String referred_type = res.getString("referred_type");
				placesRefOrValues.add(new RelatedPlaceRefOrValue(id, href, name, role, base_type, schema_location, type,
						referred_type));

			}
			return placesRefOrValues;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return placesRefOrValues;
	}

	@Override
	public Product addProduct(Product product) throws SQLException {

		String addQuery = """
			    INSERT INTO public.product
			    (id, href, description, is_bundle, is_customer_visible, name,
			     order_date, product_serial_number, start_date, termination_date)
			    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
			    """;

		try (Connection conn = dao.getConnection();

				PreparedStatement preparedStatement = conn.prepareStatement(addQuery);

		) {

			preparedStatement.setString(1, product.getId());
			preparedStatement.setString(2, product.getHref());
			preparedStatement.setString(3, product.getDescription());
			preparedStatement.setBoolean(4, product.is_bundle());
			preparedStatement.setBoolean(5, product.is_customer_visible());
			preparedStatement.setString(6, product.getName());
			preparedStatement.setTimestamp(7, Timestamp.from(product.getOrder_date().toInstant()));
			preparedStatement.setString(8, product.getProduct_serial_number());
			preparedStatement.setTimestamp(9, Timestamp.from(product.getStart_date().toInstant()));
			preparedStatement.setTimestamp(10, Timestamp.from(product.getTermination_date().toInstant()));

			int executeUpdate = preparedStatement.executeUpdate();
			if (executeUpdate > 0) {
				System.out.println("Product inserted succsuffly ");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

}
