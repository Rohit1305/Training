package com.aurionpro.test;

import com.aurionpro.model.DbLogger;
import com.aurionpro.model.FileLogger;
import com.aurionpro.model.TaxCalculator;

public class TaxCalculatorTest {

	public static void main(String[] args) {
		TaxCalculator t1 = new TaxCalculator(new DbLogger());
		t1.calculateTax(100, 0);

		TaxCalculator t2 = new TaxCalculator(new FileLogger());
		t2.calculateTax(2000, 0);
	}

}