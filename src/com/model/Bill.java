package com.model;

public class Bill {
	
	String name;
	double total;
	double cgst;
	double sgst;
	double finalBill;
	
	public Bill(String name, double total, double cgst, double sgst, double finalBill) {
		super();
		this.name = name;
		this.total = total;
		this.cgst = cgst;
		this.sgst = sgst;
		this.finalBill = finalBill;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getCgst() {
		return cgst;
	}
	public void setCgst(double cgst) {
		this.cgst = cgst;
	}
	public double getSgst() {
		return sgst;
	}
	public void setSgst(double sgst) {
		this.sgst = sgst;
	}
	public double getFinalBill() {
		return finalBill;
	}
	public void setFinalBill(double finalBill) {
		this.finalBill = finalBill;
	}
	
	

}
