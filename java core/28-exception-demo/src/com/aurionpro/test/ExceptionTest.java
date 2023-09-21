package com.aurionpro.test;

public class ExceptionTest {
	public static void main(String[] args) {
		int div = 0;
		
		try {
			int firstNumber=Integer.parseInt(args[0]);
			System.out.println("Statement 1");
			int secondNumber=Integer.parseInt(args[1]);
			System.out.println("Statement 2");
			div = firstNumber/secondNumber;
			System.out.println(div);
		}
	
		catch (ArithmeticException e ){
			System.out.println("Number cannot be divided by zero");
		}
		catch (NumberFormatException e ){
			System.out.println("Invalid coversion to type Integer");
		}
		catch (ArrayIndexOutOfBoundsException e ){
			System.out.println("Access to invalid index position");
		}
		catch (RuntimeException e ){
			e.printStackTrace();
		}
		catch(Exception e ){
			e.printStackTrace();
		}
		finally {
			System.out.println("Inside finally block");
		}
		System.out.println("end of code!");
		
	}

}
