package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MathUtilTest {
	MathUtil util;

	@BeforeEach
	void init() {
		util = new MathUtil();
		System.out.println("Before Each");
	}

	@AfterEach
	void clean() {
		util = new MathUtil();
		System.out.println("after Each");
	}

	@BeforeAll
	static void initStatic() {
		System.out.println("Before All");
	}

	@AfterAll
	static void atlastStatic() {
		System.out.println("after All");
	}

	@Test
	@Disabled
	void test() {
		fail("Not yet implemented");
	}

	@Test
	@DisplayName("Addition")
	void testAddNumbers() {
//		MathUtil util = new MathUtil();
		double addResult = util.addNumber(10, 20);
		assertFalse(20 == addResult);
		System.out.println("addtion of numbers " + addResult);
	}

	@Test
	void testFactorial() {
//		MathUtil util = new MathUtil();
		int result = util.factorial(5);
		assertEquals(120, result);
		System.out.println("Factorial of 5 is " + result);
	}

	@Test
	void testdivideNumbers() {
//		MathUtil util = new MathUtil();
		double divideResult = util.divideNumber(20, 10);
		assertTrue(2 == divideResult);
		System.out.println("Division of numbers " + divideResult);
	}

	@Test
	void testArrays() {
		int[] number1 = { 10, 20, 30, 40, 50 };
		int[] number2 = { 20, 30, 40, 50, 60 };

//		MathUtil util = new MathUtil();
		assertArrayEquals(number2, util.adddNumberToArray(number1));

	}

	@Test
	public void testIterableEquality() {
		Integer[] number1 = { 10, 20, 30, 40, 50 };
		List<Integer> expectedList = Arrays.asList(number1);
		Integer[] number2 = { 10, 20, 30, 40, 50 };
		List<Integer> actualList = Arrays.asList(number2);

		assertIterableEquals(actualList, expectedList);

	}

	@Test
	void testDivideNumbers_CheckException() {
//		MathUtil util = new MathUtil();
		assertThrows(ArithmeticException.class, () -> util.divideNumber(10, 0));
	}

	@Test
	void testDivideNumber_checkMultipleResult() {
//		MathUtil util = new MathUtil();
		assertAll(() -> assertEquals(2, util.divideNumber(10, 5)), 
				() -> assertEquals(12, util.addNumber(10, 2)),
				() -> assertEquals(6, util.factorial(3))

		);
	}

}
