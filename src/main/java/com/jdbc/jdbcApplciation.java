package com.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
public class jdbcApplciation {

	public static void main(String[] args) throws SQLException {
		CreateStatementType_Forward_Only  createStatementType_Forward_Only = new CreateStatementType_Forward_Only();
	String query ="SELECT * FROM  product";
	ResultSet resultSet = createStatementType_Forward_Only.getStmt().executeQuery(query);
	while(resultSet.next()) {
		System.out.println(resultSet.getString("id"));
		System.out.println(resultSet.getString("href"));
		System.out.println(resultSet.getString("description"));
		System.out.println(resultSet.getBoolean("is_bundle"));
		System.out.println(resultSet.getBoolean("is_customer_visible"));
		System.out.println(resultSet.getString("name"));
		System.out.println(resultSet.getTimestamp("order_date"));
		System.out.println(resultSet.getString("product_serial_number"));
		System.out.println(resultSet.getTimestamp("start_date"));
		System.out.println(resultSet.getTimestamp("termination_date"));
		
	} 
		
	}
}
