/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  HighRoll.java
 *  Purpose       :  Demonstrates the use of input from a command line for use with Yahtzee
 *  Author        :  Andrew Arteaga
 *  Date          :  2017-02-14
 *  Description   :  
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-14  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HighRoll{

   public static void main( String args[] ) {
      System.out.println( "\n   Welcome to the High Roller Game!!\n" );
      System.out.println( "     Press the '1' key to ROLL ALL THE DICE." );
      System.out.println( "     Press the '2' key to ROLL A SINGLE DIE." );
      System.out.println( "     Press the '3' key to CALCULATE THE SCORE FOR THIS SET." );
      System.out.println( "     Press the '4' key to SAVE THIS SCORE AS HIGH SCORE." );
      System.out.println( "     Press the '5' key to DISPLAY THE HIGH SCORE." );
      System.out.println( "     Press the 'q' key to quit the program." );
      DiceSet a = new DiceSet(6,6);
      int hScore = 0;

     // This line uses the two classes to assemble an "input stream" for the user to type
     // text into the program
      BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );
      while( true ) {
         System.out.print( ">>" );
         String inputLine = null;
         try {
            inputLine = input.readLine();
            if( '1' == inputLine.charAt(0) ) {
               a.roll();
               System.out.println("Dice Roll!!! Here are your results: " + a.toString());
            }
            if( '2' == inputLine.charAt(0) ) {
               System.out.println("Die Roll!!! Here is your result: " + a.rollIndividual(0));
            }
            if( '3' == inputLine.charAt(0) ) {
               System.out.println("Here is the total for your set of dice: " + a.sum());
            }
            if( '4' == inputLine.charAt(0) ) {
               hScore = a.sum();
               System.out.println("Score saved as High Score");
            }
            if( '5' == inputLine.charAt(0) ) {
               System.out.println("High Score:" + hScore);
            }
            if(inputLine.length() > 2 || inputLine.isEmpty()) {
               System.out.println("Invalid input. Please enter one of the options above.");
               System.out.print( ">>" );
            }
            if( 'q' == inputLine.charAt(0) ) {
               System.out.println("Thank you for playing better luck next time.");
               break;
            }         }
         catch( IOException ioe ) {
            System.out.println( "Caught IOException" );
         }
      }
   }
}
