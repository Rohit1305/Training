package com.aurionpro.test;
import java.util.ArrayList;
import com.aurionpro.model.LineItem;

public class LineItemTest {

	public static void main(String[] args) {

		ArrayList<LineItem> items = new ArrayList<>();
		items.add(new LineItem(01, "product A", 5, 10));
		items.add(new LineItem(02, "product B", 3, 2));

		double totalCartValue = 0.0;
		for (LineItem item : items) {
			totalCartValue += item.calculateTotalPrice();
		}

		System.out.println("List of Line Items and their Total Costs:");
		for (LineItem item : items) {
			System.out.println("Item ID: " + item.getId() + ", Name: " + item.getName() + ", Total Cost: $"
					+ item.calculateTotalPrice());
		}

		System.out.println("Total Cart Value: $" + totalCartValue);
	}

}
