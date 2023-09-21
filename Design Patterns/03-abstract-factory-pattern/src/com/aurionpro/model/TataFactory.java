package com.aurionpro.model;

public class TataFactory implements ICarfactory {
	private static ICarfactory tatafactory;

	private TataFactory() {
	}

	public static ICarfactory getTataInstance() {
		if (tatafactory == null) {
			tatafactory= new TataFactory();
		}
		return tatafactory;
	}

	@Override
	public ICars makeCar() {
		return new Tata();
	}

}
