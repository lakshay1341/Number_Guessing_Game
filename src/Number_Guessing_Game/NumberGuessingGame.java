package Number_Guessing_Game;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Rules: Guess the number between 1 and 100.");
            System.out.println("Select difficulty level: ");
            System.out.println("1. Easy (10 chances");
            System.out.println("2. Medium (7 chances)");
            System.out.println("3. Hard (5 chances)");
            int difficulty = scanner.nextInt();
            int maxAttempts = 0;

            switch (difficulty) {
                case 1:
                    maxAttempts = 10;
                    break;
                case 2:
                    maxAttempts = 7;
                    break;
                case 3:
                    maxAttempts = 5;
                    break;
                default:
                    System.out.println("Invalid choice. Defaulting to Easy level.");
                    maxAttempts = 10;
            }

            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            while (attempts < maxAttempts && !hasGuessedCorrectly) {
                System.out.println("Enter your guess:");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    hasGuessedCorrectly = true;
                    System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
                } else if (userGuess < numberToGuess) {
                    System.out.println("The number is greater than your guess.");
                } else {
                    System.out.println("The number is less than your guess.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The number was " + numberToGuess);
            }

            System.out.println("Do you want to play again? (yes/no)");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing the Number Guessing Game!");
        scanner.close();
    }
}
