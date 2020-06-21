package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Login;
import com.services.Security;

public class LoginDao {
	
	public String username;
	public String password;
	
	Dao dao = new Dao();
	
	Security security = new Security();
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public LoginDao() {
		super();
	}

	public String validate(Login login) throws Exception {
		
		con = dao.connect();
		String password = security.encrypt(login.getPassword());
		ps = con.prepareStatement("select * from users where username=? and password=?");
		ps.setString(1, login.getUsername());
		ps.setString(2, password);
		
		
		rs = ps.executeQuery();
		if(rs.next()) {
			
			int id = rs.getInt("userid");
			String mobile = rs.getString("mobile");
			String msg = Integer.toString(id);
			String ans = msg+" "+mobile;	
			return ans;
		}
		else {
			return "error-in-login";
		}
			
		
		
	}
	
	

}
