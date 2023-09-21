package com.aurionpro.model;

public class TrafficLight {
	private TrafficLightState currentState;

	public TrafficLight() {
		currentState = new RedState();
	}

	public void setState(TrafficLightState state) {
		currentState = state;
	}

	public void display() {
		currentState.displayState();
	}

}
