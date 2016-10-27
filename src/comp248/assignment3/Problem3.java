package comp248.assignment3;

// -------------------------------------------------------
// Assignment 3. 
// Written by: Elias Al Homsi, id: 40027818
// For COMP 248 Section P (COMP-248-2162-P) – Fall 2016
// Question 3 Driver class
// Date: 27 October 2016
// Purpose: Driver class for Scale
// Input: Test the functionality of the class as defined in the asignment 
// Output: The values expected and given should match
// -------------------------------------------------------

// We need this for input
import java.util.Scanner;

/**
 * To whom it may concern:
 *
 * This source code is the solution of Question 3 of Assignment 3. This is only
 * the driver class of Scale.
 *
 * Format: 
 * -------- 
 * 1) All questions of the assignment are named Problem#. 
 * 2) #is the number of the question. 
 * 3) Each problem has its own main method.
 *
 * @author Elias Al Homsi
 * @id 40027818
 */
public class Problem3 {

    public static void main(String[] args) {
        // Declaration of variables
        Scanner input = new Scanner(System.in);
        Scale weight1, weight2, weight3, weight4;

        // Start Messege
        System.out.println("-----------------Start Program Welcome!------------------");
        System.out.println("---------------------------------------------------------");
        System.out.println("----------       Test Scale Class!       ----------------");
        System.out.println("---------------------------------------------------------");
        System.out.println();

        //create weight 1,2,3
        weight1 = new Scale();
        weight2 = new Scale(50.0);
        weight3 = new Scale(false, 110.0);

        System.out.println("Weight 1: " + weight1);
        System.out.println("Weight 2: " + weight2);
        System.out.println("Weight 3: " + weight3);
        System.out.println();

        //convert weight2 to punds and weight 3 to kg
        System.out.println("Weight 2 in pounds: " + weight2.getPd());
        System.out.println("Weight 3 in kg: " + weight3.getKg());
        System.out.println();

        //calculate water intake for weight 2 and 3
        System.out.println("Daily water intake for : " + weight2 + " = " + weight2.waterIntake()+ " cups");
        System.out.println("Daily water intake for : " + weight3 + " = " + weight3.waterIntake()+ " cups");
        System.out.println("Daily water intake for : " + weight2 + " and 90min workout= " + weight2.waterIntake(90)+ " cups");
        System.out.println("Daily water intake for : " + weight3 + " and 60min workout= " + weight3.waterIntake(60)+ " cups");
        System.out.println();

        //test if weights 1, 2, 3 are equal
        System.out.printf("Weight %d Weight %d %s & %s =? %s \n", 1, 2, weight1, weight2, weight1.equals(weight2));
        System.out.printf("Weight %d Weight %d %s & %s =? %s \n", 2, 3, weight2, weight3, weight2.equals(weight3));
        System.out.println();

        //Modify weight 1: 50.0 kg
        weight1.setWeightAndUnit(50.0, true);
        System.out.println("Modify weight 1: " + weight1);
        
        //test if weights 1, 2, 3 are equal
        System.out.printf("Weight %d Weight %d %s & %s =? %s \n", 1, 2, weight1, weight2, weight1.equals(weight2));
        System.out.printf("Weight %d Weight %d %s & %s =? %s \n", 1, 3, weight1, weight3, weight1.equals(weight3));
        System.out.println();

        //create weight 4
        weight4 = new Scale(false, 50.0);
        System.out.println("Weight 4: " + weight4);
        //test if weights 4, 2, 3 are equal
        System.out.printf("Weight %d Weight %d %s & %s =? %s \n", 4, 2, weight4, weight2, weight4.equals(weight2));
        System.out.printf("Weight %d Weight %d %s & %s =? %s \n", 4, 3, weight4, weight3, weight4.equals(weight3));
        System.out.println();
        
        
        //Compare weights using your isLessThan and isGreaterThan Methods.
        System.out.printf("Weight %d < Weight %d? %s < %s =? %s \n", 2, 4, weight2, weight4, weight2.isLessThan(weight4));
        System.out.printf("Weight %d < Weight %d? %s < %s =? %s \n", 3, 4, weight3, weight4, weight3.isLessThan(weight4));
        System.out.println();
        
        System.out.printf("Weight %d > Weight %d? %s > %s =? %s \n", 2, 4, weight2, weight4, weight2.isGreaterThan(weight4));
        System.out.printf("Weight %d > Weight %d? %s > %s =? %s \n", 3, 4, weight3, weight4, weight3.isGreaterThan(weight4));
        System.out.println();
        
        System.out.printf("Weight %d < Weight %d? %s < %s =? %s \n", 1, 2, weight1, weight2, weight1.isLessThan(weight2));
        System.out.printf("Weight %d > Weight %d? %s > %s =? %s \n", 1, 3, weight1, weight3, weight1.isGreaterThan(weight3));
        System.out.println();
        
        // End Messege
        System.out.println("----------------------End Program------------------------");
    }
}
