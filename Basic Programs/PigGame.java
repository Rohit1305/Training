import java.util.Scanner;

public class PigGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int playerScore = 0;
        int turnScore = 0;

        System.out.println("Let's play PIG!");
        System.out.println("The goal is to reach 20 points.");

        while (playerScore < 20) {
            System.out.println("\nCurrent score: " + playerScore);

            boolean continueTurn = true;
            while (continueTurn) {
                System.out.print("Enter 'r' to roll or 'h' to hold: ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("r")) {
                    int roll = rollDice();
                    System.out.println("You rolled a " + roll);

                    if (roll == 1) {
                        System.out.println("You lost all points for this turn.");
                        turnScore = 0;
                        continueTurn = false;
                    } else {
                        turnScore += roll;
                        System.out.println("Turn score: " + turnScore);
                    }
                } else if (input.equalsIgnoreCase("h")) {
                    playerScore += turnScore;
                    System.out.println("You held. Total score for this turn: " + turnScore);
                    System.out.println("Current total score: " + playerScore);
                    turnScore = 0;
                    continueTurn = false;
                } else {
                    System.out.println("Invalid input. Please try again.");
                }
            }
        }

        System.out.println("\nCongratulations! You reached 20 points.");
        System.out.println("Final score: " + playerScore);
    }

    private static int rollDice() {
        return (int) (Math.random() * 6) + 1;
    }
}
