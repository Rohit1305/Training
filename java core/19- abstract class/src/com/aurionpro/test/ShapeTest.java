package com.aurionpro.test;

import com.aurionpro.model.BorderType;
import com.aurionpro.model.Circle;
import com.aurionpro.model.ColorType;
import com.aurionpro.model.Rectangle;

public class ShapeTest {

	public static void main(String[] args) {

		Rectangle rec = new Rectangle(ColorType.RED, BorderType.DASH, 10, 20);
		rec.calculateArea();
		System.out.println(rec.calculateArea());
		System.out.println(rec.getBorder());
		System.out.println(rec.getColor());

		Circle circ = new Circle(ColorType.RED, BorderType.DOT, 2);
		circ.calculateArea();
		System.out.println(circ.calculateArea());
	}
}
