/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  GinormousInt.java
 *  Purpose       :  Provides a class of methods that allows the user to mimc the BigInteger Class from java
 *  @author       :  Andrew Arteaga
 *  Date written  :  2017-04-11
 *  Description   :  This class provides a bunch of methods that allows user to compute mathematical 
 *                   operations of extremely large numbers 
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  *  Had massive help stackoverflow 
  *  http://stackoverflow.com/questions/5318068/very-large-vofs-in-java-without-using-java-math-biginteger/5318896#5318896
  *  Particulary ePaul who uses concepts I learned from Logic Design by changing the base or radix of the
  *  system to compute the math a lot easier and walked me through the whole process
  *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
  */
import java.util.Arrays;
import java.util.Formatter;
public class GinormousInt{
  /**
   *  Class field definintions go here
   */
  public final static int BASE9 = 1000000000;
  private final static int DIGITS9 = 9;
  private int[] largeArray;
  public static final GinormousInt ZERO     = new GinormousInt();       /// Constant for "zero"
  public static final GinormousInt ONE      = new GinormousInt(1);      /// Constant for "one"
  public static final GinormousInt TWO      = new GinormousInt(2);      /// Constant for "two"
  public static final GinormousInt THREE    = new GinormousInt(3);      /// Constant for "three"
  public static final GinormousInt FOUR     = new GinormousInt(4);      /// Constant for "four"
  public static final GinormousInt FIVE     = new GinormousInt(5);      /// Constant for "five"
  public static final GinormousInt SIX      = new GinormousInt(6);      /// Constant for "six"
  public static final GinormousInt SEVEN    = new GinormousInt(7);      /// Constant for "seven"
  public static final GinormousInt EIGHT    = new GinormousInt(8);      /// Constant for "eight"
  public static final GinormousInt NINE     = new GinormousInt(9);      /// Constant for "nine"
  public static final GinormousInt TEN      = new GinormousInt(10);     /// Constant for "ten"  
  /**
   *  Constructor goes here
   */
  public GinormousInt(int ... largeArray) {
   for(int value: largeArray) {
        if(value < 0 ||  BASE9 <= value) {
            throw new IllegalArgumentException("enter a valid value, this value is noty valid");
        }
    }
    this.largeArray = largeArray.clone();
  }
  /**
   *  Method to return a String representation of this clock
   *  @return String value of the current GinormousInt
   */
  public String toString() {
    return "Here is the array: " + Arrays.toString(largeArray);
  }
  /**
    *  GinormousInt "static factory" for constructing GinormousInt out of longs
    */
  public static GinormousInt valueOf(long vOf) {
    if(vOf < 0) {
        throw new IllegalArgumentException("negative vOf: " + vOf);
      } else if(vOf == 0L) {
          return ZERO;
      } else if(vOf == 1L) {
          return ONE;
    }
    int[] largeArray = new int[3];
    int index = 2;
    while(vOf > 0) {
      largeArray[index] = (int)(vOf % BASE9);
      vOf = vOf / BASE9;
      index-- ;
    }
    return new GinormousInt(largeArray);
}
 /**
  * formats the number as a decimal String.
  */
  public String toDecimalString() {
    StringBuilder a = new StringBuilder(DIGITS9 * largeArray.length);
    Formatter b = new Formatter(a);
    b.format("%d", largeArray[0]);
    for(int i = 1 ; i < largeArray.length; i++) {
      b.format("%09d", largeArray[i]);
    }
      return b.toString();
    }
/**
 * adds the GinormousInt
 */
  public GinormousInt plus(GinormousInt that) {
    int[] result = new int[Math.max(this.largeArray.length,that.largeArray.length)+ 1];
    addRemainder(result, result.length-1, this.largeArray);
    addRemainder(result, result.length-1, that.largeArray);
    return new GinormousInt(result);
  }
  private void addRemainder(int[] result, int resultIndex, int... addend) {
    int addened = addend.length - 1;
    while(addened >= 0) {
      addOther(result, resultIndex, addend[addened]);
      addened--;
      resultIndex--;
      }
  }
  private void addOther(int[] result, int resultIndex, int addendDigit) {
    int sum = result[resultIndex] + addendDigit;
    result[resultIndex] = sum % BASE9;
    int carry = sum / BASE9;
    if(carry > 0) {
      addOther(result, resultIndex - 1, carry);
    }
  }
  /**
   * multiplies the GinormousInts, has two helper methods to account for carry over and etc.
   * @return multiplied GinormousInts
   */
  private void multiplyCarry(int[] result, int resultIndex, int firstFactor, int secondFactor) {
    long prod = (long)firstFactor * (long)secondFactor;
    int prodDigit = (int)(prod % BASE9);
    int carry = (int)(prod / BASE9);
    addRemainder(result, resultIndex, carry, prodDigit);
  }
  private void multiplyOther(int[] result, int resultIndex, int[] leftFactor, int[] rightFactor) {
    for(int i = 0; i < leftFactor.length; i++) {
      for(int j = 0; j < rightFactor.length; j++) {
        multiplyCarry(result, resultIndex - (i + j), leftFactor[leftFactor.length-i-1], rightFactor[rightFactor.length-j-1]);
       }
    }
  }
  public GinormousInt multiply(GinormousInt that) {
    int[] result = new int[this.largeArray.length + that.largeArray.length];
    multiplyOther(result, result.length-1, this.largeArray, that.largeArray);
   return new GinormousInt(result);
  }
 /**
   * divides the GinormousInts, has two helper methods to account for remainder and etc.
   * @return divided GinormousInts
   */
    private int divideOther(int[] result, int resultIndex, int divident, int lastRemainder, int divisor) {
      assert divisor < BASE9;
      assert lastRemainder < divisor;
      long ent = divident + (long)BASE9 * lastRemainder;    
      long quot = ent / divisor;
      long rem = ent % divisor;
      assert quot < BASE9;
      assert rem < divisor;
      result[resultIndex] = (int)quot;
      return (int)rem;
    }
    private int divideRemainder(int[] result, int resultIndex, int[] divident, int dividentIndex, int divisor) {
        int remainder = 0;
        for(; dividentIndex < divident.length; dividentIndex++, resultIndex++) {
            remainder = divideOther(result, resultIndex, divident[dividentIndex], remainder, divisor);
        }
        return remainder;
    }
    public GinormousInt division(int divisor) {
        if(divisor <= 0 || BASE9 <= divisor) {
          throw new IllegalArgumentException("enter valid divisor");
        }
        int[] result = new int[largeArray.length];
        divideRemainder(result, 0, largeArray, 0, divisor);
        return new GinormousInt(result);
    }

