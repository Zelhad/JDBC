package com.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtil {
	private static final String URL = "jdbc:postgresql://localhost:5433/productdb";
	private static final String USER = "postgres";
	private static final String PASSWORD = "admin";

	public static Connection getConnection() throws SQLException {
		return java.sql.DriverManager.getConnection(URL, USER, PASSWORD);
	}

	public void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
