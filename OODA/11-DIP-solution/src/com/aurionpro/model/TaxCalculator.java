package com.aurionpro.model;

public class TaxCalculator {

	private ILogger logger;

	public TaxCalculator(ILogger logger) {
		super();
		this.logger = logger;
	}

	public ILogger getLogger() {
		return logger;
	}

	public void setLogger(ILogger logger) {
		this.logger = logger;
	}

	public int calculateTax(int amount, int rate) {
		int tax = 0;
		try {
			tax = amount / rate;
			System.out.println(tax);
		} catch (Exception e) {
			logger.log("Divided by Zero");
		}
		return tax;
	}
}