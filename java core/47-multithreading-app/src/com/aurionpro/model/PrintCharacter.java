package com.aurionpro.model;

public class PrintCharacter implements Runnable{

	@Override
	public void run() {

		for(int i='A'; i<='K' ;i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
			System.out.println((char)i);
		}
	}

}
