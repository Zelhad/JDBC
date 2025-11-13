/*
 * Task 1 — TYPE_FORWARD_ONLY
Explanation:

Default mode.

Cursor moves only forward with next().

You cannot go back, reset, or scroll.

Most efficient and lightweight.

Thrown Exceptions:
SQLException - if a database access error occurs or this method is called on a closed connection
 */

package com.jdbc.com.jdbc;

public class CreateStatementType_Forward_Only {
	private java.sql.Statement stmt;

	public CreateStatementType_Forward_Only() throws java.sql.SQLException {
		stmt=JdbcUtil.getConnection().createStatement(java.sql.ResultSet.TYPE_FORWARD_ONLY, java.sql.ResultSet.CONCUR_READ_ONLY);

	}

	public java.sql.Statement getStmt() {
		return stmt;
	}
	

}
