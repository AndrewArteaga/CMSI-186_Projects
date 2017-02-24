/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DiceSet.java
 *  Purpose       :  Provides a class describing a set of dice
 *  Author        :  Andrew Arteaga
 *  Date          :  2017-02-09
 *  Description   :  This class provides everything needed (pretty much) to describe a set of dice.  The
 *                   idea here is to have an implementing class that uses the Die.java class.  Includes
 *                   the following:
 *                   public DiceSet( int k, int n );                  // Constructor for a set of k dice each with n-sides
 *                   public int sum();                                // Returns the present sum of this set of dice
 *                   public void roll();                              // Randomly rolls all of the dice in this set
 *                   public void rollIndividual( int i );             // Randomly rolls only the ith die in this set
 *                   public int getIndividual( int i );               // Gets the value of the ith die in this set
 *                   public String toString();                        // Returns a stringy representation of this set of dice
 *                   public static String toString( DiceSet ds );     // Classwide version of the preceding instance method
 *                   public boolean isIdentical( DiceSet ds );        // Returns true iff this set is identical to the set ds
 *                   public static void main( String[] args );        // The built-in test program for this class
 *
 *  Notes         :  Stolen from Dr. Dorin pretty much verbatim, then modified to show some interesting
 *                   things about Java, and to add this header block and some JavaDoc comments.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-09  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.Arrays;
public class DiceSet {

  /**
   * private instance data
   */
   private int count;
   private int sides;
   private Die[] ds = null;

   // public constructor:
  /**
   * constructor
   * @param  count int value containing total dice count
   * @param  sides int value containing the number of pips on each die
   * @throws IllegalArgumentException if one or both arguments don't make sense
   * @note   parameters are checked for validity; invalid values throw "IllegalArgumentException"
   */
   public DiceSet( int count, int sides ) {
    if (count < 1 || sides < 4) {
      throw new IllegalArgumentException("Exception has been thrown!");
    }
    this.count = count;
    this.sides = sides;
    this.ds = new Die [count];
    for (int i = 0; i < count; i++){
      this.ds[i] = new Die(sides);
    }
   }
  /**
   * @return the sum of all the dice values in the set
   */
   public int sum() { 
    int sumDie = 0;
    for (int i = 0; i < count; i++){
      sumDie = sumDie + this.ds[i].getValue();
    }
    return sumDie;
   }

  /**
   * Randomly rolls all of the dice in this set
   *  NOTE: you will need to use one of the "toString()" methods to obtain
   *  the values of the dice in the set
   */
   public void roll() {
    for (int i = 0; i < count; i++){
      this.ds[i].roll();
    }
   }

  /**
   * Randomly rolls a single die of the dice in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @return the integer value of the newly rolled die
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int rollIndividual( int dieIndex ) {
    int i = 0;
    if (dieIndex < count) {
     i = this.ds[dieIndex].roll();
    } else {
      throw new IllegalArgumentException("Not a valid index");
    }
    return i;
   }

  /**
   * Gets the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int getIndividual( int dieIndex ) {
    int i = this.ds[dieIndex].getValue();
      return i;
   }

  /**
   * @return Public Instance method that returns a String representation of the DiceSet instance
   */
   public String toString() {
    String result = "";
    for (int i = 0; i < count; i++){
      result = result + Integer.toString(this.ds[i].getValue());
    }
      return result;
   }

  /**
   * @return Class-wide version of the preceding instance method
   */
   public static String toString( DiceSet ds ) {
      return  ds.toString();
   }

  /**
   * @return  true iff this set is identical to the set passed as an argument
   */
   public boolean isIdentical( DiceSet ds ) {
    int[] sortedArrayA = new int [count]; 
    int[] sortedArrayB = new int [count];
    int i = 0;
    int j = 0;
    while (i < count) {
      sortedArrayA[i] = Integer.parseInt(this.toString().substring(i,i+1));
      i++;
    }
    while (j < ds.toString().length()) {
      sortedArrayB[j] = Integer.parseInt(ds.toString().substring(j,j+1));
      j++;
    }
    Arrays.sort(sortedArrayA);
    Arrays.sort(sortedArrayB);
    for (int z = 0; z < count; z++) {
      System.out.println(sortedArrayA[z]);
    }
    for (int z = 0; z < count; z++) {
      System.out.println(sortedArrayB[z]);
    }
    for ( int k = 0; k < count; k++) {
      if (sortedArrayA[k]!=sortedArrayB[k]) {
        return false;
      }
    }
      return true;
   }
  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {
    
    DiceSet a = new DiceSet(2,4);
    a.roll();
    System.out.println( "First sum is for the set of 2, 4 sided die is " + a.sum() + ".");
      try {
      System.out.println( "Roll for chosen index of diceset, 2. It is " + a.rollIndividual(2) + ".");
      } catch (IllegalArgumentException i) {
        System.err.println("This is not a valid index. Do it again.");
      }
    System.out.println( "Get the value of rolled dice from the index, 0. It is " + a.getIndividual(0) + ".");
    System.out.println( "Get the value of rolled dice from the index, 1. It is " + a.getIndividual(1) + ".");
    System.out.println( "Here is the stringy representation of this set of dice, " + a.toString() + ".");
    System.out.println( "Here is the Class-wide stringy representation of this set of dice, " + a.toString(a) + ".");
    System.out.println( "ReRoll for chosen index of diceset, 1. It is " + a.rollIndividual(1) + ".");
    
    DiceSet b = new DiceSet(5,4);
    DiceSet c = new DiceSet(5,4);
    b.roll();
    c.roll();
    System.out.println(b.toString());
    System.out.println(c.toString());
    System.out.println( "Are the dice sets above identical? " + b.isIdentical(c) + ".");
    
    DiceSet d = new DiceSet(5,20);
    DiceSet e = new DiceSet(5,20);
    //d.roll();
    //e.roll();
    System.out.println(d.toString());
    System.out.println(e.toString());
    System.out.println( "Are the dice sets above identical? " + d.isIdentical(e) + ".");
    }

}
