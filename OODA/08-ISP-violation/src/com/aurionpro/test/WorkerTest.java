package com.aurionpro.test;

import com.aurionpro.model.IWorker;
import com.aurionpro.model.Labour;
import com.aurionpro.model.Robot;

public class WorkerTest {

	public static void main(String[] args) {
		IWorker labour = new Labour();
		labour.startWork();
		labour.stopWork();
		labour.eat();
		labour.drink();

		System.out.println();
		IWorker robot = new Robot();
		robot.startWork();
		robot.stopWork();
		robot.eat();
		robot.drink();
	}

}