package com.dreamli.caigen.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.Test;

import com.caigen.sql.CaigenConnectionPoolDataSource;
import com.zaxxer.hikari.HikariDataSource;

public class CaiGenDaoTest {

	@Test
	public void test01() throws Exception {
		// inetsoft.uql.jdbc.pool.access2.connectionTestQuery=select 1
		String jdbURL = "jdbc:access:/c:/order.mdb";
	
		Class.forName("com.caigen.sql.access.AccessDriver");
		Properties props = new Properties();
		props.setProperty("delayedClose", "0");
		props.setProperty("url", jdbURL);
		DataSource poolDataSource = new CaigenConnectionPoolDataSource(props);
		new HikariDataSource();
	
	//        Connection conn = DriverManager.getConnection(jdbURL, props);
		Connection conn = poolDataSource.getConnection();
		System.out.println(conn.getClass());
	//        conn.isValid(5);
		Statement stmt = conn.createStatement();
	
		String sql = "SELECT * FROM orders";
		System.out.println(sql);
		ResultSet rs = stmt.executeQuery(sql);
		ResultSetMetaData resultSetMetaData = rs.getMetaData();
	
		DatabaseMetaData meta = conn.getMetaData();
		System.out.println(meta.getCatalogs());
	
		int iNumCols = resultSetMetaData.getColumnCount();
		for (int j = 1; j <= iNumCols; j++) {
			System.out.println(resultSetMetaData.getColumnName(j) + "  " + resultSetMetaData.getColumnTypeName(j) + "  "
					+ resultSetMetaData.getPrecision(j) + "  " + resultSetMetaData.getScale(j));
		}
	
		Object colval;
	
		while (rs.next()) {
			for (int j = 1; j <= iNumCols; j++) {
				colval = rs.getObject(j);
				System.out.print(colval + "\t");
			}
			System.out.println();
		}
	}

}
