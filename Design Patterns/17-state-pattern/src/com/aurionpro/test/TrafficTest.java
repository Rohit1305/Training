package com.aurionpro.test;

import com.aurionpro.model.GreenState;
import com.aurionpro.model.RedState;
import com.aurionpro.model.TrafficLight;

public class TrafficTest {

	public static void main(String[] args) {

		TrafficLight trafficLight = new TrafficLight();
        trafficLight.display(); 

        trafficLight.setState(new GreenState());
        trafficLight.display(); 

        trafficLight.setState(new RedState());
        trafficLight.display(); 
	}
}
