 import java.util.Scanner;
import java.util.Random;

public class EnhancedNumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String playAgain;

        do {
            // Select difficulty level
            System.out.println("Select Difficulty Level:");
            System.out.println("1. Easy (1-50, 10 attempts)");
            System.out.println("2. Medium (1-100, 7 attempts)");
            System.out.println("3. Hard (1-200, 5 attempts)");
            System.out.print("Enter choice (1/2/3): ");
            int choice = scanner.nextInt();

            int range = 0, attempts = 0;
            switch (choice) {
                case 1:
                    range = 50;
                    attempts = 10;
                    break;
                case 2:
                    range = 100;
                    attempts = 7;
                    break;
                case 3:
                    range = 200;
                    attempts = 5;
                    break;
                default:
                    System.out.println("Invalid choice. Defaulting to Medium.");
                    range = 100;
                    attempts = 7;
            }

            int numberToGuess = random.nextInt(range) + 1;
            int guess;
            boolean guessedCorrectly = false;

            System.out.println("I have selected a number between 1 and " + range + ".");
            System.out.println("You have " + attempts + " attempts to guess it.");

            for (int i = 0; i < attempts; i++) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();

                if (guess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                System.out.println("You have " + (attempts - i - 1) + " attempts left.");
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess + ".");
            }

            System.out.print("Would you like to play again? (yes/no): ");
            playAgain = scanner.next();
        } while (playAgain.equalsIgnoreCase("yes"));

        scanner.close();
        System.out.println("Thank you for playing!");
    }
}
