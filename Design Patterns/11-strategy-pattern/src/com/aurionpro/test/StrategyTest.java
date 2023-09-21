package com.aurionpro.test;

import com.aurionpro.model.AddOperation;
import com.aurionpro.model.MultiplyOperation;
import com.aurionpro.model.Strategy;
import com.aurionpro.model.StrategyOperation;

public class StrategyTest {

	public static void main(String[] args) {
		StrategyOperation op=new StrategyOperation(new AddOperation());
		System.out.println("Addition is: "+op.executeStrategy(10, 20));
		op.setStrategy(new MultiplyOperation());
		System.out.println("Multiplication is: "+op.executeStrategy(10,20));
	}

}
