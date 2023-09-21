package com.aurionpro.model;

public class LineItem {

	private int id;
	private int qunatity;
	private Product product;
	private double totalprice;
	
	public LineItem(int id, int qunatity, Product product) {
		super();
		this.id = id;
		this.qunatity = qunatity;
		this.product = product;
		this.totalprice=calculateLineItemCost();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQunatity() {
		return qunatity;
	}
	public void setQunatity(int qunatity) {
		this.qunatity = qunatity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	@Override
	public String toString() {
		return "LineItem [id=" + id + ", qunatity=" + qunatity + ", product=" + product + ", totalprice=" + totalprice
				+ "]";
	}
	public double calculateLineItemCost() {
	    return qunatity * product.getPrice();
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	
}
