package com.jdbc.com.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
public class jdbcApplciation {

	public static void main(String[] args) throws SQLException {
		CreateStatementType_Forward_Only  createStatementType_Forward_Only = new CreateStatementType_Forward_Only();
	String query ="SELECT * FROM  product";
	ResultSet resultSet = createStatementType_Forward_Only.getStmt().executeQuery(query);
	while(resultSet.next()) {
		System.out.println(resultSet.getString("id"));
	} 
		
	}
}
