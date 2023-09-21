package com.aurionpro.test;

public class ThreadTest3 {

	public static void main(String[] args) {

		Thread t1= new Thread( new Innerclass()," static inner class");
		t1.start();
		
		Runnable runobj =new Runnable() {
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName()+"Anonmonous class");
		}
	};
	Thread t2= new Thread(runobj," anonmonous class ");
	t2.start();
	
	Runnable runobj2 =()->{
		System.out.println(Thread.currentThread().getName()+"Lambda Function");
	};
	Thread t3= new Thread(runobj2," Lambda function ");
	t3.start();
	
}
	
	 private static class Innerclass implements Runnable{
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName());
		}

}}
