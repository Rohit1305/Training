package com.aurionpro.model;

public class IndianMenu implements IMenu {

	@Override
	public void displayMenu() {
		System.out.println("List of Indian Menus: ");
		System.out.println("=========================");
		System.out.println("Biryani");
		System.out.println("pani puri");
		System.out.println("Pav Bhaji");
		System.out.println();
	}

}
