package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Login;

public class LoginDao {
	
	public String username;
	public String password;
	
	Dao dao = new Dao();
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public LoginDao() {
		super();
	}

	public int validate(Login login) throws Exception {
		
		con = dao.connect();
		
		ps = con.prepareStatement("select * from users where username=? and password=?");
		ps.setString(1, login.getUsername());
		ps.setString(2, login.getPassword());
		
		rs = ps.executeQuery();
		if(rs.next()) {
			int id = rs.getInt("userid");
			return id;
		}
		else {
			return -1;
		}
	}
	
	

}
