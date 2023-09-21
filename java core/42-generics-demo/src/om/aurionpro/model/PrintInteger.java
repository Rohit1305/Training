package om.aurionpro.model;

public class PrintInteger<T,U> {

	private T value1;
	private U value2;
	public PrintInteger(T value1, U value2) {
		super();
		this.value1 = value1;
		this.value2 = value2;
	}
	public void print() {
		System.out.println(value1);
		System.out.println(value2);
	}
	@Override
	public String toString() {
		return "PrintInteger [value1=" + value1 + ", value2=" + value2 + "]";
	}
	
}
