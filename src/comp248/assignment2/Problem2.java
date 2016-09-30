package comp248.assignment2;

// -------------------------------------------------------
// Assignment 2. 
// Written by: Elias Al Homsi, id: 40027818
// For COMP 248 Section P (COMP-248-2162-P) – Fall 2016
// Question 2
// Date: 30 September 2016
// Purpose: Password Generator of 5 characters
// Input: 5 character string
// Output: Password output "shuffled and shifted string" or error messege depending on the input.
// --------------------------------------------------------

// We need this for input
import java.util.Scanner;

/**
 * To whom it may concern:
 *
 * This source code is the solution of Question 2 of Assignment 2.
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
 * 3) we check the number of characters and print the error message if necessary
 *      a) to check the number of characters we use the method .length() of the object String
 *      b) if myString.length() != 5 ==> error
 *      c) in case of error we would call System.exit(1);
 * 
 * 4) we use a while loop to inverse the String and shift each character 7 steps backwards
 *      pseudo code:
 *          for each character in the String "Reading Backwards"
 *                  Shift the character 7 steps bakcwards and add it to the new String.
 * 
 * 5) we print the output
 *
 * Variables: ("The naming convention is already clear, but just in case")
 * ------------------------------------------------------------------------
 * *Scanner input: is a Scanner object that we are going to use for input
 * 
 * *String userInput: the String given as input including spaces!!!
 * 
 * *String password: where we are saving the result
 * 
 * *int index: used to mark the index of the character used
 * 
 * *char currentCharacter: used as a temporary placeholder for the character to encode.
 * 
 * @author Elias Al Homsi
 * @id 40027818
 */
public class Problem2 {

    public static void main(String[] args) {
        // Declaration of variables
        Scanner input = new Scanner(System.in);
        String userInput = "", password = "";
        int index = 0;
        char currentCharacter = '\0';
        
        // Start Messege
        System.out.println("-----------------Start Program Welcome!------------------");
        System.out.println("---------------------------------------------------------");
        System.out.println("\t\t Nancy's Password Generator");
        System.out.println("---------------------------------------------------------");
        System.out.println();

        // Take Input
        System.out.print("Please enter a 5 character word which will be used to generate a password: \n");
        userInput = input.nextLine();

        // Check The String length != 5
        if(userInput.length() != 5) {
            System.out.println("\nSorry, but that is not a 5-character string. Program will terminate.");
            System.out.println("\nThank you for using Nancy's Password Generator program.");
            
            // End Messege
            System.out.println("----------------------End Program------------------------");
            System.exit(1);
        }
        
        // Getting the password
        index = userInput.length() -1;
        while(index >=0) {
            currentCharacter = userInput.charAt(index);
            // encoding
            currentCharacter = (char) (currentCharacter - 7);
            // adding to password
            password += currentCharacter;
            index--;
        }
        
        // Output the password
        System.out.println("Your password is "+ password);
        System.out.println();
        System.out.println("Thank you for using Nancy's Password Generator program.");
        // End Messege
        System.out.println("----------------------End Program------------------------");
    }
}
