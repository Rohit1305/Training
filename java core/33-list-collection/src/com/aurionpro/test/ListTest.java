package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		
		//add items
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
//		list.add("rohit");
		
		System.out.println(list.size());
		System.out.println(list);
		System.out.println("================");
		
		list.remove(0);
		System.out.println(list.size());
		System.out.println(list);
		System.out.println("================");
		
		list.remove(new Integer(20));
		System.out.println(list.size());
		System.out.println(list);
		System.out.println("================");
		
		System.out.println(list.contains(40));
		System.out.println("================");
		
		list.set(0, 10);
		list.add(30);
		System.out.println(list.size());
		System.out.println(list);
		System.out.println("================");
		
		//method 1
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("================");
		
		//method 2
		for (Integer x:list) {
			System.out.println(x);
		}
		System.out.println("================");
		
		//method 3
		Iterator<Integer> iterator =list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("================");
		
		//method4
		list.forEach((num)->{
			System.out.println(num);
		});
		System.out.println("================");
		
		//method 5
		list.forEach(System.out::println);
		System.out.println("================");
		
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(100);
		list2.add(200);
		System.out.println(list.containsAll(list2));
		list.addAll(list2);
		System.out.println(list.containsAll(list2));
		System.out.println(list);
		list.clear();
		System.out.println(list);
		System.out.println("================");
	}

}
