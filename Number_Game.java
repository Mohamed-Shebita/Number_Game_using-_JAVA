/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package number_game;

/**
 *
 * @author Mohamed_Shebita
 */
import java.util.Scanner;

public class Number_Game {
    public static void main(String[] args) {
        Scanner Key = new Scanner(System.in);
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 5;
        int score = 0;

        System.out.println("Welcome to the Guessing Numbers Game!");

        boolean playAgain = true;
        while (playAgain) {
            int randomNumber = RandomNumber(minRange, maxRange);
            int attempts = 0;
            boolean guessedCorrect = false;

            System.out.println("\nI picked a number between " + minRange + " and " + maxRange + ". ARE you ready?");

            while (!guessedCorrect && attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                int Guess = Key.nextInt();
                attempts++;

                if (Guess == randomNumber) {
                    System.out.println("AMAZING!! You guessed the correct number in " + attempts + " attempts.");
                    score += attemptsLimit - attempts + 1;
                    guessedCorrect = true;
                } else if (Guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrect) {
                System.out.println("Sorry,your attempts are finished. The correct number was: " + randomNumber);
            }

            System.out.print("\nDo you want to play again? write (yes/no): ");
            String playAgainChoice = Key.next().toLowerCase();
            if (!playAgainChoice.equals("yes")) {
                playAgain = false;
            }
        }
        System.out.println("\nWe are glad for meeting you! Your total score is: " + score);
        Key.close();
    }

    private static int RandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}

