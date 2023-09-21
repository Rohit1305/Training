package com.aurionpro.test;

import com.aurionpro.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TestCustomer {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product(1, "Product 1", 10000.0, 10.0),
            new Product(2, "Product 2", 15000.0, 15.0),
            new Product(3, "Product 3", 20000.0, 20.0),
            new Product(4, "Product 4", 50000.0, 5.0)
        );

        List<LineItem> lineItems = Arrays.asList(
            new LineItem(1, 10, products.get(0)),
            new LineItem(2, 15, products.get(1)),
            new LineItem(3, 20, products.get(2)),
            new LineItem(4, 5, products.get(3))
        );

        Order order = new Order(1, new Date(), lineItems);

//        double orderPrice = order.calculateOrderPrice();
//        System.out.println("Order Price: " + orderPrice);
//        
//        for (LineItem item : lineItems) {
//            System.out.println("Line Item Cost: " + item.calculateLineItemCost());
//        }
//        
//        for (Product product : products) {
//            System.out.println("Discounted Price for " + product.getName() + ": " + product.calculateDiscountedPrice());
//        }
        
        Customer customer = new Customer(1, "Rohit", Arrays.asList(order));
        System.out.println(customer);
    }
}
