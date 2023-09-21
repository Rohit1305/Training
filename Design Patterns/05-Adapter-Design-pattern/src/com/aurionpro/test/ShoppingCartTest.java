package com.aurionpro.test;

import java.util.List;

import com.aurionpro.model.Biscuit;
import com.aurionpro.model.Hat;
import com.aurionpro.model.HatAdapter;
import com.aurionpro.model.IItems;
import com.aurionpro.model.ShoppingCart;

public class ShoppingCartTest {

	public static void main(String[] args) {

		ShoppingCart cartObj = new ShoppingCart();
		cartObj.addItemtoCart(new Biscuit("Parle-G", 10));
		cartObj.addItemtoCart(new HatAdapter(new Hat("Summer", "Designer Cotton caps", 300, 10)));

//		System.out.println(cartObj.getCartItems());
//		cartObj.getCartItems();
//		System.out.println(cartObj.getCartPrice());
		
		displayCartItems(cartObj);
		System.out.println("========================================");
		System.out.println("Cart Price : " + cartObj.getCartPrice());
	}

	private static void displayCartItems(ShoppingCart cart) {
		List<IItems> cartList = cart.getCartItems();
		for (IItems i : cartList) {
			System.out.println("Item Name : " + i.getItemName());
			System.out.println("Item Price : " + i.getItemPrice());
		}

	}

}
