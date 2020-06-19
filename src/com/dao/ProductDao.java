package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.model.Order;
import com.model.Product;
import com.model.ProductDetails;

public class ProductDao {


	Dao dao = new Dao();

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;



	public ProductDao() {
		// TODO Auto-generated constructor stub
	}

	public int saveOrder(int id, Product product) throws Exception {

		System.out.println("----------------------------------------------");
		System.out.println("Inside ProductDao  : id : " + id);
		System.out.println("Order name : " + product.getProductName());
		System.out.println("----------------------------------------------");
		con = dao.connect();
		int orderId = id+1234;

		ps = con.prepareStatement("select * from orders where orderid=? and ordername=?");
		ps.setInt(1, orderId);
		ps.setString(2, product.getProductName());
		rs = ps.executeQuery();
		if(rs.next()) {
			System.out.println("*****in if update*****");
			int oldqnt = rs.getInt("orderquantity");
			double oldpr = rs.getDouble("orderprice");

			double pricecal = product.getProductPrice() * product.getProductQuantity();
			int newqnt = oldqnt + product.getProductQuantity();
			double newpr = oldpr + pricecal;

			ps = con.prepareStatement("update orders set orderquantity='"+newqnt+"', orderprice='"+newpr+"' where orderid='"+orderId+"' and ordername='"+product.getProductName()+"' ");
			int i = ps.executeUpdate();
			return i;

		}
		else {
			System.out.println("*****in else update*****");
			ps = con.prepareStatement("insert into orders(orderid,userid,ordername,orderquantity,orderprice) values('"+orderId+"','"+id+"','"+product.getProductName()+"','"+product.getProductQuantity()+"','"+product.getProductPrice()+"')");

			int i = ps.executeUpdate();
			System.out.println(i);
			return i;
		}

	}
	
	public ArrayList<Order> getOrder(int id) throws Exception {
		
		ArrayList<Order> productsList = new ArrayList();
		Order order;
		con = dao.connect();
		ps = con.prepareStatement("select * from orders where userid=?");
		ps.setInt(1, id);
		
		rs = ps.executeQuery();
		
		while(rs.next()) {
			order = new Order(rs.getInt("orderid"), rs.getString("ordername"), rs.getInt("orderquantity"), rs.getDouble("orderprice"));
			productsList.add(order);
			
		}
		return productsList;
		
		
		
	}
	
	public ArrayList<ProductDetails> getProducts() throws Exception {
		
		ArrayList<ProductDetails> productsList = new ArrayList();
		ProductDetails product;
		con = dao.connect();
		ps = con.prepareStatement("select * from products");
		
		rs = ps.executeQuery();
		
		while(rs.next()) {
			product = new ProductDetails(rs.getInt("pid"), rs.getString("pname"), rs.getInt("price"));
			productsList.add(product);
			
		}
		
		System.out.println("Loaded successfully : " + productsList.size());
		return productsList;
		
	}

}
