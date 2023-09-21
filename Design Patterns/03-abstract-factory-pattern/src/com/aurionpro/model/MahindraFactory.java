package com.aurionpro.model;

public class MahindraFactory implements ICarfactory {
	private static ICarfactory mahindrafactory;

	private MahindraFactory() {
	}

	public static ICarfactory getMahindraInstance() {
		if (mahindrafactory == null) {
			mahindrafactory = new MahindraFactory();
		}
		return mahindrafactory;
	}

	@Override
	public ICars makeCar() {
		return new Mahindra();
	}

}
