package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Register;
import com.services.Security;

public class RegisterDao {

	
	public String username;
	public String password;
	
	Dao dao = new Dao();
	
	Security security = new Security();
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public RegisterDao() {
		// TODO Auto-generated constructor stub
	}

	public int saveData(Register register) throws Exception {
		// TODO Auto-generated method stub
		
		String psswd = security.encrypt(register.getPassword());
		
		con = dao.connect();
		
		ps = con.prepareStatement("insert into users(fullname,username,password,mobile) values('"+register.getFullName()+"','"+register.getUserName()+"','"+psswd+"','"+register.getMobile()+"')");
		
		int i = ps.executeUpdate();
		System.out.println(i);
		return i;
	}

}