    /**
     * compares GinormousInts, also includes equal method
     * @return -1 when less than, 0 if equal, and 1 if greater than
     */
    public int compareTo(GinormousInt that) {
      if(this.largeArray.length < that.largeArray.length) {
        return -1;
      }
      if (that.largeArray.length < this.largeArray.length) {
        return 1;
      }
      for(int i = 0; i < this.largeArray.length; i++) {
        if(this.largeArray[i] < that.largeArray[i]) {
          return -1;
        }
        if(that.largeArray[i] < this.largeArray[i]) {
          return 1;
        }
      }
        return 0;
    }
  /**
   *  The main program starts here
   *  Remember you are trying to BREAK your code, not just prove it works!
   */
  public static void main(String[] args) {
    GinormousInt a = new GinormousInt(7, 5, 2, 12345);
    System.out.println(a.toDecimalString());
    
    GinormousInt b = GinormousInt.valueOf(Long.MAX_VALUE);
    System.out.println(b.toDecimalString());
   
    GinormousInt c = b.plus(b).plus(b); 
    System.out.println(c.toDecimalString());
    
    GinormousInt d = c.multiply(b);
    System.out.println(d.toDecimalString());

    GinormousInt e = d.division(1000);
    System.out.println(e.toDecimalString());

    System.out.println("c <=> b: " + c.compareTo(b));
    System.out.println("b <=> c: " + b.compareTo(c));
  }
}
