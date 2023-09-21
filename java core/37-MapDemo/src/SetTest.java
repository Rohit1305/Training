import java.util.HashSet;
import java.util.Set;

public class SetTest {

    public static void main(String[] args) {

        Set<String> stringSet = new HashSet<>();

        stringSet.add("Apple");
        stringSet.add("Banana");
        stringSet.add("Orange");
        stringSet.add("Grapes");
        stringSet.add("Apple"); 

        System.out.println("Set elements: " + stringSet);

        System.out.println("Contains 'Banana': " + stringSet.contains("Banana"));

        System.out.println("Removed 'Apple': " + stringSet.remove("Apple"));

        System.out.println("Size of the set: " + stringSet.size());

        stringSet.clear();
        System.out.println("Set after clearing: " + stringSet);

        System.out.println("Is set empty? " + stringSet.isEmpty());
    }
}
