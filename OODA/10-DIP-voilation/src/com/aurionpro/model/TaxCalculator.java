package com.aurionpro.model;

public class TaxCalculator {

	private DBLogger DBlogger;

	public TaxCalculator(DBLogger dBlogger) {
		super();
		DBlogger = dBlogger;
	}

	public DBLogger getDBlogger() {
		return DBlogger;
	}

	public void setDBlogger(DBLogger dBlogger) {
		DBlogger = dBlogger;
	}

	public int calculateTax(int amount, int rate) {
		int tax = 0;
		try {
			tax = amount / rate;
			System.out.println(tax);
		} catch (Exception e) {
			new DBLogger().log("Divided by Zero");
		}
		return tax;
	}
}