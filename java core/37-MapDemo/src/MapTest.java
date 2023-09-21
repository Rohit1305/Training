import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {

		Map<Integer, String> nameMap = new HashMap<>();
		nameMap.put(1, "Rohit");
		nameMap.put(2, "Mohit");
		nameMap.put(3, "Akash");
		nameMap.put(4, "Yash");

		// Set<Entry<Integer, String>> entrySet = nameMap.entrySet();
		// for (Entry x:entrySet) {
		// System.out.println(x.getKey()+" "+ x.getValue());
		// }

		nameMap.forEach((key, value) -> {
			System.out.println(key + " " + value);
		});

		System.out.println(nameMap.containsValue("Rohit"));
		System.out.println(nameMap.remove(1));
		System.out.println(nameMap.containsValue("Rohit"));
		System.out.println(nameMap.get(1));

		Set<Integer> keySet = nameMap.keySet();
		for (Integer x : keySet) {
			System.out.println(x + " " + nameMap.get(x));
		}

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a name : ");
		String inputName = sc.nextLine();

//		if (nameMap.containsValue(inputName)) {
//			nameMap.values().removeIf(value -> value.equals(inputName));
//			nameMap.forEach((key, value) -> {
//			System.out.println(key + " " + value);
//			});
//			System.out.println("Name removed from the map.");
//		} else {
//			System.out.println("Name does not exist.");
//		}	
//		sc.close();
		

	}

}
