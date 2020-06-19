package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Register;

public class RegisterDao {

	
	public String username;
	public String password;
	
	Dao dao = new Dao();
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public RegisterDao() {
		// TODO Auto-generated constructor stub
	}

	public int saveData(Register register) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("inside regsiterdao" + register.getFullName());
		con = dao.connect();
		
		ps = con.prepareStatement("insert into users(fullname,username,password,mobile) values('"+register.getFullName()+"','"+register.getUserName()+"','"+register.getPassword()+"','"+register.getMobile()+"')");
		
		int i = ps.executeUpdate();
		System.out.println(i);
		return i;
	}

}
