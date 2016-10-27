// -------------------------------------------------------
// Assignment 2. 
// Written by: Elias Al Homsi, id: 40027818
// For COMP 248 Section P (COMP-248-2162-P) – Fall 2016
// Question 1
// Date: 30 September 2016
// Purpose: Encrypting a 4 digit number
// Input: 4 digit number
// Output: encrypted output or error messege depending on the input.

// Trick TestCase: After asking the Prof the leading zeros in a number should be ignored!
// --------------------------------------------------------

// We need this for input
import java.util.Scanner;

/**
 * To whom it may concern:
 *
 * This source code is the solution of Question 1 of Assignment 2.
 *
 * Format:
 * --------
 * 1) All questions of the assignment are named Problem#. 2) # is the number of
 * the question. 3) Each problem has its own main method. 
 *
 * Steps (Algorithm):
 * ------------------
 * 1) First we define the variables we need
 * 
 * 2) we get the input from the user.
 * 
 * 3) we check the number of digits and print the error message if necessary
 *      a) to check the number of digits we count the number of times the number
 *          is divisable by 10 until it turns into 0.
 *      b) an easier way to do this is to check the number range >= 1000 and <= 9999
 *      c) in case the output is wrong we use System.exit(1);
 * 
 * 4) we extract the 4 digits using the same following algorithm.
 *      a) the digit is number % 10;
 *      b) number = number / 10;
 *      c) we repeat from a until we get number is equal to zero
 * 
 * 5) we encrypt each digit alone using the formula result = (digit + 7) mod 10;
 *      a) when we get the number modulus 10 the result should be in the range [0, 9]
 * 
 * 6) we swap 1st with 3rd and 2nd with forth and print
 *
 * Variables: ("The naming convention is already clear, but just in case")
 * ------------------------------------------------------------------------
 * *Scanner input: is a Scanner object that we are going to use for input
 *
 * *int numberGiven: is an integer that specifies the number input to encrypt
 * 
 * *int firstDigit, secondDigit, thirdDigit, forthDigit: are the integer placeholders for the extracted digits
 * 
 * @author Elias Al Homsi
 * @id 40027818
 */
public class Problem1 {

    public static void main(String[] args) {
        // Declaration of variables
        Scanner input = new Scanner(System.in);
        int numberGiven =0, firstDigit=0, secondDigit=0, thirdDigit=0, forthDigit=0;
        
        // Start Messege
        System.out.println("-----------------Start Program Welcome!------------------");
        System.out.println("---------------------------------------------------------");
        System.out.println("\t\t Nancy's 4-digit Encrypter");
        System.out.println("---------------------------------------------------------");
        System.out.println();

        // Take Input
        System.out.print("Please enter the four digit number you wish to encrypt: ");
        numberGiven = input.nextInt();

        // Check The number range [1000, 9999]
        if(numberGiven < 1000 || numberGiven > 9999) {
            System.out.println("\nSorry, but that is not a 4-digit number. Program will terminate.");
            System.out.println("\nThank you for using Nancy's 4-digit Encrypter program.");
            
            // End Messege
            System.out.println("----------------------End Program------------------------");
            System.exit(1);
        }
        
        // Input OK start extracting digits
        forthDigit = numberGiven % 10;
        thirdDigit = (numberGiven / 10) % 10;
        secondDigit = (numberGiven / 100) % 10;
        firstDigit = (numberGiven / 1000) % 10;
        
        // Encoding
        forthDigit = (forthDigit + 7) % 10;
        thirdDigit = (thirdDigit + 7) % 10;
        secondDigit = (secondDigit + 7) % 10;
        firstDigit = (firstDigit + 7) % 10;
        
        // Output in the right order
        System.out.println("\nThe encrypted version of your input is "+ thirdDigit + forthDigit + firstDigit+ secondDigit);
        System.out.println();
        System.out.println("Thank you for using Nancy's 4-digit Encrypter program.");
        // End Messege
        System.out.println("----------------------End Program------------------------");
    }
}
