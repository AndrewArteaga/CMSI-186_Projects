/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Ball.java
 *  Purpose       :  Provides a class of methods for the SoccerSim class
 *  @author       :  Andrew Arteaga
 *  Date written  :  2017-02-28
 *  Description   :  This class provides a bunch of methods which may be useful for the SoccerSim class
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
import java.lang.Math;
public class Ball {
  /**
   *  Class field definintions go here
   */
  private double x;
  private double y; 
  private double speedX;
  private double speedY;
  private double totalVelocity;
  private double timeSlice;
  private static final double RADIUS = 4.45;
  private static final double WEIGHT = 1.0;
  private static final double FRICTION = 0.01;
  /**
   *  Constructor goes here
   */
   public Ball(double x, double y, double speedX, double speedY) {
    this.x = x;
    this.y = y;
    this.speedX = speedX;
    this.speedY = speedY;
   }  
   /**
   *  Method to fetch the velocity of the ball at the interval 
   *  @return double-precision value the total seconds private variable
   */
   public double getVelocity(){
    totalVelocity = Math.sqrt((speedY * speedY) + (speedX * speedX));
    return totalVelocity;
  }
   /**
   *  Method to update the velocity in the x and the y direction when taking into account of friction 
   */
   public void frictionBall(){
    speedX = speedX - (speedX*FRICTION);
    speedY = speedY - (speedY*FRICTION);
   }
   /**
   *  Method to update the position in the x and the y direction 
   */
   public void positonBall(double timeSlice){
    x = x + speedX*timeSlice;
    y = y + speedY*timeSlice;
   }
   /**
   *  Method to check if there is a collision 
   *  @return true is balls collided
   */
   public boolean checkCollision(double x2, double y2){
    if ((Math.abs(x-x2) <= RADIUS) && (Math.abs(y-y2) <= RADIUS)) {
      return true;
    } else {
      return false; 
    }
   }
   /**
   *  Method to return a String representation of this Ball
   *  @return String value of the current Ball
   */
   public String toString() {
    return "The location is " + x + "," + y + " and the velocity is " + totalVelocity + " ft/s.";
   }
   /**
   *  The main program starts here
   *  Remember you are trying to BREAK your code, not just prove it works!
   */
   public static void main( String args[] ) {
    System.out.println( "\nBaLL CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );
    System.out.println( "  Creating a new ball: " );
    Ball a = new Ball(10.0,10.0,-3.0,-4.0);
    System.out.println( " The velocity of the ball is " + a.getVelocity() + " ft/s.");
    System.out.println( " Stringy representation of the ball: " + a.toString());
    a.frictionBall();
    a.positonBall(60);
    System.out.println( " The velocity of the ball is " + a.getVelocity() + " ft/s.");
    System.out.println( " Stringy representation of the ball: " + a.toString());
    System.out.println( " Collision? " + a.checkCollision(-168.900,-223.9));
    System.out.println( " Collision? " + a.checkCollision(20.0,16.0));

    System.out.println( "\n Creating a new ball: " );
    Ball b = new Ball(-20.0,-12.0,8.0,6.0);
    System.out.println( " The velocity of the ball is " + b.getVelocity() + " ft/s.");
    System.out.println( " Stringy representation of the ball: " + b.toString());
    System.out.println( " Collision? " + b.checkCollision(-14.0,-1.0));
    System.out.println( " Collision? " + b.checkCollision(-20.0,-16));
    b.frictionBall();
    b.positonBall(18);
    System.out.println( " The velocity of the ball is " + b.getVelocity() + " ft/s.");
    System.out.println( " Stringy representation of the ball: " + b.toString());
   

   }
}
