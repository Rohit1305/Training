package com.aurionpro.test;

import com.aurionpro.model.Singleton;

public class SingletonTest {

	public static void main(String[] args) {

//		Singleton obj1 = Singleton.getSingleInstance();
//		obj1.PrintGreetings();
//		Singleton obj2 = Singleton.getSingleInstance();
//		obj2.PrintGreetings();
		

		Singleton obj1 = Singleton.getSingleInstance();
		Singleton obj2 = Singleton.getSingleInstance();
		
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
	    
	}

}
