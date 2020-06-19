package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {

	String url = "jdbc:mysql://localhost:3306/test";
	String username = "root";
	String password = "root";
	Connection con = null;

	public Dao() {
		// TODO Auto-generated constructor stub
	}

	public Connection connect() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, username, password);
		
		if(con!=null) {
			System.out.println("Connected");
		}
		return con;

	}

}
