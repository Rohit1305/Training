package com.aurionpro.test;

import com.aurionpro.model.Boy;
import com.aurionpro.model.Infant;
import com.aurionpro.model.Kid;
import com.aurionpro.model.Man;

public class InheritanceTest {

	public static void main(String[] args) {

		Case1();
		System.out.println("------------");
		Case2();
		System.out.println("-----------");
		Case3();
		System.out.println("-----------");
		Case4();
		System.out.println("-----------");
		Case5();
		System.out.println("-----------");
		Case6();//Downcasting
		System.out.println("-----------");
		
		
	}

	private static void Case6() {

		typecast(new Infant());
		
	}
	private static void typecast(Man man ) {
		if(man instanceof Infant) {
		Infant infant = (Infant) man;
		infant.sleep();
		infant.play();
		
	}
	}
	private static void typecast(Object obj) {
		if(obj instanceof Infant) {
		Infant infant = (Infant) obj;
		infant.sleep();
		infant.play();
		System.out.println("this is printed object");
	}
	}

	private static void Case5() {

		Object obj;//expects obj of any class
		
		obj = 10; //Boxing
		System.out.println(obj.getClass());
		
		obj = "Rohit"; //Boxing
		System.out.println(obj.getClass().getSimpleName());
		
		obj = 10<15; //Boxing
		System.out.println(obj.getClass());
	}

	private static void Case4() {

		playatpark(new Man());
		playatpark(new Boy());
		playatpark(new Kid());
		playatpark(new Infant());
	}
	private static void playatpark(Man man) {
		man.play();
	}
	

	public static void Case1() {
		Man man;
		man = new Man();
		man.read();
		man.play();

	}

	public static void Case2() {
		Boy boy;
		boy = new Boy();
		boy.read();
		boy.play();
		boy.eat();
	}

	public static void Case3() {
		Man man;
		man = new Infant();
		man.read();
		man.play();
	}

}
