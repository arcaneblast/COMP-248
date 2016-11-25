// -------------------------------------------------------
// Assignment 4. 
// Written by: Elias Al Homsi, id: 40027818
// For COMP 248 Section P (COMP-248-2162-P) Fall 2016
// Question 1 The class file only Menu
// Date: 24 November 2016
// Purpose: Menu Class 
// Input: OptionList, prompts and messages 
// Output: Output the menu, output the choice given by the user, Accessor methods 
// -------------------------------------------------------

// we need this for input
import java.util.Scanner;

/**
 * The Menu class
 *
 * @version 1.1
 * @author it-elias@hotmail.com
 * @see driver class Problem1
 *
 * Attributes: 
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
public class Menu {
    //attributes
    private String bottomPrompt, topPrompt;
    private String openingMessage, closingMessage;
    private String[] options;
    private final String introducer = "?->";  //final because it should not be changed.

    /**
     * default constructor which sets the five descriptive attributes to null 
     */
    public Menu() {
        bottomPrompt = null;
        topPrompt = null;
        openingMessage = null;
        closingMessage = null;
        this.options = new String[0];
    }

    /**
     * default constructor which sets the five descriptive attributes to null 
     */
    public Menu(String[] options) {
        this.options = options.clone();   //avoid leaks "deep copy"
        bottomPrompt = "Enter an option number:";
        topPrompt = "Choose an option:";
        openingMessage = null;
        closingMessage = null;
    }
    
    /**
     * isEmpty: returns true if the option list if either null or an empty list.
     * @return true if options is empty or null
     */
    public boolean isEmpty() {
        return (this.options == null || this.options.length == 0);
    }
    
    /**
     * length: returns returns the number of elements in the options 
     * @return integer the number of options 
     */
    public int length() {
        return (isEmpty()? 0 : this.options.length); 
    }


    @Override
    /**
     * ToString: prints the menu for the user as specified in the assignment
     */
    public String toString() {
        String result = "";
        //openning Message
        if(this.openingMessage != null) {
           result += this.openingMessage +'\n';
        }

        //topPrompt
        if(this.topPrompt != null) {
           result += this.topPrompt + '\n';
        }

        //options
        for(int i=0; i<this.length(); i++) {
            result += "\t(" + (i+1) + ") " + this.options[i] + '\n'; 
        }

        //closingMessage
        if(this.closingMessage != null) {
           result += this.closingMessage + '\n';
        }

        result += this.introducer + " ";
        //bottomPrompt
        if(this.bottomPrompt != null) {
           result += this.bottomPrompt;  
        }

        return result;
    }

    /**
     * getOptionNumber: A.k.a readOptionNumber
     * Since there is conflict between the description and code samples I have used the code samples
     * @return a good option number in the list of 1 to n inclusive
     */
    public int getOptionNumber() {
        //define the Scanner to read values
        Scanner input = new Scanner(System.in);

        //print menu
        System.out.print(this);
        
        //read value
        int n = input.nextInt();

        //if empty return value read
        if(this.isEmpty()) 
            return n;
        
        
        //force the user to give proper input
        while ( n<1 ||  n> this.length()) {
            //print menu
            System.out.print(this);
            n = input.nextInt();
        }

        //return value
        return n;
    }

    /**
     * getBottomMessage
     * @return this.closingMEssage String
     */
    public String getBottomMessage() {
        return this.closingMessage;
    }


    /**
     * getTopMessage
     * @return this.openingMessage String
     */
    public String getTopMessage() {
        return this.openingMessage;
    }

    /**
     * getBottomPrompt
     * @return this.bottomPrompt String
     */
    public String getBottomPrompt() {
        return this.bottomPrompt;
    }

    /**
     * getTopPrompt
     * @return this.topPrompt String
     */
    public String getTopPrompt() {
        return this.topPrompt;
    }

    /**
     * setBottomMessage
     * sets the bottomMessage String
     */
    public void setBottomMessage(String bottomMessage) {
        this.closingMessage = bottomMessage;
    }

    /**
     * setTopMessage
     * sets the topMessage String
     */
    public void setTopMessage(String topMessage) {
        this.openingMessage = topMessage;
    }

    /**
     * setBottomPrompt
     * sets the bottomPrompt String
     */
    public void setBottomPrompt(String bottomPrompt) {
       this.bottomPrompt = bottomPrompt; 
    }

    /**
     * setTopPrompt
     * sets the topPrompt String
     */
    public void setTopPrompt(String topPrompt) {
        this.topPrompt = topPrompt;
    }
}
