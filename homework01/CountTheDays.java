
/**
 *  File name     :  CountTheDays.java
 *  Purpose       :  Solution to #5 of homework01
 *  Author        :  Andrew Arteaga
 *  Date          :  2017-01-26
 *  Description   :  Outputs the absolute number of days between two given dates which are specified via args[0] through args[5].
 *                   The order of the two dates is irrelevant, uses all require methods defined in CalendarStuff, and this program 
 *                   extends CalendarStuff.
 *  @version 1.0.0  2017-01-26  Andrew Arteaga  Initial writing and release
 */
 public class CountTheDays extends CalendarStuff{
   public static void main(String[] args) {
   	long a = Long.parseLong(args[0]);
   	long b = Long.parseLong(args[1]);
   	long c = Long.parseLong(args[2]);
   	long d = Long.parseLong(args[3]);
   	long e = Long.parseLong(args[4]);
   	long f = Long.parseLong(args[5]);
   	if (args.length != 6) {
          System.out.println("Please add two different, valid dates in numbers and in the of format: month1, day1, year1, month2, day2, year2. It does not matter the order.");
      } else if (isValidDate(a, b, c)!=true || isValidDate(d, e, f)!=true) {
      	  System.out.println("One of the dates is not valid.");
      } else {
          System.out.println("The difference between the two dates is " + daysBetween(a, b, c, d, e, f ) + " .");
      	}

  	}
}
 

