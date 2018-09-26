package com.dreamli.odbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class ODBCTest {

	@Test
	public void test01() throws Exception {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection connection = DriverManager
//				.getConnection("jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=c:/db.mdb", "", "");
		.getConnection("jdbc:odbc:db", "", "");

		System.out.println(connection);
	}
}
