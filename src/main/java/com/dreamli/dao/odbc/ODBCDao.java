package com.dreamli.dao.odbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ODBCDao {
	public static void main(String[] args) throws Exception {
//		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//		Connection connection = DriverManager
//				.getConnection("jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=c:/db.mdb", "", "");
//
//		System.out.println(connection);

		Class.forName("com.mysql.jdbc.Driver");

		Connection connection = DriverManager
				.getConnection("jdbc:odbc:db", "", "");

		System.out.println(connection);
	}
}
