
public class CheckedException {

	public static void main(String[] args) {
		System.out.println("Main start");
		function1();
		System.out.println("Main end");
	}

	private static void function1() {
		System.out.println("function1 start");
		function2();
		System.out.println("function1 end");
	}

	private static void function2() {
		System.out.println("function2 start");
		try {
			function3();
		} catch (Exception e) {
			System.out.println("Handled in function 2");
		}
		System.out.println("function2 end");
	}

	private static void function3() throws Exception {
		System.out.println("function3 start");
		function4();
		System.out.println("function3 end");
	}

	private static void function4() throws Exception {
		System.out.println("function4 start");
		throw new Exception();
	}

}
