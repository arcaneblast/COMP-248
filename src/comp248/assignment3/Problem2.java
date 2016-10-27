package comp248.assignment3;

// -------------------------------------------------------
// Assignment 3. 
// Written by: Elias Al Homsi, id: 40027818
// For COMP 248 Section P (COMP-248-2162-P) – Fall 2016
// Question 2
// Date: 22 October 2016
// Purpose: Seat reserving software
// Input: How many and which seats to reserve
// Output: The status of the reservation, the balance and the show hall.
// -------------------------------------------------------
// We need this for input
import java.util.Scanner;

/**
 * To whom it may concern:
 *
 * This source code is the solution of Question 2 of Assignment 3.
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
 * 2) We print a welcome message, the hall, and the categories of the tickets.
 *
 * 3) ask for the number of tickets the clients want.
 * 
 * 4) check if the number of tickets is bigger than the tickets available
 *      a) if bigger exit program and print sorry
 * 5) a for loop for each ticket
 *      a) read input of seat location
 *      b) test the input if valid
 *      c) test the row if valid
 *      d) test the seat if valid
 *      e) test if the seat is taken
 * 
 * 6) after passing all the tests we would reserve the seat show balance and go back to 5
 * 
 * 7) when finishing the reservation we prompt for (y/n) "next client" if so go to 3
 * 
 * Variables: ("The naming convention is already clear, but just in case")
 * ------------------------------------------------------------------------
 * *Scanner input: is a Scanner object that we are going to use for input
 *
 * *int tickets: the number of tickets that the customer wants to reserve
 * 
 * *int seatsLeft: the number of non reserved seats: init to 42
 * 
 * *int[] ticketPrices: an array that has three categories of prices
 * 
 * *boolean[][] hall: if true is reserved, false mean the seat is empty
 * 
 * *String clientInput: the seat that the clients wants to reserve
 * 
 * *int balance: the total balance for a specific client
 * 
 * *char answer: has the answer for (y/n) question
 * 
 * *char row, seat: to handle row and seat validation cases.
 * 
 * @author Elias Al Homsi
 * @id 40027818
 */
public class Problem2 {

    /**
     * This function takes a boolean matrix of the hall and prints the available
     * location
     *
     * @param hall a boolean 2d array that saves the status of available seats
     * hall[i][j] : seat ij is taken
     * !hall[i][j]: seat ij is not taken
     */
    public static void printHallStatus(boolean[][] hall) {
        for (int i = 0; i < 6; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 7; j++) {
                
                //not taken
                if (!hall[i][j]) {
                    System.out.print((char) (j + 'A') + " ");
                } else {
                    System.out.print('X' + " "); //taken
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Declaration of variables
        Scanner input = new Scanner(System.in);
        int tickets = 0, seatsLeft = 6 * 7;
        int[] ticketPrices = new int[3];
        String[] ticketNames = new String[3];
        boolean[][] hall = new boolean[6][7];
        String clientInput = "";
        int balance = 0;
        char answer = 'n', row, seat;

        //Init tickets
        ticketPrices[0] = 100;
        ticketNames[0] = "Gold";
        ticketPrices[1] = 70;
        ticketNames[1] = "Silver";
        ticketPrices[2] = 40;
        ticketNames[2] = "Bronze";

        // Start Messege
        System.out.println("-----------------Start Program Welcome!------------------");
        System.out.println("---------------------------------------------------------");
        System.out.println("----------COMP248 Concert IS BACK IN TOWN----------------\n"
                + "             Hurry book your ticket Now!!");
        System.out.println("---------------------------------------------------------");
        System.out.println();

        // print Hall status 
        printHallStatus(hall);

        // print tickets ranges
        for (int i = 0; i < 3; i++) {
            System.out.printf("Rows %d & %d %-6s  %4d CAD/ticket\n", (i*2)+1, (i*2)+2, ticketNames[i], ticketPrices[i]);
        }

        // main program loop
        do {
            System.out.println("How many tickets do you need?");
            tickets = input.nextInt();

            System.out.println("Available seats " + seatsLeft);

            //check tickets compared to seats left.
            if (tickets > seatsLeft) {
                System.out.println("Sorry cannot process your request");
                System.out.println("No more seat are available");
                System.out.println("Thank you for choosing our reservation system!!");
                System.exit(0);
                System.out.println("----------------------End Program------------------------");
            }

            //init 
            balance = 0;
            
            for (int i = 0; i < tickets; i++) {
                System.out.println("Input your seat selection");
                System.out.println("Enter the row number and then the seat letter (example: 3B)");
                clientInput = input.next();

                //non-logical seat
                if (clientInput.length() != 2) {
                    System.out.println("Invalid Seat assignment");
                    i--; //retake the order
                    continue;
                }

                row = clientInput.charAt(0);
                seat = clientInput.charAt(1);

                //error in row
                if (row > '6' || row < '1') {
                    System.out.println("Invalid row number -try again");
                    i--; //retake the order
                    continue;
                }

                //error in seat
                if (seat > 'G' || seat < 'A') {
                    System.out.println("Invalid Seat letter -try again");
                    i--; //retake the order
                    continue;
                }

                //already reserved
                if (hall[row - '1'][seat - 'A']) {
                    System.out.println("Sorry seat is not available");
                    i--; //retake the order
                    continue;
                }
                
                
                //passed all tests
                seatsLeft--;
                hall[row-'1'][seat-'A'] = true;
                balance += ticketPrices[(row - '1') / 2];
                System.out.printf("Your seat is reserved. Your balance is %d.0\n", balance);
                printHallStatus(hall);
            }
            System.out.println("Reservation complete! Please proceed to payment");
            System.out.print("Do you wish to start a new booking? (y/n)?");
            answer = input.next().charAt(0);

        } while (Character.toLowerCase(answer) == 'y');
        // End Messege
        System.out.println("----------------------End Program------------------------");
    }
}
