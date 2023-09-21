import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReading {

    public static void main(String[] args) {
        String filename = "src/text.txt";

        // Part 1: Printing lines using FileReader
        System.out.println("Using FileReader:");
        try (FileReader fileReader = new FileReader(filename);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Part 2: Printing lines using Stream
        System.out.println("\nUsing Stream:");
        try {
            Files.lines(Paths.get(filename))
                .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
