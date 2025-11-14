package dao;

public class ProductDao {
	private String URL = "jdbc:postgresql://localhost:5433/productdb";
	private String USER = "postgres";
	private String PASSWORD = "admin";
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	public  java.sql.Connection getConnection() throws java.sql.SQLException {
		return java.sql.DriverManager.getConnection(URL, USER, PASSWORD);
	}

}
