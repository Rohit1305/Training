package com.aurionpro.model;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaTest {

	public static void main(String[] args) {

		IGreetable festObj = new FestivalGreeting();
		festObj.greet();
		
		IGreetable welcomeObj = new IGreetable() {
			
			@Override
			public void greet() {

				System.out.println("greet test");
			}
		};
		
		welcomeObj.greet();
		
		//single statement 
		IGreetable morningObj = ()->System.out.println("good moring ");
		morningObj.greet();
		//multiple statement in lambda
		IGreetable afternoonObj = () -> {
			System.out.println("12pm");
			System.out.println("Good afternoon");
		};
		afternoonObj.greet();
		
		System.out.println("=========================================================");
		//single line 
		IAddable addObj =(num1 ,num2)-> num1 + num2;
		System.out.println("Addition ="+ addObj.add(1, 2));
		
		//multiple line to print
		IAddable add1Obj =(num1 ,num2)->{
			System.out.println("first number"+num1);
			System.out.println("Second number"+num2);
			return num1 + num2;
		};
		System.out.println("Addition ="+ add1Obj.add(10, 20));
		
		System.out.println("================================================");
		//using method inside a lambda
		IAddable add2Obj = LambdaTest :: displayadd;
		System.out.println("Addition ="+ add2Obj.add(5, 5));
		
		IGreetable greetObj = LambdaTest ::displaygreet;
		greetObj.greet();
		
		System.out.println("================================================");
		//from TestGreeting class
		IGreetable greet2Obj = TestGreeting :: new;
		
		IGreetable greet3Obj = new TestGreeting() :: demoGreeting;
		greet3Obj.greet();
		
		IGreetable greet4Obj = TestGreeting :: someGreeting;
		greet4Obj.greet();
		System.out.println("================================================");
		
		//Function lambda byfunction
		Function<String,Integer> fun1Obj =(name)->{
			return name.length();
		};
		System.out.println("length is :"+fun1Obj.apply("Rohit"));
		
		Function<String,String> fun2Obj =(name)->{
			return name+" text me";
		};
		System.out.println("length is :"+fun2Obj.apply("Rohit"));
		
		System.out.println("================================================");
		
		//Consumer function
		Consumer <String> consumeObj = (name)->{
			System.out.println(name);
		};
		consumeObj.accept("Rohit");
		
		//Predicate function
		Predicate <Integer> predictObj1 = (num)->{
			return num%2==0;
		};
		System.out.println("predicate integer "+predictObj1.test(20));
		
		Predicate <String> predictObj2 = (name)->{
			return (name.length()==5);
			
		};
		System.out.println("predicate string "+predictObj2.test("Rohit"));
		System.out.println("predicate string "+predictObj2.test("dharmesh"));
		
		System.out.println("================================================");
		
		//Biconsumer function
		BiConsumer<String , Integer> biconsumeObj = (name,marks)->{
			System.out.println("student name : "+name+" obtained marks : "+marks);
		};
		biconsumeObj.accept("Rohit", 100);
		System.out.println("================================================");
		
		//BiFunction 
		BiFunction <String ,String ,String> bifuncObj =(name1,name2 )->{
			return name1+name2;
		};
		System.out.println(bifuncObj.apply("Rohit ", "Sabat"));
		
		System.out.println("================================================");
		
		//BiPredicate
		BiPredicate<String,String> biprefun =(n1,n2)->{
			return n1==n2;
		};
		System.out.println("comparing "+biprefun.test("Rohit", "Rohit"));
		
	}
	
	private static void displaygreet() {
		System.out.println("greeting from inside lambda");
		
	}

	private static int displayadd(int x, int y ) {
		System.out.println("inside lambda IAddable");
		return x+y;
	}

}
