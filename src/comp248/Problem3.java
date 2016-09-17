// -------------------------------------------------------
// Assignment 1. 
// Written by: Elias Al Homsi, id: 40027818
// For COMP 248 Section P (COMP-248-2162-P) – Fall 2016
// Question 3.
// --------------------------------------------------------
package comp248;

// We need this for formatting output
import java.text.DecimalFormat;
// We need this for input
import java.util.Scanner;

/**
 * To whom it may concern:
 *
 * This source code is the solution of Question 3 of Assignment 1.
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
 * 1) We define three functions that takes as input shows and movies and gives output as the price.
 * Please note, the unlimited package does not need a function. However, for readability one was created.
 *
 * 2) Declare variables and take input from the user. The number of shows was multiplied by 4 to get showsPerMonth.
 *
 * 3) We may assume that the user will enter valid integers. So, we read user input without processing.
 *
 * 4) We calculate the cost of each and every package. Then we compare in order to determine the best solution.
 *
 * 5) We use Decimal Formatter to output the results.
 *
 *Please note: the decimal formatter is essential to get output like 13.90 instead of 13.9
 * @author Elias Al Homsi
 * @id 40027818
 */
public class Problem3 {

    public static double payPerViewPrice(int shows, int movies) {
        // We could define the values 0.99 and 3.99 as constants
        double result = (0.99 * shows) + (3.99 * movies);
        return result;
    }

    public static double limitedPrice(int shows, int movies) {
        // We first caculate the overPackageUsage in each category
        int overPackageShows = shows - 20;
        if (overPackageShows < 0) {
            overPackageShows = 0;
        }

        int overPackageMovies = movies - 2;
        if (overPackageMovies < 0) {
            overPackageMovies = 0;
        }

        // return the result
        double result = 15.95 + (1.99 * overPackageShows) + (3.99 * overPackageMovies);
        return result;
    }

    public static double unlimitedPrice() {
        //made it into a function to improve readability.
        return 25.95;
    }

    public static void main() {
        // Declaration
        Scanner input = new Scanner(System.in);
        // Which option is the best. values(perView:1, Limited:2, Unlimited:3).
        int option = 1; // Defaulting to 1
        // We use a formatter for printing doubles in 2 numbers after the point.
        DecimalFormat priceFormatter = new DecimalFormat("$##.00");
        
        // Start Messege
        System.out.println("Start Program");
        System.out.println("---------------------------------------------------------");
        System.out.println("\t  CineShow's Package Calculator");
        System.out.println("---------------------------------------------------------");
        System.out.println();

        System.out.print("How many shows a week do you watch (whole number please):");
        int showPerMonth = input.nextInt() * 4;   // Convert to month

        System.out.print("How many movies a month do you watch (whole number please):");
        int moviesPerMonth = input.nextInt();
        System.out.println();

        // Caculating 
        double costPayPerView = payPerViewPrice(showPerMonth, moviesPerMonth);
        double costLimited = limitedPrice(showPerMonth, moviesPerMonth);
        double costUnlimited = unlimitedPrice();

        // Comparing and chosing the best option
        if (costLimited < costPayPerView) {
            option = 2;
        }
        if (costUnlimited < costLimited) {
            option = 3;
        }

        // Output
        System.out.println("The cost of Pay-per-view would be: " + priceFormatter.format(costPayPerView) + "/month");

        // Add the extra line in case of option 2 or 3
        if (option >= 2) {
            System.out.println("Based on your viewing, the cost of the Limited package would be: " + priceFormatter.format(costLimited) + "/month");
        }
        System.out.println();
        
        // Add the recommondation and savings.
        if (option >= 2) {
            String recommendedPackage = "Limited";
            if (option == 3) {
                recommendedPackage = "Unlimited";
            }

            System.out.println();
            System.out.println("**We recommend getting the " + recommendedPackage + " package.**");

            // Add the savings.
            if (option == 2) {
                System.out.println("You would save " + priceFormatter.format(costPayPerView - costLimited) + " from pay-per-view.");

            } else {
                System.out.println("You would save " + priceFormatter.format(costPayPerView - costUnlimited) + " from pay-per-view.");
                System.out.println("You would save " + priceFormatter.format(costLimited - costUnlimited) + " from the limited package"
                        + " and " + priceFormatter.format(costPayPerView - costUnlimited) + " from pay-per-view.");
            }
            System.out.println();
        }

        // End
        System.out.println("Thank you for using CineShow's package calculator program. Happy watching :-)!");
        // End Messege
        System.out.println("End Program");
    }
}
