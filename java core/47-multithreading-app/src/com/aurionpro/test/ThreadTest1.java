package com.aurionpro.test;

import com.aurionpro.model.PrintNumber;

public class ThreadTest1 {

	public static void main(String[] args) {

		System.out.println("Inside Main");
		
//		for (int i =21;i<=30;i++) {
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.println("Main thread"+i);
//		}
		
		PrintNumber t1 =new PrintNumber();
		t1.setName("printer 1");
		t1.setPriority(3);
		System.out.println(t1.getPriority());
//		t1.start();
		
		System.out.println(Thread.MAX_PRIORITY+"\n"+Thread.MIN_PRIORITY+"\n"
			     +Thread.NORM_PRIORITY+"\n"+Thread.currentThread().getPriority());
		
//		PrintNumber t2 =new PrintNumber();
//		t2.setName("printer 2");
//		t2.start();
//		System.out.println("End of main ");
	}

}
