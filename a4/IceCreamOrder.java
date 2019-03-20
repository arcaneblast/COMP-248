// -------------------------------------------------------
// Assignment 4. 
// Written by: Elias Al Homsi, id: 40027818
// For COMP 248 Section P (COMP-248-2162-P) Fall 2016
// Question 2 The class file only IceCreamOrder 
// Date: 24 November 2016
// Purpose: IceCreamOrder Class 
// Input: amount, vessel, quanity, unitPrice, flavor 
// Output: Output the order in String representation
// -------------------------------------------------------

/**
 * The IceCreamOrder class
 *
 * @version 1.3
 * @author it-elias@hotmail.com
 * @see driver class Program2, ShoppingCart, IceCreamStore
 *
 * Although names are clear we will redefine them.
 *
 * Attributes: 
 * String flavor: the flavor of the icecream
 * String vessel: the vessel type
 * String amount: the amount of the iceCream
 * double unitPrice: the unit price of the icecream
 * int quantity: how many units
 */
public class IceCreamOrder {
    //attributes
    private String flavor;
    private String vessel;
    private String amount;
    private double unitPrice;
    private int quantity;


    /**
     * double price()
     * @return the total price of this order this.unitPrice * this.quantity
     */
    public double price() {
        return this.unitPrice * this.quantity;
    }

    /**
     * String getFlavor()
     * @return the String falvour
     */
    public String getFlavor() {
        return this.flavor;
    }

    /**
     * void setFlavor(String flavor)
     * @param flavor the new flavor String
     */
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    /**
     * String getVessesl()
     * @return String vessel
     */
    public String getVessel() {
        return this.vessel;
    }

    /**
     * void setVessel(vessel)
     * @param String vessel the new vessel type
     */
    public void setVessel(String vessel) {
        this.vessel = vessel;
    }

    /**
     * String getAmount()
     * @return String amount as string
     */
    public String getAmount() {
        return this.amount;
    }

    /**
     * void setAmount(String amount)
     * @param amount the new amount as String
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * double getUnitPrice()
     * @return double this.unitPrice
     */
    public double getUnitPrice() {
        return this.unitPrice;
    }

    /**
     * void setUnitPrice(double unitPrice)
     * @param double unitPrice: the new unitPrice
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * int getQuantity()
     * @return int quantity: this.quanitiy
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * void setQuantity(int quanitiy) 
     * @param int quanitiy: the new quanitity
     */
    public void setQuantity(int quanitty) {
        this.quantity = quantity;
    }

    @Override
    /**
     * String toString()
     * @return String: The order in the string format:
     * ex:4 orders of Triple Scoops of Avocado
     * ice cream in a Cup for (9.96 = 4 x 4.99)
     */
    public String toString() {
        //we define the exact format we want and return String.format (Just like printf but save it in a String instead)
        return String.format("%d order%s of %s of %s ice cream in a %s for $%.2f = %d x %.2f",
                quantity, (quantity <=1 ? "" : "s") , amount, flavor, vessel, this.price(), quantity, unitPrice);
    }

    /**
     * Normal Constructor
     * Constructor: IceCreamOrder(String flavor, String vessel, String amount, double unitPrice, int quantity)
     * @param flavor
     * @param vesel
     * @param amount
     * @param unitPrice
     * @param quantity
     * all attributes
     * N.B: defining the optionlists inside the constructor is not the optimal approach, however, I am following documentation :P.
     */
    public IceCreamOrder(String flavor, String vessel, String amount, double unitPrice, int quantity) {
        this.flavor = flavor;
        this.vessel = vessel;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }
        

    /**
     * Constructor where Quantity is 1 
     * Constructor: IceCreamOrder(String flavor, String vessel, String amount, double unitPrice) 
     * @param flavor
     * @param vesel
     * @param amount
     * @param unitPrice
     * all attributes except quantity which is default to 1
     */
    public IceCreamOrder(String flavor, String vessel, String amount, double unitPrice) {
        //use the constructor already defined
        this(flavor, vessel, amount, unitPrice, 1);
    }
    
    /**
     * Default constructor
     * This constructor use the Menu Class to initialize its attributes 
     */
    public IceCreamOrder() {
        //use the Menu class
        Menu m; 

        //1.flavor
        String [] flavorList = {"Avocado",
        "Banana",
        "Chocolate",
        "Coffe",
        "Hazelnut",
        "Lemon",
        "Mango",
        "Mocha",
        "Vanilla"};

        m = new Menu(flavorList);
        m.setTopMessage("Placing an order is as easy as ABC , and D.");
        m.setTopPrompt("Step A: Select your favorite flavour");
        m.setBottomPrompt("Enter an option number :");

        //save the flavor choice
        int flavor = m.getOptionNumber();

        //2.vessel
        String [] vesselList = {"Cone",
        "Cup",
        "Sundae"};

        m = new Menu(vesselList);
        m.setTopPrompt("Step B: Select a vessel for your ice cream :");
        m.setBottomPrompt("Enter an option number :");
        
        //save the vessel choice
        int vessel = m.getOptionNumber();
        
        //3.amount
        String [] amountList = {"Single Scoop",
        "Double Scoop",
        "Triple Scoop"};

        m = new Menu(amountList);
        m.setTopPrompt("Step C: How much ice cream ?");
        m.setBottomPrompt("Enter an option number :");

        //save the amount choice
        int amount = m.getOptionNumber();
        
        //4.quantity
        String [] quantityList= {"One",
        "Two",
        "Three",
        "Four",
        "Five",
        "Six",
        "Seven",
        "Eight",
        "Nine",
        "Ten"};

        m = new Menu(quantityList);
        m.setTopMessage(null);
        m.setTopPrompt("Step D: how many orders of your current selection ?");
        m.setBottomPrompt("Enter an option number :");

        //save the quantity choice
        int quantity = m.getOptionNumber(); 

        //5.price
        double priceMatrix[][] = {   //Single, Double, Triple
            //cone
            {3.49, 4.49, 5.49},
            //cup
            {2.99, 3.99, 4.99},
            //sundae
            {4.25, 5.25, 6.25},
        };

        //finally construct the object
        this.flavor = flavorList[flavor - 1] ;
        this.vessel = vesselList[vessel - 1]; 
        this.amount = amountList[amount - 1];
        this.unitPrice = priceMatrix[vessel-1][amount-1];
        this.quantity = quantity;
    }
        
}
