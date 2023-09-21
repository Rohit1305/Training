package com.aurionpro.test;

import com.aurionpro.model.PrintTable;

public class TableTest {

	public static void main(String[] args) throws InterruptedException  {

		PrintTable print1 =new PrintTable(5);
		Thread t1 =new Thread(print1);
		t1.start();
		
//		print1.setNumber(10);
		PrintTable print2 =new PrintTable(10);
		Thread t2 =new Thread(print2);
		t2.sleep(10000);
		t2.start();
	}

}
