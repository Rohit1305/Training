import java.util.Arrays;

public class StringDuplicate {

	public static void main(String[] args) {
		System.out.println("array :");
		String[] arr = { "Rohit", "nitish", "akash","Rohit"};

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		Arrays.sort(arr);

		// for (int i=0;i<arr.length;i++)
		// System.out.println(arr[i]);
		int i = 0;
		System.out.println("Unique Element:");
		while (i < arr.length) {
			if (arr[i] != arr[i + 1]) {
				System.out.println(arr[i]);
			}
			i = i + 2;
		}
	}

}
