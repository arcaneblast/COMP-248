// -------------------------------------------------------
// Assignment 4. 
// Written by: Elias Al Homsi, id: 40027818
// For COMP 248 Section P (COMP-248-2162-P) Fall 2016
// Question 2 The class file only Class ShoppingCart  
// Date: 24 November 2016
// Purpose: ShoppingCart Class which is a list of iceCreamOrders
// Input: a list of IceCreamOrder and a specific command: add, remove, get
// Output: the updated list and ToString Representation 
// -------------------------------------------------------

/**
 * The ShoppingCart class
 *
 * @version 1.4
 * @author it-elias@hotmail.com
 * @see driver class Program2, IceCreamOrder, IceCreamStore
 *
 * Attributes:
 * public static final int MAX_ITEMS = 5;
 * The max items specified for the cart 
 *
 * private int itemUsed: too keep track of howmany items are used
 *
 * private IceCreamOrder[] cart: the array that holds the IceCreamOrder
 */
public class ShoppingCart {
    //attributes
    public static final int MAX_ITEMS = 3; //The maximum size limit
    private int itemUsed;
    private IceCreamOrder[] cart;

    /** 
     * Default Constructor
     * ShoppingCart()
     * Creates an empty shopping cart with the maximum capacity allowed
     */
    public ShoppingCart() {
        this.cart = new IceCreamOrder[ShoppingCart.MAX_ITEMS];
        this.itemUsed = 0;
    }

    /**
     * void add(IceCreamOrder order)
     * Adds the supplied ice cream order to the cart, keeping track of the number of orders
     * in it.if the list is full, it prints an error message and ignores the request.
     * @param order IceCreamOrder: @see Class IceCreamOrder
     * if full it prints an error message and ignore
     */
    public void add(IceCreamOrder order) {
        //test error
        if(itemUsed >= this.cart.length) {
            //error! print and exit
            System.out.printf("The list is full\n");
            return;
        }

        //seems good
        cart[itemUsed] = order; //notice this is not optimal we should clone that. However, since clone is not overriden
        itemUsed++;
    }

    /**
     * void remove(int position)
     * @param position is a number: -1<position<itemsUsed that is position is in [0, itemUsed-1]
     * Removes an order at a specified position from the cart. If the list is empty or the
     * specified position is out of range, it prints an error message and ignores the request.
     */
    public void remove(int position) {
        //test error
        if(position < 0 || position >= itemUsed) {
            //error! print and exit
            System.out.printf("Position is wrong please enter a number between 0 %d inclusive\n", this.itemUsed-1);
            return;
        }

        //shift and delete
        for(int i=position; i<itemUsed-1; i++) {
            cart[i] = cart[i+1];
        }
        
        //let the garbage collector do his job
        cart[itemUsed-1] = null;

        //decrease the number of elements used
        itemUsed--;
    }

    @Override
    /**
     * String toString()
     * @return String:Returns a string representation of all ice cream orders in the cart separated by new
     * line characters.
     */
    public String toString() {
        String result = "";
        for(int i=0; i<itemUsed; i++) {
            result += cart[i] + "\n";
        }
        return result;
    }


    /**
     * boolean isEmpty()
     * @return True or false: Determines whether this cart is empty.
     */
    public boolean isEmpty() {
        //please notice that I am comparing to length instead to MAX because they could be different
        return (this.cart == null || this.itemUsed ==0 );
    }

    /**
     * boolean isFull()
     * @return True or false: Determines whether this cart is full.
     */
    public boolean isFull() {
        //please notice that I am comparing to length instead to MAX because they could be different
        return (this.cart != null && this.itemUsed == this.cart.length);
    }

    /**
     * IceCreamOrder get(int position)
     * @param postion: return the element at position
     * Returns the order placed at the supplied position in the cart. 
     * "If the specified position is out of range, it it prints an error message and returns null."
     * position is int [0, itemUsed-1]
     */
    public IceCreamOrder get(int position) {
        //check error
        if(position <0 || position >= itemUsed) {
            //error! print and return null
            System.out.printf("Position is wrong please enter a number between 0 %d inclusive\n", this.itemUsed-1);
            return null;
        }

        //seems good
        return cart[position]; //we should have used clone but it is not defined  PRIVACY LEAK 
    }

    /**
     * int size()
     * @return itemUsed integer
     * Returns the number of orders currently in the cart.
     */
    int size(){
        if(this.isEmpty())
            return 0;
        return itemUsed;
    }
}
