/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  SoccerSim.java
 *  Purpose       :  SoccerSimulator for Homework #5
 *  @author       :  Andrew Arteaga
 *  Date written  :  2017-02-28
 *  Description   :  This is part 2 of the previous assignment
 *
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
public class SoccerSim {
 
  /**
   *  Class field definintions go here
   */
    private static final double FIELD = 200;;
    private static final double POLE = 0.0;
  /**
   *  Constructor
   *  This just calls the superclass constructor, which is "Object"
   */
  public SoccerSim() {
      super();
    }
 
  /**
   *  Method to handle all the input arguments from the command line
   *   this sets up the variables for the simulation
   */
   public static void main( String args[] ) {  
      double timeSplice = 0;      
      System.out.println( "\n   Hello world, from the SoccerSim program!!\n\n" );
      Clock a = new Clock(0,0,0.0);
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter number of balls");
      int value = scanner.nextInt();
      if (value < 1){
        System.out.println("Enter more balls");
        System.exit( 2 );
      }
      scanner = new Scanner(System.in);
      System.out.println("Enter desired time splice");
      String input2 = scanner.nextLine();
      if ( -1.0 == a.validateTimeSliceArg(input2)){
        System.out.println("Enter a valid time splice");
        System.exit( 1 );
      } 
      if (a.validateTimeSliceArg(input2) == 0){
        System.out.println("Time splice set to 60 seconds.");
        timeSplice = 1;
      } else if (Double.parseDouble(input2)< 0){
      System.out.println("Enter a valid time splice");
        } else {       
        timeSplice = Double.parseDouble(input2); 
      }
      double b[] = new double[value * 4];
      for (int i = 0; i < value; i++) {
        scanner = new Scanner(System.in);
        System.out.println("Enter the " + (i+1) + " ball's xPosition");
        String input3 = scanner.nextLine();
        b[i] = Double.parseDouble(input3);
        scanner = new Scanner(System.in);
        System.out.println("Enter the " + (i+1) + " ball's yPosition");
        String input4 = scanner.nextLine();
        b[i+1] = Double.parseDouble(input4);
        scanner = new Scanner(System.in);
        System.out.println("Enter the " + (i+1) + " ball's xVelocity");
        String input5 = scanner.nextLine();
        b[i+2] = Double.parseDouble(input5);
        scanner = new Scanner(System.in);
        System.out.println("Enter the " + (i+1) + " ball's yVelocity");
        String input6 = scanner.nextLine();
        b[i+3] = Double.parseDouble(input6);
       }
      Ball d = null;
      int j = 0; 
      int arrayLength = b.length;
      double xPosition[]=new double[b.length/4];
      double yPosition[]=new double[b.length/4];
      Ball c = new Ball(0,0,0.0,0.0);
      for (int i = 0; i < arrayLength/4; i++) {
        double x = b[i];
        xPosition[i] = b[i];
        double y = b[i+1];
        yPosition[i] = b[i];
        double xSpeed = b[i+2];
        double ySpeed = b[i+3];
        System.out.println("Ball #" + (i + 1) + " initial position is " + x + "," + y + " velocity is " + xSpeed + " ft/s" + "," + ySpeed +  " ft/s.");
        d = new Ball(x,y,xSpeed,ySpeed);
        j = j + 1;
      }
      Clock e = new Clock(0,0,0);
      int i = 0;
      double twelveHourDay = 0.0;
      while (true) {
        d.positonBall(timeSplice);
        twelveHourDay  = twelveHourDay  + e.tick(timeSplice);
        int hours = (int)Math.floor(twelveHourDay/3600);
        int minutes = (int)Math.floor(((twelveHourDay/3600) - hours) * 60);
        double seconds = Math.floor(((((twelveHourDay/3600) - hours) * 60) - minutes) * 60);
        System.out.println("Ball #" + (i + 1) + " current position/velocity is " + d.toString());
        System.out.println("The time is " + hours + " hours " + minutes + " minutes and " + seconds + " seconds");
        i = i + 1; 
        if (d.getVelocity()<1){
            System.out.println("Balls stopped no collision");
            break;
        } else if (d.checkCollision(0.0,0.0) == true) {
            System.out.println("Ball hit the pole");
            break;
        } else if (d.checkCollision(xPosition[i],yPosition[i]) == true) {
            System.out.println("Balls have Collided");
            break;
        } else {
            d.frictionBall();
        }
     }
  }
}
