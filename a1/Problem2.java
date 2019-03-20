// -------------------------------------------------------
// Assignment 1. 
// Written by: Elias Al Homsi, id: 40027818
// For COMP 248 Section P (COMP-248-2162-P) – Fall 2016
// Question 2.
// Date: 17 September 2016
// Purpose: A Game of guessing a random number.
// Input: Maximum of 5 tries. Integers guessing the number.
// Output: Indications (higher or lower) and results.
// --------------------------------------------------------


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
 * --------
 * 1) All questions of the assignment are named Problem#. 2) # is the number of
 * the question. 3) Each problem has its own main method. 
 *
 * Steps (Algorithm):
 * ------------------
 * 1) We define all the variables we need. Including the random variable of
 * class Random.
 *
 * 2) We generate a random number using the nextInt method of the object random.
 *
 * 3) We may assume that the user will enter valid integers. So, we read user
 * input without processing.
 *
 * 4) We read the input of the first iteration of the loop and then we enter the main loop of the program.
 * We respond to user input by either too high or too low or found.
 *
 * 5) Output the result and end of the program.
 *
 * Variables: ("The naming convention is already clear, but just in case")
 * ------------------------------------------------------------------------
 * *Scanner input: is a Scanner object that we are going to use for input
 * 
 * *Random random: is a psuedo-random generator. We use it with the method nextInt()
 * 
 * *int numberToGuess: the user has to guess this number.
 * 
 * *boolean found: a variable used to check if the user was successful.
 * 
 * *int guessCount: an integer which is the counter of guesses the user used so far.
 * 
 * *String answer: is a String object that holds the answer of either too high or too low.
 *
 * @author Elias Al Homsi
 * @id 40027818
 */
public class Problem2 {

    public final static int MAXIMUM_TRIES = 5;

    public static void main(String[] args) {
        // Declaration
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        // random.nextInt(int bound) would give integer in the rage [0, bound). bound is not included.
        int numberToGuess = random.nextInt(101);
        boolean found = false;
        int guessCount = 1;

        // Start Messege
        System.out.println("-----------------Start Program Welcome!------------------");
        System.out.println("---------------------------------------------------------");
        System.out.println("\t  Pick a number, any number... ");
        System.out.println("---------------------------------------------------------");
        System.out.println();
        System.out.print("Pick a number between 0 and 100 (you have 5 guesses!): ");

        // Taking the first input and handling the first case
        int userInput = input.nextInt();
        if (userInput == numberToGuess) {
            found = true;
        } else if (userInput < numberToGuess) {
            System.out.println("You are too low!");
            System.out.println();
        } else {
            System.out.println("You are too high!");
            System.out.println();
        }

        // Main program loop
        while (!found && guessCount < MAXIMUM_TRIES) {
            System.out.print("Guess again: ");
            userInput = input.nextInt();
            guessCount++;

            // Defaulting to the low case.
            String answer = "You are too low!";

            if (userInput == numberToGuess) {
                found = true;
            } else if (userInput > numberToGuess) {
                answer = "You are too high!";
            }

            if (!found) {
                System.out.println(answer);
                System.out.println();
            }
        }

        if (found) {
            // Success
            System.out.println("You got it! It is indeed: " + numberToGuess);
        } else {
            System.out.println("Sorry you didn't guess the right number. The correct number is: " + numberToGuess + ". Better luck next time!");
        }
        // End Messege
        System.out.println("----------------------End Program------------------------");
    }
}
