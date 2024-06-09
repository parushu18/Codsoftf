import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int rounds = 0;
        int totalAttempts = 0;
        int totalRoundsWon = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");
        
        // Main game loop
        while (true) {
            int numberToGuess = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean roundWon = false;
            System.out.println("\nRound " + (++rounds) + ":");
            System.out.println("Guess the number between " + minRange + " and " + maxRange + ".");
            
            // Guessing loop
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "/" + maxAttempts + "): ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number " + numberToGuess + " correctly!");
                    roundWon = true;
                    totalRoundsWon++;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }
            
            totalAttempts += attempts;
            
            // Check if the user wants to play another round
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }
        
        // Display game statistics
        System.out.println("\nGame Over!");
        System.out.println("Total Rounds Played: " + rounds);
        System.out.println("Total Rounds Won: " + totalRoundsWon);
        System.out.println("Total Attempts: " + totalAttempts);
        double averageAttempts = (double) totalAttempts / rounds;
        System.out.printf("Average Attempts per Round: %.2f%n", averageAttempts);
    }
}
