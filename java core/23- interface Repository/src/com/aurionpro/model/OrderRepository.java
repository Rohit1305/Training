package com.aurionpro.model;

public class OrderRepository implements IRepository {
	@Override
	public void create() {
		System.out.println("created");
	}
	@Override
	public void update() {
		System.out.println("updated");
	}
	@Override
	public void delete() {
		System.out.println("updated");
	}

}
