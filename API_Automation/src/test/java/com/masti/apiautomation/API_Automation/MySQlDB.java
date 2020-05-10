package com.masti.apiautomation.API_Automation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class MySQlDB {

	@Test
	public void connectMySQL() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("connection string");
		Statement smt = con.createStatement();
		ResultSet rs = smt.executeQuery("select * from table");
		while (rs.next()) {
			String firstcolumn = rs.getString("");
			String secondcolumn = rs.getString("");

		}
	}

}
