
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayList {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50, 25, 35, 45);

        int min = numbers.stream()
            .collect(Collectors.minBy(Integer::compareTo))
            .orElse(0); 
        int max = numbers.stream()
            .collect(Collectors.maxBy(Integer::compareTo))
            .orElse(0); 

        System.out.println("Minimum value: " + min);
        System.out.println("Maximum value: " + max);
    }
}
