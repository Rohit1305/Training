import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

public class StreamsTest {

	public static void main(String[] args) {

		String [] names = {"Rohit","Rahul","Jay","Mavi","Siddhesh"};
		List <String> newnames =new ArrayList<>();
		for (String name : names) {
			if( name.length()==3 || name.length()==4)
			newnames.add(name);
		}
		for (String name :newnames) {
			System.out.println(name);
		}
		
		Arrays.stream(names)
		.filter((name)->(name.length()==3 || name.length()==4))
		.forEach(System.out::println);

		Arrays.stream(names)
		.filter((name)->(name.length()==3 || name.length()==4));
//		.collect(Collector.toList());
		
	}
}
