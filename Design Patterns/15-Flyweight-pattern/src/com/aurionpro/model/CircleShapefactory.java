package com.aurionpro.model;

import java.util.HashMap;
import java.util.Map;

public class CircleShapefactory {
	private Map <String,IShape> circ = new HashMap();

	public IShape getCircle(String color) {
		Circle circle = (Circle) circ.get(color);

		if (circle == null) {
			circle = new Circle(color);
			circ.put(color, circle);
			System.out.println("Creating circle of color : " + color);
		}
		return circle;
	}

}
