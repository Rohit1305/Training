import java.util.Scanner;

public class BinaryNumberFromLetters {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        int countN = 0, countO = 0, countR = 0, countE = 0, countZ = 0;

        for (char c : input.toCharArray()) {
            if (c == 'n') countN++;
            else if (c == 'o') countO++;
            else if (c == 'r') countR++;
            else if (c == 'e') countE++;
            else if (c == 'z') countZ++;
        }

        int countOne = Math.min(Math.min(countO, countN), countE);
        countO -= countOne;
        countN -= countOne;
        countE -= countOne;

        int countZero = Math.min(Math.min(countZ, Math.min(countE, Math.min(countR, countO))), countO);

        StringBuilder binaryNumber = new StringBuilder();
        for (int i = 0; i < countOne; i++) {
            binaryNumber.append("1 ");
        }
        for (int i = 0; i < countZero; i++) {
            binaryNumber.append("0 ");
        }

        System.out.println(binaryNumber.toString().trim());
        scanner.close();
    }
}

