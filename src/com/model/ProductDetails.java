package com.model;

public class ProductDetails {

	public int pid  ;
	public String pnames;
	public int pprice;
	
	public ProductDetails(int i, String string, int j) {
		// TODO Auto-generated constructor stub
		this.pid = i;
		this.pnames = string;
		this.pprice = j;
	}
	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPnames() {
		return pnames;
	}

	public void setPnames(String pnames) {
		this.pnames = pnames;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	
	
	

}
