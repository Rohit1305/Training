import java.util.Random;
import java.util.Scanner;
public class GuessNumber {
	public static void main(String[] args) {
	    int minNumber = 1;
	    int maxNumber = 100;
	    int maxAttempts = 6;

	    Random random = new Random();
	    int generatedNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;

	    Scanner sc = new Scanner(System.in);
	    int attemptCount = 0;

	    System.out.println("Guessing Number Game!");
	    System.out.println("Guess a number between 1 and 100. You have " + maxAttempts + " attempts.");

	    while (attemptCount < maxAttempts) {
	    System.out.print("Enter your guess: ");
	    int userGuess = sc.nextInt();

	    if (userGuess < 1 || userGuess > 100) {
	       System.out.println("Enter a number between 1 and 100.");
	       continue;
	     }

	    attemptCount++;

	    if (userGuess == generatedNumber) {
	       System.out.println("You guessed correctly in " + attemptCount + " attempts. You win!");
	       return;
	  } else if (userGuess < generatedNumber) {
        System.out.println("The number is low. Enter a higher number.");
	  } else {
	    System.out.println("The number is high. Enter a lower number.");
	  }
  }
  System.out.println("You did not guess the number in " + maxAttempts + " attempts. You failed. Game over!");
}

}
