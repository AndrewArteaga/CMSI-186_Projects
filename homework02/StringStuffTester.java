/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  StringStuffTester.java
 *  Purpose       :  A test harness file for testing out the methods in the "StringStuff.java" class
 *  Author        :  B.J. Johnson
 *  Date          :  2017-01-25
 *  Description   :  This file provides the "test harness" for checking out the methods which are part of
 *                   the homework02 assignment.  It also provides examples of proper documentation, and
 *                   uses the source file header template as specified in the "Greeter.java" template file
 *                   for use in CMSI 186, Spring 2017.
 *  Notes         :  TEMPLATE FILE ONLY: Your job is to fill in as many test cases as you think are needed
 *                   to thoroughly and completely test your StringStuff class.
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-25  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class StringStuffTester {

  /**
   * the main method which calls all of the test methods in the class
   * @param args String[] array containing command line parameters
   * @return void
   */
   public static void main ( String [] args ) {

      test_containsVowel();      // 12 tests
      test_isPalindrome();       // 12 tests
      test_evensOnly();          // 10 tests
      test_oddsOnly();           // 10 tests
      test_evensOnlyNoDupes();   // 10 tests
      test_oddsOnlyNoDupes();    // 10 tests
      test_reverse();            // 7 tests
   }

  /**
   * test method to test out the operation of the containsVowel method
   */
   public static void test_containsVowel() {
    System.out.println( "\n12 TESTS FOR containsVowel():" );
    
    System.out.print( "   Test for blank space: " );
    try { System.out.println( StringStuff.containsVowel( " " ) ? "true" : "false" ); }
    catch( Exception e ) { System.out.println ( false ); }

    System.out.print( "   Test for single lowercase vowel o: " );
    try { System.out.println( StringStuff.containsVowel( "o" ) ? "true" : "false" ); }
    catch( Exception e ) { System.out.println ( false ); }

    System.out.print( "   Test for single uppercase vowel I: " );
    try { System.out.println( StringStuff.containsVowel( "I" ) ? "true" : "false" ); }
    catch( Exception e ) { System.out.println ( false ); }

    System.out.print( "   Test for single lowercase constanant d: " );
    try { System.out.println( StringStuff.containsVowel( "d" ) ? "true" : "false" ); }
    catch( Exception e ) { System.out.println ( false ); }

    System.out.print( "   Test for single uppercase constanant R: " );
    try { System.out.println( StringStuff.containsVowel( "R" ) ? "true" : "false" ); }
    catch( Exception e ) { System.out.println ( false ); }

    System.out.print( "   Test vowel in the word imagination: " );
    try { System.out.println( StringStuff.containsVowel( "imagination" ) ? "true" : "false" ); }
    catch( Exception e ) { System.out.println ( false ); }

    System.out.print( "   Test vowel in the word lynch: " );
    try { System.out.println( StringStuff.containsVowel( "lynch" ) ? "true" : "false" ); }
    catch( Exception e ) { System.out.println ( false ); }

    System.out.print( "   Test vowel in the word bzzt: " );
    try { System.out.println( StringStuff.containsVowel( "bzzt" ) ? "true" : "false" ); }
    catch( Exception e ) { System.out.println ( false ); }

    System.out.print( "   Test vowel in the word number 13: " );
    try { System.out.println( StringStuff.containsVowel( "13" ) ? "true" : "false" ); }
    catch( Exception e ) { System.out.println ( false ); }

    System.out.print( "   Test vowel in the word !@#$%^&*(: " );
    try { System.out.println( StringStuff.containsVowel( "!@#$%^&*(" ) ? "true" : "false" ); }
    catch( Exception e ) { System.out.println ( false ); }

    System.out.print( "   Test vowel in the word NAmeTag: " );
    try { System.out.println( StringStuff.containsVowel( "NAmeTag" ) ? "true" : "false" ); }
    catch( Exception e ) { System.out.println ( false ); }

    System.out.print( "   Test vowel in the word Bj JhnsN: " );
    try { System.out.println( StringStuff.containsVowel( "Bj JhnsN" ) ? "true" : "false" ); }
    catch( Exception e ) { System.out.println ( false ); }
   }

  /**
   * test method to test out the operation of the isPalindrome method
   */
   public static void test_isPalindrome() {
    System.out.println( "\n12 TESTS FOR isPalindrome():" );
    
    System.out.print( "   Test for blank space: " );
    try { System.out.println( StringStuff.isPalindrome( " " ) ? "true" : "false" ); }
    catch( Exception e ) { System.out.println ( false ); }

    System.out.print( "   Test for a single lowercase letter q: " );
    try { System.out.println( StringStuff.isPalindrome( "q" ) ? "true" : "false" ); }
    catch( Exception e ) { System.out.println ( false ); }

    System.out.print( "   Test for a single uppercase letter Y: " );
    try { System.out.println( StringStuff.isPalindrome( "Y" ) ? "true" : "false" ); }
    catch( Exception e ) { System.out.println ( false ); }

    System.out.print( "   Test for the word aba: " );
    try { System.out.println( StringStuff.isPalindrome( "aba" ) ? "true" : "false" ); }
    catch( Exception e ) { System.out.println ( false ); }

    System.out.print( "   Test for the word racecar: " );
    try { System.out.println( StringStuff.isPalindrome( "racecar" ) ? "true" : "false" ); }
    catch( Exception e ) { System.out.println ( false ); }

    System.out.print( "   Test for the word touch: " );
    try { System.out.println( StringStuff.isPalindrome( "touch" ) ? "true" : "false" ); }
    catch( Exception e ) { System.out.println ( false ); }

    System.out.print( "   Test for the word detartrated: " );
    try { System.out.println( StringStuff.isPalindrome( "detartrated" ) ? "true" : "false" ); }
    catch( Exception e ) { System.out.println ( false ); }

    System.out.print( "   Test for the number 234: " );
    try { System.out.println( StringStuff.isPalindrome( "234" ) ? "true" : "false" ); }
    catch( Exception e ) { System.out.println ( false ); }

    System.out.print( "   Test for the number 161: " );
    try { System.out.println( StringStuff.isPalindrome( "161" ) ? "true" : "false" ); }
    catch( Exception e ) { System.out.println ( false ); }
    
    System.out.print( "   Test for the phrase Al lets Della call Ed “Stella.”: " );
    try { System.out.println( StringStuff.isPalindrome( "Al lets Della call Ed 'Stella'" ) ? "true" : "false" ); }
    catch( Exception e ) { System.out.println ( false ); }

    System.out.print( "   Test for the phrase Are we not pure? “No, sir!” Panama’s moody Noriega brags. “It is garbage!” Irony dooms a man—a prisoner up to new era: " );
    try { System.out.println( StringStuff.isPalindrome( "Are we not pure? 'No, sir!' Panama’s moody Noriega brags. 'It is garbage!' Irony dooms a man—a prisoner up to new era" ) ? "true" : "false" ); }
    catch( Exception e ) { System.out.println ( false ); }

    System.out.print( "   Test for the phrase hello there: " );
    try { System.out.println( StringStuff.isPalindrome( "hello there:" ) ? "true" : "false" ); }
    catch( Exception e ) { System.out.println ( false ); }
   }

  /**
   * test method to test out the operation of the evensOnly method
   */
   public static void test_evensOnly() {
    System.out.println( "\n10 TESTS FOR evensOnly:" );   
    System.out.println( "evensOnly(' ') returns: " + StringStuff.evensOnly( " " ) );
    System.out.println( "evensOnly('REHEARSALSZ') returns: " + StringStuff.evensOnly( "REHEARSALSZ" ) );
    System.out.println( "evensOnly('REhearSALsz') returns: " + StringStuff.evensOnly( "REhearSALsz" ) );
    System.out.println( "evensOnly('xylophones') returns: " + StringStuff.evensOnly( "xylophones" ) );
    System.out.println( "evensOnly('XYloPHonES') returns: " + StringStuff.evensOnly( "XYloPHonES" ) );
    System.out.println( "evensOnly('ANDREW arteaga') returns: " + StringStuff.evensOnly( "ANDREW arteaga" ) );
    System.out.println( "evensOnly('andrew ARTEAGA') returns: " + StringStuff.evensOnly( "andrew ARTEAGA" ) );
    System.out.println( "evensOnly('Al lets Della call Ed 'Stella'') returns: " + StringStuff.evensOnly( "Al lets Della call Ed 'Stella'" ) );
    System.out.println( "evensOnly('3131') returns: " + StringStuff.evensOnly( "3131" ) );
    System.out.println( "evensOnly('ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz') returns: " + StringStuff.evensOnly( "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz" ) );
   }

  /**
   * test method to test out the operation of the oddsOnly method
   */
   public static void test_oddsOnly() {
     System.out.println( "\n10 TESTS FOR oddsOnly():" );
     System.out.println( "oddsOnly(' ') returns: " + StringStuff.oddsOnly( " " ) );
     System.out.println( "oddsOnly('xylophones') returns: " + StringStuff.oddsOnly( "xylophones" ) );
     System.out.println( "oddsOnly('XYloPHonES') returns: " + StringStuff.oddsOnly( "XYloPHonES" ) );
     System.out.println( "oddsOnly('REHEARSALSZ') returns: " + StringStuff.oddsOnly( "REHEARSALSZ" ) );
     System.out.println( "oddsOnly('REhearSALsz') returns: " + StringStuff.oddsOnly( "REhearSALsz" ) );
     System.out.println( "oddsOnly('ANDREW arteaga') returns: " + StringStuff.oddsOnly( "ANDREW arteaga" ) );
     System.out.println( "oddsOnly('andrew ARTEAGA') returns: " + StringStuff.oddsOnly( "andrew ARTEAGA" ) );
     System.out.println( "oddsOnly('Al lets Della call Ed 'Stella'') returns: " + StringStuff.oddsOnly( "Al lets Della call Ed 'Stella'" ) );
     System.out.println( "oddsOnly('3131') returns: " + StringStuff.oddsOnly( "3131" ) );
     System.out.println( "oddsOnly('ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz') returns: " + StringStuff.oddsOnly( "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz" ) );
   }

  /**
   * test method to test out the operation of the evensOnlyNoDupes method
   */
   public static void test_evensOnlyNoDupes() {
    System.out.println( "\n10 TESTS FOR evensOnlyNoDupes:" );
    System.out.println( "evensOnlyNoDupes(' ') returns: " + StringStuff.evensOnlyNoDupes( " " ) );
    System.out.println( "evensOnlyNoDupes('REHEARSALSZ') returns: " + StringStuff.evensOnlyNoDupes( "REHEARSALSZ" ) );
    System.out.println( "evensOnlyNoDupes('REhearSALsz') returns: " + StringStuff.evensOnlyNoDupes( "REhearSALsz" ) );
    System.out.println( "evensOnlyNoDupes('xylophones') returns: " + StringStuff.evensOnlyNoDupes( "xylophones" ) );
    System.out.println( "evensOnlyNoDupes('XYloPHonES') returns: " + StringStuff.evensOnlyNoDupes( "XYloPHonES" ) );
    System.out.println( "evensOnlyNoDupes('ANDREW arteaga') returns: " + StringStuff.evensOnlyNoDupes( "ANDREW arteaga" ) );
    System.out.println( "evensOnlyNoDupes('andrew ARTEAGA') returns: " + StringStuff.evensOnlyNoDupes( "andrew ARTEAGA" ) );
    System.out.println( "evensOnlyNoDupes('Al lets Della call Ed 'Stella'') returns: " + StringStuff.evensOnlyNoDupes( "Al lets Della call Ed 'Stella'" ) );
    System.out.println( "evensOnlyNoDupes('3131') returns: " + StringStuff.evensOnlyNoDupes( "3131" ) );
    System.out.println( "evensOnlyNoDupes('ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz') returns: " + StringStuff.evensOnlyNoDupes( "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz" ) );
}

  /**
   * test method to test out the operation of the oddsOnlyNoDupes method
   */
   public static void test_oddsOnlyNoDupes() {
    System.out.println( "\n10 TESTS FOR oddsOnlyNoDupes():" );
    System.out.println( "oddsOnlyNoDupes(' ') returns: " + StringStuff.oddsOnlyNoDupes( " " ) );
    System.out.println( "oddsOnlyNoDupes('xylophones') returns: " + StringStuff.oddsOnlyNoDupes( "xylophones" ) );
    System.out.println( "oddsOnlyNoDupes('XYloPHonES') returns: " + StringStuff.oddsOnlyNoDupes( "XYloPHonES" ) );
    System.out.println( "oddsOnlyNoDupes('REHEARSALSZ') returns: " + StringStuff.oddsOnlyNoDupes( "REHEARSALSZ" ) );
    System.out.println( "oddsOnlyNoDupes('REhearSALsz') returns: " + StringStuff.oddsOnlyNoDupes( "REhearSALsz" ) );
    System.out.println( "oddsOnlyNoDupes('ANDREW arteaga') returns: " + StringStuff.oddsOnlyNoDupes( "ANDREW arteaga" ) );
    System.out.println( "oddsOnlyNoDupes('andrew ARTEAGA') returns: " + StringStuff.oddsOnlyNoDupes( "andrew ARTEAGA" ) );
    System.out.println( "oddsOnlyNoDupes('Al lets Della call Ed 'Stella'') returns: " + StringStuff.oddsOnlyNoDupes( "Al lets Della call Ed 'Stella'" ) );
    System.out.println( "oddsOnlyNoDupes('3131') returns: " + StringStuff.oddsOnlyNoDupes( "3131" ) );
    System.out.println( "oddsOnlyNoDupes('ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz') returns: " + StringStuff.oddsOnlyNoDupes( "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz" ) );
   }
  /**
   * test method to test out the operation of the reverse method
   */
   public static void test_reverse() {
     System.out.println( "\n7 TESTS FOR reverse():" );
     System.out.println( "reverse('cba') returns: " + StringStuff.reverse( "cba" ) );
     System.out.println( "reverse('REHEARSALSZ') returns: " + StringStuff.reverse( "REHEARSALSZ" ) );
     System.out.println( "reverse('XYloPHonES') returns: " + StringStuff.reverse( "XYloPHonES" ) );
     System.out.println( "reverse('amanaplanacanalpanama') returns: " + StringStuff.reverse( "amanaplanacanalpanama" ) );
     System.out.println( "reverse('Al lets Della call Ed 'Stella'') returns: " + StringStuff.reverse( "Al lets Della call Ed 'Stella'" ) );
     System.out.println( "reverse(' ') returns: " + StringStuff.reverse( " " ) );
     System.out.println( "reverse('3131') returns: " + StringStuff.reverse( "3131" ) );
   }

}
