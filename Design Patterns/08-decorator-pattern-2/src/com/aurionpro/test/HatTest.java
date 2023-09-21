package com.aurionpro.test;

import com.aurionpro.model.GoldenHat;
import com.aurionpro.model.IHat;
import com.aurionpro.model.PremiumHat;
import com.aurionpro.model.RibonelHat;
import com.aurionpro.model.StandardHat;

public class HatTest {

	public static void main(String[] args) {

		IHat obj = new PremiumHat();
		GoldenHat gold = new GoldenHat(obj);
		RibonelHat ribo = new RibonelHat(gold);
		System.out.println(ribo.getName());
		System.out.println(ribo.getPrice());
		
	}

}
