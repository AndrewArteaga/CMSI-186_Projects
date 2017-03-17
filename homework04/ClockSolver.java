/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  ClockSolver.java
 *  Purpose       :  The main program for the ClockSolver class
 *  @see
 *  @author       :  Andrew Arteaga
 *  Date written  :  2017-02-28
 *  Description   :  This class provides a bunch of methods which may be useful for the ClockSolver class
 *                   for Homework 4, part 1.  Includes the following:
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
public class ClockSolver {
  /**
   *  Class field definintions go here
   */
   private double angle;
   private double timeSplice;
   private static final double MAX_TIME_SLICE_IN_SECONDS  = 1800.00;
   private static final double DEFAULT_TIME_SLICE_SECONDS = 60.0;
   private static final double EPSILON_VALUE              = 10.0;      // small value for double-precision comparisons

  /**
   *  Constructor
   *  This just calls the superclass constructor, which is "Object"
   */
   public ClockSolver() {
      super();
   }

  /**
   *  Method to handle all the input arguments from the command line
   *   this sets up the variables for the simulation
   */
   public void handleInitialArguments( String args[] ) {
     // args[0] specifies the angle for which you are looking
     //  your simulation will find all the angles in the 12-hour day at which those angles occur
     // args[1] if present will specify a time slice value; if not present, defaults to 60 seconds
     // you may want to consider using args[2] for an "angle window"        
      System.out.println( "\n   Hello world, from the ClockSolver program!!\n\n" );
      Clock b = new Clock(0,0,0.0);
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter the desired angle: ");
      String input = scanner.nextLine();
      if (-1.0 == b.validateAngleArg(input)){
        System.out.println("Enter a valid angle");
        System.exit( 1 );
      }
      angle = Double.parseDouble(input);
      scanner = new Scanner(System.in);
      System.out.println("Enter desired time splice");
      String input2 = scanner.nextLine();
      if ( -1.0 == b.validateTimeSliceArg(input2)){
        System.out.println("Enter a valid time splice");
        System.exit( 0 );
      } 
      if (b.validateTimeSliceArg(input2) == 0){
        System.out.println("Time splice set to 60 seconds.");
        timeSplice = 60.0;
      } else {
        timeSplice = Double.parseDouble(input2); 
      }   
   } 
  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  @param  args  String array of the arguments from the command line
   *                args[0] is the angle for which we are looking
   *                args[1] is the time slice; this is optional and defaults to 60 seconds
   */
   public static void main( String args[] ) {
     ClockSolver cse = new ClockSolver();
     Clock a =  new Clock(0,0,0.0);
     double[] timeValues = new double[3];
     cse.handleInitialArguments( args );
     double twelveHourDay = 0.0;
     System.out.println("The angle of " + cse.angle + " degrees is seen at these times in a twelve hour day:" );
    while (twelveHourDay <= 43200){
      twelveHourDay  = twelveHourDay  + a.tick(cse.timeSplice);
      int hours = (int)Math.floor(twelveHourDay/3600);
      int minutes = (int)Math.floor(((twelveHourDay/3600) - hours) * 60);
      double seconds = Math.floor(((((twelveHourDay/3600) - hours) * 60) - minutes) * 60);
      double hourTheta = (twelveHourDay * 0.00834) % 360;
      double minuteTheta = (twelveHourDay * 0.1) % 360;
      double handsTheta = Math.abs(hourTheta - minuteTheta);
        if (handsTheta > 180){
           handsTheta = 360 - handsTheta;
         }
      if (Math.abs(cse.angle - handsTheta) <= EPSILON_VALUE) {
      System.out.println("The times when the angles of the hand and minute hands are " + cse.angle + " degrees is at " + hours + ":" + minutes +":" +seconds);
      }
   }      
}}
