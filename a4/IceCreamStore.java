// -------------------------------------------------------
// Assignment 4. 
// Written by: Elias Al Homsi, id: 40027818
// For COMP 248 Section P (COMP-248-2162-P) Fall 2016
// Question 2 The class file only Class IceCreamStore 
// Date: 24 November 2016
// Purpose: Stores a ShoppingCart and interacts with the customer through a set of predefined menus.
// Input: Interactive program that require the user to enter options depending on the status of the program
// Output: Show the state and ask the program for Input and with exit from the menu 
// -------------------------------------------------------

/**
 * The IceCreamStore class
 *
 * @version 1.3
 * @author it-elias@hotmail.com
 * @see driver class Program2, IceCreamOrder, ShoppingCart
 *
 * attributes:
 * private ShopingCart customerCart:
 * the cart used to store client requests
 * @see class ShoppingCart
 *
 */
public class IceCreamStore { 
    //attributes
    private ShoppingCart customerCart;

    /**
     * void placeOrder()
     * Creates an order using IceCreamOrders default constructor and places that order in
     * the cart
     */
    public void placeOrder() {
        //check if full
        if(this.customerCart.isFull()) {
            return;
        }
        this.customerCart.add(new IceCreamOrder());
    }

    /**
     * void deleteOrder()
     * Using a menu, displays a list of all of the orders in the cart as options, prompts for and
     * reads the option number associated with the order to be deleted, and then removes
     * that order from the cart. To avoid forcing the user to having to remove an order, the
     * method always adds an exit option at the end of the option list displayed by the menu
     */
    public void deleteOrder() {
        // find the option list
        String [] optionList = new String[this.customerCart.size()+1]; //+1 for exit

        for(int i=0; i<this.customerCart.size(); i++) {
            optionList[i] = this.customerCart.get(i).toString(); 
        }

        optionList[this.customerCart.size()] = "Exit this Menu";

        // construct the menu
        Menu m = new Menu(optionList);


        //get input from user
        int index = m.getOptionNumber();
        
        //get real index
        index--;
        if(index == this.customerCart.size()) {
            //exit was chosen
            System.out.println("Exit was selected!");
            return;
        }

        //delete the item selected by index
        this.customerCart.remove(index);
        System.out.println("The order you selected was deleted");
    }

    /**
     * double computeTotalPrice()
     * Returns the total price of all the items in the cart
     * @return double the total Price
     */
    public double computeTotalPrice() {
        double totalPrice = 0;
        for(int i=0; i<this.customerCart.size(); i++) {
            totalPrice += customerCart.get(i).price();
        }
        return totalPrice;
    }


    /**
     * void printTotalPrice()
     * Prints the total price of all the items in the cart
     */
    public void printTotalPrice() {
        //if empty exit
        if(this.customerCart.isEmpty()) 
            return;

        //print
        System.out.println("------------------------------------------------------");
        System.out.println("Total price of all your orders in the cart : $" + String.format("%.2f",this.computeTotalPrice()));
        System.out.println("------------------------------------------------------");
    }

    /**
     * void reviewOrders()
     * Prints a complete list of all orders in the cart.
     * Hint: uses ShopingCart.toString
     */
    public void reviewOrders() {
        //check if empty
        if(this.customerCart.isEmpty()) 
            return;
        

        //print
        System.out.println("Your current selections of our scrumptious ice creams");
        System.out.println("------------------------------------------------------");
        System.out.print(this.customerCart);
        System.out.println("------------------------------------------------------");
    }

    /**
     * void checkout()
     * Ideally, collects payment and arranges for pickup or delivery. In this assignment,
     * however, it first calls reviewOrders() and then printTotalPrice().
     */
    public void checkout() {
        //if empty exit
        if(this.customerCart.isEmpty()) 
            return;
        

        this.reviewOrders();
        this.printTotalPrice();
    }


    /**
     * void run()
     * Repeatedly displays the main menu and performs the user selected actions.
     */
    public void run() {
        System.out.println("");
        System.out.println("----------------------------------------");
        System.out.println("          START     PROGRAM             ");
        System.out.println("----------------------------------------");
        /*
         * First we need to construct the menu
         * 
         * Menu type1:
         * Your shopping cart contains 2 ice cream orders
         * 2 What would you like to do?
         * 3 (1) Place an order
         * 4 (2) Delete an order
         * 5 (3) Price the cart
         * 6 (4) List the cart
         * 7 (5) Proceed to checkout
         * 8 (6) Exit this menu
         * 9 ? - > Enter an option number :
         *
         * Menu type 2:
         * Your Shopping Cart is full with 5 ice cream orders .
         * 2 Cannot place orders ! what would you like to do?
         * 3 (1) Place an order
         * 4 (2) Delete an order
         * 5 (3) Price the cart
         * 6 (4) List the cart
         * 7 (5) Proceed to checkout
         * 8 (6) Exit this menu
         * 9 Please select option 2 , 3 , 4 , 5 , or 6
         * 10 ? - > Enter an option number :
         *
         * Menu type 3:
         * Your Shopping Cart is empty .
         * 2 You have only two options : 1 or 6
         * 3 (1) Place an order
         * 4 (2) Delete an order
         * 5 (3) Price the cart
         * 6 (4) List the cart
         * 7 (5) Proceed to checkout
         * 8 (6) Exit this menu
         * 9 Please enter 1 or 6
         * 10 ? - > Enter an option number :
         *
         */
        String [] options = {"Place an order"
        ,"Delete an order"
        ,"Price the cart" 
        ,"List the cart"
        ,"Proceed to checkout"
        ,"Exit this menu"};

        Menu menu = new Menu(options);

        int choice = 3; //random start value
        //initialize customerCart
        this.customerCart = new ShoppingCart();

        do {
            //check which menu type are we
            if(!this.customerCart.isFull() && !this.customerCart.isEmpty()) {
                //neither full nor empty
                menu.setTopMessage("Your shopping cart contains "+ this.customerCart.size() + " ice cream orders");
                menu.setTopPrompt("What would you like to do?");
                menu.setBottomMessage(null);
                menu.setBottomPrompt("Enter an option number :");
            }
            else if(this.customerCart.isEmpty()) {
                //empty
                menu.setTopMessage("Your Shopping Cart is empty .");
                menu.setTopPrompt("You have only two options : 1 or 6");
                menu.setBottomPrompt("Enter an option number :");
                menu.setBottomMessage("Please enter 1 or 6");
            }
            else {
                //full
                menu.setTopMessage("Your Shopping Cart is full with "+ShoppingCart.MAX_ITEMS +" ice cream orders .");
                menu.setTopPrompt("Cannot place orders ! what would you like to do?");
                menu.setBottomMessage("Please select option 2 , 3 , 4 , 5 , or 6");
                menu.setBottomPrompt("Enter an option number :");
            }
            
            //input from user
            choice = menu.getOptionNumber();
            System.out.println();

            switch(choice) {
                case 1:
                    this.placeOrder();
                    break;
                case 2:
                    this.deleteOrder();
                    break;
                case 3:
                    this.printTotalPrice();
                    break;
                case 4:
                    this.reviewOrders();
                    break;
                case 5:
                    this.checkout();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Error should never happen");
                    System.exit(1);
            }
            System.out.println();
        }while(choice != 6);

        System.out.println("Cheers!\n");
        System.out.println("----------------------------------------");
        System.out.println("            END     PROGRAM             ");
        System.out.println("----------------------------------------");
    };
    
}
