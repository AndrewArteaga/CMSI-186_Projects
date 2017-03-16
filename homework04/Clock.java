/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Clock.java
 *  Purpose       :  Provides a class defining methods for the ClockSolver class
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

public class Clock {
  /**
   *  Class field definintions go here
   */
  private int hours;
  private int minutes; 
  private double seconds;
  private double timeIncrement;
  private double hourTheta;
  private double minuteTheta;
  private double handsTheta;
  private double totalSeconds;
  private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 60.0;
  private static final double INVALID_ARGUMENT_VALUE = -1.0;
  private static final double MAXIMUM_DEGREE_VALUE = 360.0;
  private static final double HOUR_HAND_DEGREES_PER_SECOND = 0.00834;
  private static final double MINUTE_HAND_DEGREES_PER_SECOND = 0.1;

  /**
   *  Constructor goes here
   */
   public Clock(int hours, int minutes, double seconds) {
    try {
      if (hours < 0 || hours > 12) {
        throw new IllegalArgumentException();
      }
    } catch (Exception i) {
    System.err.println("This time does not have a valid hours place!");
    }
    try {
      if (minutes < 0 || minutes > 60) {
        throw new IllegalArgumentException();
      }
    } catch (Exception i) {
    System.err.println("This time does not have a valid minutes place!");
    }
    try {
      if (seconds < 0 || seconds > 60) {
        throw new IllegalArgumentException(); 
      }
    } catch (Exception i) {
    System.err.println("This time does not have a valid seconds place!");
    }
    this.hours = hours;
    this.minutes = minutes;
    this.seconds = seconds;
   }

  /**
   *  Methods go here
   *
   *  Method to calculate the next tick from the time increment
   *  @return double-precision value of the current clock tick
   */
   public double tick(double timeIncrement){
    String valid = Double.toString(timeIncrement);
    if (validateTimeSliceArg(valid) != -1.0) {
      totalSeconds = totalSeconds + timeIncrement;
      if (totalSeconds > 43200) {
        totalSeconds = totalSeconds - 43200;
      }
      hours = (int)Math.floor(totalSeconds/3600);
      minutes = (int)Math.floor(((totalSeconds/3600) - hours) * 60);
      seconds = Math.floor(((((totalSeconds/3600) - hours) * 60) - minutes) * 60);
      return totalSeconds;
    }
      System.out.println( "Please add a time Splice less than 1800 and greater than 0" );
      return -1.0;
  }
  /**
   *  Method to validate the angle argument
   *  @param   argValue  String from the main programs args[0] input
   *  @return  double-precision value of the argument
   *  @throws  NumberFormatException
   */
   public double validateAngleArg( String argValue ) {
    double validAngle = Double.parseDouble(argValue);
    try {
    if (validAngle < 0 || validAngle > 360){
        throw new NumberFormatException("Enter a valid angle");
      } }   catch (NumberFormatException e) {
       return -1.0;
    }
    return validAngle;
   }
  /**
   *  Method to validate the optional time slice argument
   *  @param  argValue  String from the main programs args[1] input
   *  @return double-precision value of the argument or -1.0 if invalid
   *  note: if the main program determines there IS no optional argument supplied,
   *         I have elected to have it substitute the string "60.0" and call this
   *         method anyhow.  That makes the main program code more uniform, but
   *         this is a DESIGN DECISION, not a requirement!
   *  note: remember that the time slice, if it is small will cause the simulation
   *         to take a VERY LONG TIME to complete!
   */
   public double validateTimeSliceArg( String argValue ) {
    double validTS = Double.parseDouble(argValue);
    if (validTS < 0 || validTS > 1800){
        return -1.0;
      } else {
    return validTS;
   }
}
  /**
   *  Method to calculate and return the current position of the hour hand
   *  @return double-precision value of the hour hand location
   */
   public double getHourHandAngle() {
    hourTheta = totalSeconds * 0.00834;
    if(hourTheta >= 360){
      hourTheta = hourTheta - 360;
    }
    return hourTheta;
   }

  /**
   *  Method to calculate and return the current position of the minute hand
   *  @return double-precision value of the minute hand location
   */
   public double getMinuteHandAngle() {
    minuteTheta = (totalSeconds * 0.1) % 360;
    if(minuteTheta >= 360){
      minuteTheta = minuteTheta - 360;
    }
    return minuteTheta;
   }

  /**
   *  Method to calculate and return the angle between the hands
   *  @return double-precision value of the angle between the two hands
   */
   public double getHandAngle() {
    handsTheta = Math.abs(hourTheta - minuteTheta);
    if (handsTheta > 180){
      handsTheta = 360 - handsTheta;
    }
    return handsTheta;
   }

