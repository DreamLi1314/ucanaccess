package com.dreamli.ucanaccess.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class UCanAccessTest {

	@Test
	public void testFindUser() throws Exception {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		Connection con = DriverManager.getConnection("jdbc:ucanaccess://c:/db2.accdb", "", "");
		Statement stmt = con.createStatement();
		DatabaseMetaData meta = con.getMetaData();
		System.out.println(meta.getCatalogs());
	
		ResultSet rs = stmt.executeQuery("select * from user");
		while (rs.next()) {
			System.out.println(rs.getString("name"));
		}
	
	}

}
