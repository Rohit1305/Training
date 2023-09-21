package com.aurionpro.model;

import java.util.Date;
import java.util.List;

public class Order {
	private int id;
	private Date date;
	private double orderprice;
	private List<LineItem> item;
	
	
	public Order(int id, Date date, List<LineItem> item) {
		super();
		this.id = id;
		this.date = date;
		this.item = item;
		this.orderprice=calculateOrderPrice();
	}
	public double getOrderprice() {
		return orderprice;
	}
	public void setOrderprice(double orderprice) {
		this.orderprice = orderprice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<LineItem> getItem() {
		return item;
	}
	public void setItem(List<LineItem> item) {
		this.item = item;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", date=" + date + ", orderprice=" + orderprice + ", item=" + item + "]";
	}
	
	public double calculateOrderPrice() {
		  double totalOrderPrice = 0.0;
		    for (LineItem lineItem : item) {
		        totalOrderPrice += lineItem.calculateLineItemCost();
		    }
		    return totalOrderPrice;
		}
}
