import java.util.Arrays;
import java.util.List;

public class NamePrint{

    public static void main(String[] args) {
        String[] names = {"Jayesh", "Nimesh", "Mahesh", "Ramesh"};

        // a. Using names.stream().forEach
        Arrays.stream(names)
            .forEach(name -> System.out.println(name));

        // b. Using Arrays.asList(names).forEach
        List<String> nameList = Arrays.asList(names);
        nameList.forEach(name -> System.out.println(name));

        // c. Using static reference method
        Arrays.stream(names)
            .forEach(NamePrint::printName);
    }

    public static void printName(String name) {
        System.out.println(name);
    }
}
