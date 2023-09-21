package com.aurionpro.test;

import com.aurionpro.model.ICarfactory;
import com.aurionpro.model.ICars;
import com.aurionpro.model.MarutiFactory;
import com.aurionpro.model.TataFactory;

public class FactoryTest {

	public static void main(String[] args) {
//		ICarfactory marutiFactory = new MarutiFactory();
		ICarfactory marutiFactory = MarutiFactory.getMarutiInstance();
		ICars maruti = marutiFactory.makeCar();
		maruti.start();
		maruti.stop();
		
//		ICarfactory tataFactory = new TataFactory();
		ICarfactory tataFactory = TataFactory.getTataInstance();
		ICars tata = tataFactory.makeCar();
		tata.start();
		tata.stop();
		
	}

}