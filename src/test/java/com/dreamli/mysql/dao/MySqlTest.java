package com.dreamli.mysql.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class MySqlTest {

	@Test
	public void test01() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql:///db_inetsoft", "root", "danyan123");

		System.out.println(con);

		Statement stmt = con.createStatement();
		DatabaseMetaData meta = con.getMetaData();
		System.out.println(meta.getCatalogs());

		ResultSet rs = stmt.executeQuery("select * from t_user");
		while (rs.next()) {
			System.out.println(rs.getString("name"));
		}

	}

}
