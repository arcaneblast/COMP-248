package comp248.assignment3;

// -------------------------------------------------------
// Assignment 3. 
// Written by: Elias Al Homsi, id: 40027818
// For COMP 248 Section P (COMP-248-2162-P) – Fall 2016
// Question 1
// Date: 22 October 2016
// Purpose: Writing Poems
// Input: 4 digit number
// Output: Random poems three lines at a time.
// -------------------------------------------------------

// We need this for random number generation
import java.util.Random;
// We need this for input
import java.util.Scanner;

/**
 * To whom it may concern:
 *
 * This source code is the solution of Question 1 of Assignment 3.
 *
 * Format: 
 * -------- 
 * 1) All questions of the assignment are named Problem#. 2) #
 * is the number of the question. 3) Each problem has its own main method.
 *
 * Steps (Algorithm): 
 * ------------------ 
 * 1) First we define the variables we need
 *
 * 2) we get the input from the user including the nouns and the adjectives
 *      a) we keep on reading until we get a value of bigger than 3 (min 3)
 *
 * 3) We generate random output
 *      a) We create a mapping boolean array in order to check which items have been used or not
 *      b) we pick a random choice from the elements left
 *      c) we get the right element and set it to used
 *      d) when the number of elements left is zero we reset.
 *
 * 4) ask the user for additional poems (y/n) if so repeat 3
 *
 * Variables: ("The naming convention is already clear, but just in case")
 * ------------------------------------------------------------------------
 * *Scanner input: is a Scanner object that we are going to use for input
 *
 * * int nounsCount = 0, adjectivesCount = 0 
 * the number of nouns and adjectives that are given as input from the user
 * 
 * * String[] nouns, adjectives 
 * the array that is used to hold the nouns and the adjectives
 * 
 * * boolean[] usedNouns, usedAdjectives;
 * the mapping array that shows which element are used and which element are not.
 * 
 * *char answer;
 * The user answer of (y/n) question
 *
 * @author Elias Al Homsi
 * @id 40027818
 */
public class Problem1 {

    /**
    This function returns a random number that is between 0 and max (including 0)
    * exluding max
    * @param max: the upper bound of the roll
    * @return integer in the range [0, max)
    **/
    public static int rollTheDice(int max) {
        Random random = new Random();
        //random.nextInt returns an integer between [0,max)
        return random.nextInt(max);
    }

    /**
     * This function counts the non-used items on the array (counts the false)
     * @param usedOrNot the mapping array to count false element
     * @return the number of items left in the original array
     */
    public static int itemsLeftCounter(boolean[] usedOrNot) {
        int result = 0;
        for (int i = 0; i < usedOrNot.length; i++) {
            if (!usedOrNot[i]) {
                result++;
            }
        }
        return result;
    }

    /**
     * This function takes an array, a mapping array and returns a random element.
     * @param items a String array that has elements
     * @param usedOrNot the mapping array that shows which items are used or not
     * @return a random string from items and mark it as used
     */
    public static String pickRandom(String[] items, boolean[] usedOrNot) {
        //get items left
        int itemsLeft = itemsLeftCounter(usedOrNot);

        //reset
        if (itemsLeft == 0) {
            itemsLeft = items.length;
            for (int i = 0; i < usedOrNot.length; i++) {
                usedOrNot[i] = false;
            }
        }

        //choice
        int choice = rollTheDice(itemsLeft);
        itemsLeft--;

        //find the item of number choice that is not used
        for (int i = 0; i < items.length; i++) {
            //element found
            if (choice == 0 && !usedOrNot[i]) {
                usedOrNot[i] = true;
                return items[i];
            } else if (!usedOrNot[i]) {
                choice--;
            }
            // if usedOrNot[i] then skip the used element
        }

        //should never arrive to here
        return "Error";
    }

    public static void main(String[] args) {
        // Declaration of variables
        Scanner input = new Scanner(System.in);
        int nounsCount = 0, adjectivesCount = 0;
        String[] nouns, adjectives;
        boolean[] usedNouns, usedAdjectives;
        char answer;

        // Start Messege
        System.out.println("-----------------Start Program Welcome!------------------");
        System.out.println("    -------------------------------------------------");
        System.out.println("     Do you want to write a poem?? Lets get started!!");
        System.out.println("    -------------------------------------------------");
        System.out.println();

        // Take Input nouns
        while (nounsCount < 3) {
            System.out.println("How may nouns ? min 3");
            nounsCount = input.nextInt();
        }

        // fill nouns array
        System.out.printf("Enter %d nouns\n", nounsCount);
        nouns = new String[nounsCount];
        for (int i = 0; i < nounsCount; i++) {
            nouns[i] = input.next();
        }
        usedNouns = new boolean[nounsCount];

        // Take Input adjectives
        while (adjectivesCount < 3) {
            System.out.println("How may adjectives? min 3");
            adjectivesCount = input.nextInt();
        }

        // fill adjectives array
        System.out.printf("Enter %d adjectives\n", adjectivesCount);
        adjectives = new String[adjectivesCount];
        for (int i = 0; i < adjectivesCount; i++) {
            adjectives[i] = input.next();
        }
        usedAdjectives = new boolean[adjectivesCount];

        //print poems
        System.out.println("\t\t------------------------------\n"
                + " \t\t    Here is my Java POEM!!\n"
                + " \t\t    ****LOOK AROUND****\n"
                + " \t\t------------------------------");
        do {
            for (int i = 0; i < 3; i++) {
                //get random nouns and adjective
                String noun = pickRandom(nouns, usedNouns);
                String adjective = pickRandom(adjectives, usedAdjectives);

                //indentation
                for (int j = -1; j < i; j++) {
                    System.out.print("\t");
                }
                
                System.out.println(adjective.toUpperCase() + " " + noun.toUpperCase());
            }
            
            //prompt for more poems
            System.out.print("Another Poem (y/n)?");
            answer = input.next().charAt(0);

        } while (Character.toLowerCase(answer) == 'y');
        // End Messege
        System.out.println("----------------------End Program------------------------");
    }
}
