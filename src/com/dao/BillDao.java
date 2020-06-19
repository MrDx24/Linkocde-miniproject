package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.model.Order;

public class BillDao {

	Dao dao = new Dao();

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public BillDao() {
		// TODO Auto-generated constructor stub
	}
	
	public int placeOrder(int id ) throws Exception {
		
		con = dao.connect();
		ps = con.prepareStatement("delete from orders where userid='"+id+"'");
		
		
		int i = ps.executeUpdate();
		
		return i;
	}
}
