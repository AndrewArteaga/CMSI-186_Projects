/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  FibonacciTester.java
 *  Purpose       :  To test Fibonacci.java with user input
 *  @author       :  Andrew Arteaga
 *  Date written  :  2017-04-1
 *  Description   :  This tests the methods written in Fibonacci.java
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
public class FibonacciTester {
  /**
   *  Constructor
   *  This just calls the superclass constructor, which is "Object"
   */
	public FibonacciTester() {
      super();
   	}
 
  /**
   *  Method to handle all the input arguments from the command line
   *   this sets up the variables for the simulation
   */
  public static void main( String args[] ) {        
      System.out.println( "\n   Hello world, from the FibonacciTester program!!\n\n" );
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter your desired nth term for the Fibonacci Sequence");
      String input = scanner.nextLine();
      if (Integer.parseInt(input) < 0){
        System.out.println("Enter a number greater than zero please");
        System.exit( 1 );
      }
      GinormousInt a = new GinormousInt(0);
      GinormousInt b = new GinormousInt(1);
      GinormousInt c = new GinormousInt(1);
      System.out.println("The " + 1 + " term is equal to "  + 0);
      System.out.println("The " + 2 + " term is equal to "  + 1);  
      for(int i=2;i<Integer.parseInt(input);i++) { 
        c = b.plus(a);
        a = b;
        b = c;
      System.out.println("The " + (i + 1) + " term is equal to "  + c.toDecimalString());
    }
   } 

}
