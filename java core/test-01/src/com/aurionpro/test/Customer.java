package com.aurionpro.test;

public class Customer {
	private  String id;
	private  String name;
	private static int count =1001;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Customer(String name) {
		super();
		this.id=generateId();
		this.name = name;
	}

	private static String generateId() {
		return "c" +(count++);
	}
	
	

}
