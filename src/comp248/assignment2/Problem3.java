package comp248.assignment2;

// -------------------------------------------------------
// Assignment 2. 
// Written by: Elias Al Homsi, id: 40027818
// For COMP 248 Section P (COMP-248-2162-P) – Fall 2016
// Question 3
// Date: 30 September 2016
// Purpose: Implementation of the DrawAnElephant Game
// Input: There is no interaction required from the user.
// Output: The status after each player rolls and at the end the result of the game.
// --------------------------------------------------------
// We need this for input
import java.util.Scanner;

/**
 * To whom it may concern:
 *
 * This source code is the solution of Question 3 of Assignment 2.
 *
 * Format: 
 * -------- 
 * 1) All questions of the assignment are named Problem#. 
 * 2) # is the number of the question. 
 * 3) Each problem has its own main method.
 *
 * Steps (Algorithm): 
 * ------------------ 
 * 1) First we define the variables we need
 *      a) we need to define boolean variables for each player
 *      b) the quantitiy left to draw and the ability to draw
 *      c) the boolean gameEnd which would be used for the while loop
 *      d) Player1Win boolean: if false it means that player 2 wins.
 *      e) round counter
 *      f) a function for rolling the dice.
 *
 * 2) we initialize the game by setting the body to drawable.
 * 
 * 3) we enter the while loop which has a switch statement for handling the cases.
 *      a) each switch statement would check if the element is drawable or not
 *      b) it would also check how many left to draw
 *      c) once able to draw it would check wether other elements just became drawable. (ears after head).
 *      d) if drawable we would decrement the number left to draw by 1.
 * 
 * 4) inside the while loop we print the status of each round.
 *      a) the roll of player1 and player2 and their body parts so far.
 * 
 * 5) we would check now to see if anyone has won. In that case the while loop would end. 
 *      a) we would save only one boolean variable in order to show if player1 or player2 has won.
 * 
 * 5) we print the result of the game
 *
 * Variables: ("The naming convention is already clear, but just in case")
 * ------------------------------------------------------------------------
 * *Scanner input: is a Scanner object that we are going to use for input
 *
 * *boolean player<#>CanDraw<BodyPart>: This general format which would require us to define 6 booleans
 *  for each player specify whether player # could draw <bodyPart> or not.
 *
 * *int player<#><BodyPart>Left: This genral format would require us to define 6 integers for each player.
 *      this would define how many of <BodyPart> the player <#> has to draw yet.
 *
 * *boolean gameEnd: The sentinel of the while loop. When it turns to true the while loop would end.
 * 
 * *int round: the round counter. It holds the number of the current round
 * 
 * *boolean player1Win: it determines the result of the game. In case of false, player2 wins. In case of 
 *      True Player1 wins.
 * 
 * *int player1Roll, player2Roll: Integers holding the rolling value (RollTheDice).
 *
 * @author Elias Al Homsi
 * @id 40027818
 */
public class Problem3 {

    /**
     * This function is used to roll the dice. Returns an integer in the range
     * of [1,6]
     *
     * @return integer [0,6]
     */
    public static int rollTheDice() {
        return (int) ((Math.random() * 6) + 1);
    }

