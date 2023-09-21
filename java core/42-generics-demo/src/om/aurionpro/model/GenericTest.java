package om.aurionpro.model;

public class GenericTest {
	public static void main(String[] args) {
		PrintInteger<Integer, Integer> obj1 = new PrintInteger<>(10, 20);
		System.out.println("Type : Int,Int");
		obj1.print();
		System.out.println("-------------");
		System.out.println(obj1);
		System.out.println("-------------");

		PrintInteger<Double, Double> obj2 = new PrintInteger<>(11.2, 11.3);
		System.out.println("Type: Double Double");
		obj2.print();
		System.out.println("-------------");
		System.out.println(obj2);
		System.out.println("-------------");

		PrintInteger<Double, String> obj3 = new PrintInteger<>(10.0, "Rohit");
		System.out.println("Type: Double String");
		obj3.print();
		System.out.println("-------------");
		System.out.println(obj3);
		System.out.println("-------------");

		PrintInteger<Boolean, String> obj4 = new PrintInteger<>(true, "BAR");
		System.out.println("Type: Boolean String ");
		obj4.print();
		System.out.println("-------------");
		System.out.println(obj4);
		System.out.println("-------------");

		
	}

}
