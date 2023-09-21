package com.aurionpro.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {
	private List<IItems> cartItems;

	public ShoppingCart() {
		super();
		this.cartItems = new ArrayList<IItems>();
	}

	public void addItemtoCart(IItems item) {
		cartItems.add(item);
	}
	public List<IItems> getCartItems(){
		return cartItems;
	}

	public double getCartPrice() {
		return this.cartItems.stream()
                .collect(Collectors.summingDouble(IItems::getItemPrice));
	}

}