    public static void main(String[] args) {
        
        // Declaration of variables
        Scanner input = new Scanner(System.in);

        //Player1 Variables
        boolean player1CanDrawBody = false,
                player1CanDrawTail = false,
                player1CanDrawTrunk = false,
                player1CanDrawLeg = false,
                player1CanDrawEar = false,
                player1CanDrawHead = false;

        int player1BodyLeft = 1,
                player1TailLeft = 1,
                player1TrunkLeft = 1,
                player1LegLeft = 4,
                player1EarLeft = 2,
                player1HeadLeft = 1;

        //Player2 Variables
        boolean player2CanDrawBody = false,
                player2CanDrawTail = false,
                player2CanDrawTrunk = false,
                player2CanDrawLeg = false,
                player2CanDrawEar = false,
                player2CanDrawHead = false;

        int player2BodyLeft = 1,
                player2TailLeft = 1,
                player2TrunkLeft = 1,
                player2LegLeft = 4,
                player2EarLeft = 2,
                player2HeadLeft = 1;

        //Game Variables
        boolean gameEnd = false;
        int round = 0;
        boolean player1Win = false;
        int player1Roll = 0, player2Roll = 0;

        // Start Messege
        System.out.println("-----------------Start Program Welcome!------------------");
        System.out.println("---------------------------------------------------------");
        System.out.println("\t\t Nancy's Elephant Drawing Game");
        System.out.println("---------------------------------------------------------");
        System.out.println();

        //Game Init
        player1CanDrawBody = true;
        player2CanDrawBody = true;
        round = 0;

        //Start the while Loop
        while (!gameEnd) {
            //round increment
            round++;

            //Rolling Dices
            player1Roll = rollTheDice();
            player2Roll = rollTheDice();

            //Handling Player1 case
            switch (player1Roll) {
                case 1: //Trunk
                    if (player1CanDrawTrunk && player1TrunkLeft != 0) {
                        player1TrunkLeft--;
                    }
                    break;

                case 2: //Head -> Ear & Trunk
                    if (player1CanDrawHead && player1HeadLeft != 0) {
                        player1HeadLeft--;
                        player1CanDrawTrunk = true;
                        player1CanDrawEar = true;
                    }
                    break;

                case 3: //Body -> Tail & Leg & Head
                    if (player1CanDrawBody && player1BodyLeft != 0) {
                        player1BodyLeft--;
                        player1CanDrawTail = true;
                        player1CanDrawLeg = true;
                        player1CanDrawHead = true;
                    }
                    break;

                case 4: //Tail
                    if (player1CanDrawTail && player1TailLeft != 0) {
                        player1TailLeft--;
                    }
                    break;

                case 5: //Leg
                    if (player1CanDrawLeg && player1LegLeft != 0) {
                        player1LegLeft--;
                    }
                    break;

                case 6: //Ear
                    if (player1CanDrawEar && player1EarLeft != 0) {
                        player1EarLeft--;
                    }
                    break;

                default:
                    System.exit(1);
            }

            //Handling Player2 case (this is exactly the same thing as above).
            switch (player2Roll) {
                case 1:
                    if (player2CanDrawTrunk && player2TrunkLeft != 0) {
                        player2TrunkLeft--;
                    }
                    break;

                case 2:
                    if (player2CanDrawHead && player2HeadLeft != 0) {
                        player2HeadLeft--;
                        player2CanDrawTrunk = true;
                        player2CanDrawEar = true;
                    }
                    break;

                case 3:
                    if (player2CanDrawBody && player2BodyLeft != 0) {
                        player2BodyLeft--;
                        player2CanDrawTail = true;
                        player2CanDrawLeg = true;
                        player2CanDrawHead = true;
                    }
                    break;

                case 4:
                    if (player2CanDrawTail && player2TailLeft != 0) {
                        player2TailLeft--;
                    }
                    break;

                case 5:
                    if (player2CanDrawLeg && player2LegLeft != 0) {
                        player2LegLeft--;
                    }
                    break;

                case 6:
                    if (player2CanDrawEar && player2EarLeft != 0) {
                        player2EarLeft--;
                    }
                    break;

                default:
                    System.exit(1);
            }

            //Printing Round Status
            System.out.println("Status after round " + round + ":");
            System.out.printf("\t Player 1 rolled a %d while Player 2 rolled a %d.%n", player1Roll, player2Roll);

            //Printing Status of Player1
            System.out.printf("Player 1's elephant has %s body, %s head, %s ear(s), %s trunk, %s tail, and %s leg(s).%n",
                    player1BodyLeft == 0 ? "a" : "no",
                    player1HeadLeft == 0 ? "a" : "no",
                    player1EarLeft == 2 ? "no" : (2 - player1EarLeft) + "",
                    player1TrunkLeft == 1 ? "no" : "a",
                    player1TailLeft == 1 ? "no" : "a",
                    player1LegLeft == 4 ? "no" : (4 - player1LegLeft) + "");

            //Printing Status of Player2 (exactly as above).
            System.out.printf("Player 2's elephant has %s body, %s head, %s ear(s), %s trunk, %s tail, and %s leg(s).%n",
                    player2BodyLeft == 0 ? "a" : "no",
                    player2HeadLeft == 0 ? "a" : "no",
                    player2EarLeft == 2 ? "no" : (2 - player2EarLeft) + "",
                    player2TrunkLeft == 1 ? "no" : "a",
                    player2TailLeft == 1 ? "no" : "a",
                    player2LegLeft == 4 ? "no" : (4 - player2LegLeft) + "");

            System.out.println();
            
            //Checking if someone won
            if (player1BodyLeft == 0
                    && player1HeadLeft == 0
                    && player1TrunkLeft == 0
                    && player1LegLeft == 0
                    && player1EarLeft == 0
                    && player1TailLeft == 0) {

                player1Win = true; //Player1Win
                gameEnd = true;
            } else if (player2BodyLeft == 0
                    && player2HeadLeft == 0
                    && player2TrunkLeft == 0
                    && player2LegLeft == 0
                    && player2EarLeft == 0
                    && player2TailLeft == 0) {

                player1Win = false; //Player2Win
                gameEnd = true;
            }
        }

        // OutPut and Game Result.
        System.out.printf(">>>>> Congratulations to player %d!!! Your elephant is complete! <<<<<%n%n",
                player1Win ? 1 : 2);
        System.out.println("Hope you enjoyed drawing elephants!");
        // End Messege
        System.out.println("----------------------End Program------------------------");
    }
}
