package com.aurionpro.model;

public class MarutiFactory implements ICarfactory{
	private static MarutiFactory marutifactory;

	private MarutiFactory() {
	}

	public static MarutiFactory getMarutiInstance() {
		if (marutifactory == null) {
			marutifactory = new MarutiFactory();
		}
		return marutifactory;
	}

	@Override
	public ICars makeCar() {
		return new Maruti();
	}

}
