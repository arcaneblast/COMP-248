// -------------------------------------------------------
// Assignment 1. 
// Written by: Elias Al Homsi, id: 40027818
// For COMP 248 Section P (COMP-248-2162-P) – Fall 2016
// Question 1
// Date: 17 September 2016
// Purpose: Categorizing students into Local, outOfProvince and International.
// Input: The number of students in each category.
// Output: The Percent of each category.
// --------------------------------------------------------

// We need this for input
import java.util.Scanner;

/**
 * To whom it may concern:
 *
 * This source code is the solution of Question 1 of Assignment 1.
 *
 * Format:
 * --------
 * 1) All questions of the assignment are named Problem#. 2) # is the number of
 * the question. 3) Each problem has its own main method. 
 *
 * Steps (Algorithm):
 * ------------------
 * 1) We define all the variables we need. For each category of student, we need
 * three variables representing the number, percentage in double and percentage
 * in an integer. Please note, the problem could be solved with fewer variables
 * but this will sacrifice readability.
 *
 * 2) We get input from the user using the Scanner object.
 *
 * 3) We may assume that the user will enter valid integers. However, the total
 * could be 0 which would lead to division by zero! A special case is used to
 * handle this situation.
 *
 * 4) We calculate the total, then the percentages of each category.
 *
 * 5) Output and end of the program.
 *
 * Variables: ("The naming convention is already clear, but just in case")
 * ------------------------------------------------------------------------
 * *Scanner input: is a Scanner object that we are going to use for input
 *
 * *int inProvince, outOfProvince, international: the number of students in
 * each category
 *
 * *int total: the sum of the three variables above. (The total number of
 * students).
 *
 * *double inProvincePercent, outOfProvincePercent, internationalPercent: the
 * percent of each category represented as a double value. For example 1% would
 * be 0.01.
 *
 * *int inProvinceIntegerPercent, outOfProvinceIntegerPercent,
 * internationalIntegerPercent: the percentage of each category represennted as
 * an integer. For example 1% would be 1.
 *
 *
 * @author Elias Al Homsi
 * @id 40027818
 */
public class Problem1 {

    public static void main(String[] args) {
        // Declaration of variables
        Scanner input = new Scanner(System.in);
        int inProvince = 0, outOfProvince = 0, international = 0, total = 0;
        double inProvincePercent = 0, outOfProvincePercent = 0, internationalPercent = 0;
        int inProvinceIntegerPercent = 0, outOfProvinceIntegerPercent = 0, internationalIntegerPercent = 0;

        // Start Messege
        System.out.println("-----------------Start Program Welcome!------------------");
        System.out.println("---------------------------------------------------------");
        System.out.println("\t  Student Stats -- Where are they coming from?");
        System.out.println("---------------------------------------------------------");
        System.out.println();

        System.out.print("How many in-province students are there?");
        inProvince = input.nextInt();

        System.out.print("How many out-of-province students are there?");
        outOfProvince = input.nextInt();

        System.out.print("How many international students are there?");
        international = input.nextInt();

        total = international + outOfProvince + inProvince;

        // Special case. Please note all variables are already by default zero.
        if (total == 0) {
            // Output
            System.out.println("\nGreat! There are " + total + " in the class.");
            System.out.println("\tIn-province students: " + inProvincePercent + " or ~" + inProvinceIntegerPercent + "%");
            System.out.println("\tOut-of-province students: " + outOfProvincePercent + " or ~" + outOfProvinceIntegerPercent + "%");
            System.out.println("\tInternational students: " + internationalPercent + " or ~" + internationalIntegerPercent + "%");
            System.out.println("**Have a great term!**");
            // End Messege
            System.out.println("----------------------End Program------------------------");

            // Exit: we could have used System.exit(0)
            return;
        }

        // Caculating the percentage; we are using 1.0 to cast to double
        inProvincePercent = (inProvince * 1.0) / total;
        outOfProvincePercent = (outOfProvince * 1.0) / total;
        internationalPercent = (international * 1.0) / total;

        // Calculating the integer percent.
        inProvinceIntegerPercent = (inProvince * 100) / total;
        outOfProvinceIntegerPercent = (outOfProvince * 100) / total;
        internationalIntegerPercent = (international * 100) / total;

        // Output
        System.out.println("\nGreat! There are " + total + " in the class.");
        System.out.println("\tIn-province students: " + inProvincePercent + " or ~" + inProvinceIntegerPercent + "%");
        System.out.println("\tOut-of-province students: " + outOfProvincePercent + " or ~" + outOfProvinceIntegerPercent + "%");
        System.out.println("\tInternational students: " + internationalPercent + " or ~" + internationalIntegerPercent + "%");
        System.out.println("**Have a great term!**");
        // End Messege
        System.out.println("----------------------End Program------------------------");
    }
}
