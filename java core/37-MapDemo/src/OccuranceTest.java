import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OccuranceTest {

	public static void main(String[] args) {

		List<Integer> numberList = Arrays.asList(10, 20, 30, 102, 40, 50, 20, 40, 40, 30);
		// for (Integer x: numberList) {
		//
		// System.out.println(x);
		// }

		System.out.println("=============================================");

		Map<Integer, Integer> frequencyMap = new HashMap<>();
		for (Integer num : numberList) {
			// frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
			if (frequencyMap.containsKey(num)) {
				frequencyMap.put(num, frequencyMap.get(num) + 1);
			} else {
				frequencyMap.put(num, 1);
			}
		}
		frequencyMap.forEach((key,value)-> {
			System.out.println("Element: " + key + ", Frequency: " + value);
		});
	}

}
