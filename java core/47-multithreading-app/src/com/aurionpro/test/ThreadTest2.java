package com.aurionpro.test;

import com.aurionpro.model.PrintCharacter;

public class ThreadTest2 {

	public static void main(String[] args) {

		PrintCharacter printobj = new PrintCharacter();
		
		Thread t1 = new Thread(printobj);
		t1.start();
		
		Thread t2 = new Thread(printobj);
		t2.start();
		
	}

}
