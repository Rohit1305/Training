package com.aurionpro.model;

public class CarFactory {

	public ICars getCarInstance(CarType car){
		if (car == CarType.Maruti) {
			return new Maruti();
		}
		if (car == CarType.Tata) {
			return new Tata();
		}
		if (car == CarType.Mahindra) {
			return new Mahindra();
		}
		return null;
	}
}