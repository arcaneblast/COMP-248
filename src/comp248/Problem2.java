// -------------------------------------------------------
// Assignment 1. 
// Written by: Elias Al Homsi, id: 40027818
// For COMP 248 Section P (COMP-248-2162-P) – Fall 2016
// Question 2.
// --------------------------------------------------------
package comp248;

// We need this for generating the Random number
import java.util.Random;
// We need this for input
import java.util.Scanner;

/**
 * To whom it may concern:
 *
 * This source code is the solution of Question 2 of Assignment 1.
 *
 * Format:
 *
 * 1) All questions of the assignment are named Problem#. 2) # is the number of
 * the question. 3) Each problem has its own main method. 4) All of them are
 * part of the package comp248. 5) All of them start with Start Program and end
 * with End Program.
 *
 * Steps (Algorithm):
 *
 * 1) We define all the variables we need. Including the random variable of
 * class Random.
 *
 * 2) We generate a random number using the nextInt method of the object random.
 *
 * 3) We may assume that the user will enter valid integers. So, we read user
 * input without processing.
 *
 * 4) We check input and print the correct messege (Too high, Too low or exact).
 *
 * 5) Output the guessCount and end of the program.
 *
 *
 * @author Elias Al Homsi
 * @id 40027818
 */
public class Problem2 {

    public static void main() {
        // Declaration
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        // random.nextInt(int bound) would give integer in the rage [0, bound). bound is not included.
        int numberToGuess = random.nextInt(101);
        boolean found = false;
        int guessCount = 0;

        // Start Messege
        System.out.println("Start Program");
        System.out.println("---------------------------------------------------------");
        System.out.println("\t  Pick a number, any number... ");
        System.out.println("---------------------------------------------------------");
        System.out.println();

        System.out.println("Pick a number between 0 and 100");
        System.out.println();

        // Main program loop
        while (!found) {
            System.out.print("Enter your guess: ");
            int userInput = input.nextInt();
            guessCount++;

            // Defaulting to the low case.
            String answer = "You are too low - guess again!";

            if (userInput == numberToGuess) {
                found = true;
            } else if (userInput > numberToGuess) {
                answer = "You are too high - guess again!";
            }

            if (!found) {
                System.out.println(answer);
                System.out.println();
            }
        }
        
        // Success
        System.out.println("You got it! It is indeed: " + numberToGuess);
        System.out.println("It only took you: " + guessCount + " guesses to get it right!");

        // End Messege
        System.out.println("End Program");
    }
}