  /**
   *  Method to fetch the total number of seconds
   *   we can use this to tell when 12 hours have elapsed
   *  @return double-precision value the total seconds private variable
   */
   public double getTotalSeconds() {
    totalSeconds = (hours * 3600) + (minutes * 60) + seconds;
    return totalSeconds;
   }

  /**
   *  Method to return a String representation of this clock
   *  @return String value of the current clock
   */
   public String toString() {
    hours = (int)Math.floor(getTotalSeconds()/3600);
    minutes = (int)Math.floor(((getTotalSeconds()/3600) - hours) * 60);
    seconds = Math.floor(((((getTotalSeconds()/3600) - hours) * 60) - minutes) * 60);
    return "The time is " + hours + " hours " + minutes + " minutes and " + seconds + " seconds";
   }

  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  be sure to make LOTS of tests!!
   *  remember you are trying to BREAK your code, not just prove it works!
   */
   public static void main( String args[] ) {

      System.out.println( "\nCLOCK CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );
      System.out.println( "  Creating a new clock: " );
      Clock a = new Clock(12, 59 , 59.0);
      System.out.println( "    New clock was created: " + a.toString());
      System.out.println("The hour hand's angle is "  + a.getHourHandAngle() + " degrees");
      System.out.println("The minute hand's angle is " + a.getMinuteHandAngle() + " degrees");
      System.out.println("The angle between the minute and the hour hand is " + a.getHandAngle() + " degrees");
      System.out.println("The total number of seconds is " + a.getTotalSeconds() + " seconds");
      System.out.println("You have added " + Math.abs(a.getTotalSeconds() - a.tick(1800.0) - 43200)+ " ticks");
      System.out.println("\nThe hour hand's angle is "  + a.getHourHandAngle() + " degrees");
      System.out.println("The minute hand's angle is " + a.getMinuteHandAngle() + " degrees");
      System.out.println("The angle between the minute and the hour hand is " + a.getHandAngle() + " degrees");
      System.out.println("The new number of seconds is " + a.getTotalSeconds() + " seconds");
      System.out.println( "   The new clock is: " + a.toString());

      System.out.println( "\n  Creating a new clock: " );
      Clock bs = new Clock(0,600,423.0);
 
      System.out.println( "\n  Creating a new clock: " );
      Clock b = new Clock(1,30,0.0);
      System.out.println( "    New clock was created: " + b.toString());
      System.out.println("The hour hand's angle is "  + b.getHourHandAngle() + " degrees");
      System.out.println("The minute hand's angle is " + b.getMinuteHandAngle() + " degrees");
      System.out.println("The angle between the minute and the hour hand is " + b.getHandAngle() + " degrees");
      System.out.println("The total number of seconds is " + b.getTotalSeconds() + " seconds");
      System.out.println("You have added " + Math.abs(b.getTotalSeconds() - b.tick(-1.0)) + " ticks");

      System.out.println("\nYou have added " + Math.abs(b.getTotalSeconds() - b.tick(1500.0)) + " ticks");
      System.out.println("The hour hand's angle is "  + b.getHourHandAngle() + " degrees");
      System.out.println("The minute hand's angle is " + b.getMinuteHandAngle() + " degrees");
      System.out.println("The angle between the minute and the hour hand is " + b.getHandAngle() + " degrees");
      System.out.println("The new number of seconds is " + b.getTotalSeconds() + " seconds");
      System.out.println( "   The new clock is: " + b.toString());

      System.out.println( "    Testing validateAngleArg()....");
      System.out.print( "      sending '  0 degrees', expecting double value   0.0" );
      try { System.out.println( (0.0 == a.validateAngleArg( "0.0" )) ? " - got 0.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      System.out.println( "    Testing validateAngleArg()....");
      System.out.print( "      sending '  -1000 degrees', expecting double value -1.0" );
      try { System.out.println( (-1.0 == a.validateAngleArg( "-1000" )) ? " - got -1.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.println( "    Testing validateTimeSliceArg()....");
      System.out.print( "      sending a timesplice of 1801.0', expecting double value -1.0" );
      try { System.out.println( (-1.0 == a.validateTimeSliceArg( "1801.0" )) ? " - got -1.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      System.out.println( "    Testing validateTimeSliceArg()....");
      System.out.print( "      sending a timesplice of 1500.0', expecting double value 1500.0" );
      try { System.out.println( (1500.0 == a.validateTimeSliceArg( "1500.0" )) ? " - got 1500.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
   }
}
