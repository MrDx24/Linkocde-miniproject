package com.model;

public class Product {

	String productName;
	int productQuantity;
	double productPrice;
	
	public Product(String productName, int productQuantity, double productPrice ) {
		// TODO Auto-generated constructor stub
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
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
