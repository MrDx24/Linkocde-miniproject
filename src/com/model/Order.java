package com.model;

public class Order {
	
	int orderid;
	String productName;
	int productQuantity;
	double productPrice;

	public Order(int orderid, String productName, int productQuantity, double productPrice) {
		// TODO Auto-generated constructor stub
		this.orderid = orderid;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	

}
