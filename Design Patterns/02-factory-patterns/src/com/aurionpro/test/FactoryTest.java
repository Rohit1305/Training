package com.aurionpro.test;

import com.aurionpro.model.CarFactory;
import com.aurionpro.model.CarType;
import com.aurionpro.model.ICars;

public class FactoryTest {

	public static void main(String[] args) {
		CarFactory obj = new CarFactory();
		ICars tata = obj.getCarInstance(CarType.Tata);
		tata.start();
		tata.stop();

		ICars maruti = obj.getCarInstance(CarType.Maruti);
		maruti.start();
		maruti.stop();
		
		ICars honda = obj.getCarInstance(CarType.Honda);
		if(honda!=null) {
		honda.start();
		honda.stop();
		}
		 	
	}

}