// -------------------------------------------------------
// Assignment 4. 
// Written by: Elias Al Homsi, id: 40027818
// For COMP 248 Section P (COMP-248-2162-P) Fall 2016
// Question 1 The driver class for Menu 
// Date: 24 November 2016
// Purpose: Driver class for the Menu Class 
// Input: already made test code provided as part of the assignment 
// Output: the expected output 
// -------------------------------------------------------


/**
 * The Driver class
 *
 * @version 1.2
 * @author it-elias@hotmail.com
 * @see Menu class 
 *
 * Attributes of the Menu class: 
 * String bottomPrompt: the bottom prompt of the menu
 * String topPrompt: the top prompt of the menu
 * String openingMessage: the opening message of the menu
 * String the closingMessage: the closing message of the menu
 * final String introducer = "?->" the default prompt which is constant across the program
 *
 * the output to String would give:
 * -------------------------------- 
 * Opening Message
 * Top Prompt
 * (1) Option one
 * (2) Option two
 * (3) Option three
 * (..) ...
 * (n) Option n
 * Closing Message
 * ?-> Bottom Prompt
 * -------------------------------- 
 *
 */


public class Problem1 {
    public static void main(String [] args) {
        //sample code 1
        System.out.println("\n Sample Code 1 \n");
        String[] drink_options = {"Water", "Soda pop", "Beer"};
        // create a menu of drink options
        Menu drinkMenu = new Menu(drink_options); //no messages, default prompts
        // display the menu
        System.out.println(drinkMenu); // calls drinkMenu.toString()


        //sample code 2
        System.out.println("\n Sample Code 2 \n");
        //remove prompts
        drinkMenu.setTopPrompt(null);
        drinkMenu.setBottomPrompt(null);
        // display the menu
        System.out.println(drinkMenu); // calls drinkMenu.toString()


        //sample code 3
        System.out.println("\n Sample Code 3 \n");
        String[] option_list = {"Water", "Soda pop", "Beer"};
        Menu full_menu = new Menu(option_list);//no messages, default prompts
        //introduce messages
        full_menu.setTopMessage("Quench your thirst with our fine drinks!");
        full_menu.setBottomMessage("Time to obey your thirst!");
        // reset prompts
        full_menu.setTopPrompt("Choose your thirst crusher:");
        full_menu.setBottomPrompt("Enter a drink number: ");
        // display the menu and then read an option number
        int choice = full_menu.getOptionNumber();
        System.out.println( "You entered " + choice  );


        //sample code 4
        System.out.println("\n Sample Code 4 \n");
        // create an empty menu
        Menu m = new Menu(); // no messages, no prompts, no options
        // read an integer
        int number1 = m.getOptionNumber();
        System.out.println("You entered " + number1);
        System.out.println("----------------------");
        // introduce bottom prompt
        m.setBottomPrompt("Enter an integer for bottom prompt: ");
        // read an integer
        int number2 = m.getOptionNumber();
        System.out.println("You entered " + number2);
        System.out.println("----------------------");
       
        //sample code 5
        System.out.println("\n Sample Code 5 \n");
        //remove bottom prompt
        m.setBottomPrompt(null);
        // introduce bottom message
        m.setBottomMessage("Enter an integer for bottom message: ");
        // read an integer
        int number3 = m.getOptionNumber();
        System.out.println("You entered " + number3);
        System.out.println("----------------------");


        //sample code 6
        System.out.println("\n Sample Code 6 \n");
        //introduce top message
        m.setTopMessage("*************************************************");
        // introduce top prompt
        m.setTopPrompt("An integer is even if it is twice another integer");
        // reset bottom message
        m.setBottomMessage("*************************************************");
        // intro bottom prompt
        m.setBottomPrompt("Enter an even integer: ");
        // read an integer
        int number4 = m.getOptionNumber();
        System.out.println("You entered " + number4);
         
    }
}
