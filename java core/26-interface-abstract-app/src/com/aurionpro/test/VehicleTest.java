package com.aurionpro.test;

import com.aurionpro.model.IMovable;
import com.aurionpro.model.Vehicle;
import com.aurionpro.model.Car;

import java.time.LocalDate;

import com.aurionpro.model.Bike;
import com.aurionpro.model.Bus;


public class VehicleTest {
	public static void main(String[] args) {
		IMovable[] movables = { 
				new Car("Honda", LocalDate.of(2022, 8, 1)),
				new Bike("Toyota", LocalDate.of(2022, 9, 10)), 
				new Bus("Audi", LocalDate.of(2023, 4, 10))
				};
		for (int i = 0; i < movables.length; i++) {
			startMoving(movables[i]);
			printDetails(movables[i]);
		}
	}

	public static void startMoving(IMovable movable) {
		movable.move();
		printDetails(movable);
		// movable.showTopSpeed();
	}

	public static void printDetails(IMovable movable) {
		if (movable instanceof Vehicle) {
			Vehicle vehicle = (Vehicle) movable;
			System.out.println("Brand: " + vehicle.getBrand());
			System.out.println("Date of Manufacture: " + vehicle.getDom());
		}
	}
}
