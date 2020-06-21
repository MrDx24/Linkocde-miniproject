package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.model.Bill;



public class CartDao {

	Dao dao = new Dao();

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;


	public CartDao() {
		// TODO Auto-generated constructor stub
	}

	public int saveBill(int id,int orderid, Bill bill) throws Exception {

		
		con = dao.connect();

		int billid = orderid + 1928;

		ps = con.prepareStatement("select * from bill where billid=? and orderid=? ");
		ps.setInt(1, billid);
		ps.setInt(2, orderid);
		rs = ps.executeQuery();
		if(rs.next()) {

			
			double newtotal = bill.getTotal();
			double newcgst = bill.getCgst();
			double newsgst = bill.getSgst();
			double newbill = bill.getFinalBill();

			ps = con.prepareStatement("update bill set billtotal='"+newtotal+"', cgst='"+newcgst+"',sgst='"+newsgst+"',finalbill='"+newbill+"' where orderid='"+orderid+"' ");
			int i = ps.executeUpdate();

			return i;

		}
		else {


			
			ps = con.prepareStatement("insert into bill(billid,orderid,billtotal,cgst,sgst,finalbill) values('"+billid+"','"+orderid+"','"+bill.getTotal()+"','"+bill.getCgst()+"','"+bill.getSgst()+"','"+bill.getFinalBill()+"')");

			int i = ps.executeUpdate();

			return i;
		}

	}


	public String getName(int id) throws Exception {


		con = dao.connect();
		ps = con.prepareStatement("select * from users where userid=?");
		ps.setInt(1, id);

		rs = ps.executeQuery();
		String name = null;
		while(rs.next()) {
			name = rs.getString("fullname");
		}
		return name;



	}

	public Bill getBill(int orderid,String name) throws Exception {


		Bill b = null;
		con = dao.connect();
		ps = con.prepareStatement("select * from bill where orderid=?");
		ps.setInt(1, orderid);

		rs = ps.executeQuery();

		while(rs.next()) {
			b = new Bill(name, rs.getDouble("billtotal"), rs.getDouble("cgst"), rs.getDouble("sgst"), rs.getDouble("finalbill"));

		}

		return b;



	}

	public int getBillId(int id) {

		return id;

	}

}
