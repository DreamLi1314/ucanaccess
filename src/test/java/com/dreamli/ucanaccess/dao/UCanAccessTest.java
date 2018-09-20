package com.dreamli.ucanaccess.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class UCanAccessTest {

	@Test
	public void testFindUser() throws Exception {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");// 这个驱动的地址不要改
		Connection con = DriverManager.getConnection("jdbc:ucanaccess://db.accdb", "", "");
		// DriverManager.getConnection("jdbc:ucanaccess://
		// Access的相对/绝对路径","不用填写","不用填写");
		Statement stmt = con.createStatement();

		// 查找数据
		ResultSet rs = stmt.executeQuery("select * from user");
		while (rs.next()) {
			System.out.println(rs.getString("name"));
		}

	}

}
