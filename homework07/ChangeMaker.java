/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  ChangeMaker.java
 * Purpose    :  Program to determine the optimal amount of coins necessary to make a given input amount
 * @author    :  Mosty Professor Johnson except for one section of code
 * @author    :  Andrew Arteaga
 * Date       :  2017-05-03
 * Description:  This program is an algorithm that generates the optimal amount of coins needed to make a 
 *               a given value. It also checks to see if the has user has valid inputs as well. 
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:   Reason for change or modification
 *  -----  ----------  ------------   ---------------------------------------------------------------------
 *  1.0.0  2017-04-19  B.J. Johnson   Initial release; stolen blatently from Professor Don Murphy with his
 *                                    express permission and blessing; just added this comment block
 *  1.1.0  2017-05-03  Andrew Arteaga Added complete JavaDocs; Added algorithm; Got it to compile and run
 *                                    smoothly
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
public class ChangeMaker {

   /**
    *  Main method that calls makeChangeWithDynamicProgramming and handles 
    *  all of the input arguments.
    */
    public static void main(String[] args) {
        if (args.length != 2) {
            printUsage();
            return;
        }

        try {

            String[] denominationStrings = args[0].split(",");
            int[] denominations = new int[denominationStrings.length];

            for (int i = 0; i < denominations.length; i++) {
                denominations[i] = Integer.parseInt(denominationStrings[i]);
                if (denominations[i] <= 0) {
                    System.out.println("Denominations must all be greater than zero.\n");
                    printUsage();
                    return;
                }

                for (int j = 0; j < i; j++) {
                    if (denominations[j] == denominations[i]) {
                        System.out.println("Duplicate denominations are not allowed.\n");
                        printUsage();
                        return;
                    }
                }
            }

            int amount = Integer.parseInt(args[1]);
            if (amount < 0) {
                System.out.println("Change cannot be made for negative amounts.\n");
                printUsage();
                return;
            }



            Tuple change = makeChangeWithDynamicProgramming(denominations, amount);
            if (change.isImpossible()) {
                System.out.println("It is impossible to make " + amount + " cents with those denominations.");
            } else {
                int coinTotal = change.total();
                System.out.println(amount + " cents can be made with " + coinTotal + " coin" +
                        getSimplePluralSuffix(coinTotal) + " as follows:");

                for (int i = 0; i < denominations.length; i++) {
                    int coinCount = change.getElement(i);
                    System.out.println("- "  + coinCount + " " + denominations[i] + "-cent coin" +
                            getSimplePluralSuffix(coinCount));
                }
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Denominations and amount must all be integers.\n");
            printUsage();
        }
    }
  /**
   * Method that takes in an array of coins and the desired amount then calculates the optimal amount 
   * coins needed to produce said amount.
   *
   * @param denominations  the array of coins 
   * @param amount         the amount that the coins will add up to
   *
   * @return optimal number of coins that can create the amount desired
   */
    public static Tuple makeChangeWithDynamicProgramming(int[] denominations, int amount) {    
        Tuple[][] end = new Tuple[denominations.length][amount + 1];       
        for (int i = 0; i < denominations.length; i++) {        
            for (int j = 0; j < amount+1; j++) {    
                if (j == 0) {
                    end[i][j] =  new Tuple(denominations.length);                
                } else {    
                    if (j >= denominations[i]){
                        end[i][j] = new Tuple(denominations.length);
                        end[i][j].setElement(i,1);  
                        if (end[i][j-denominations[i]].equals(Tuple.IMPOSSIBLE)) {
                            end[i][j] = Tuple.IMPOSSIBLE;
                        } else if (!end[i][j-denominations[i]].equals(Tuple.IMPOSSIBLE)) {
                            end[i][j] = end[i][j].add(end[i][j-denominations[i]]);
                        }
                    } else {
                        end[i][j] = Tuple.IMPOSSIBLE;
                    }                  
                }
                if (i != 0) {
                    if (!end[i][j].equals(Tuple.IMPOSSIBLE)) {
                        if (end[i-1][j].equals(Tuple.IMPOSSIBLE)) {
                            // leave it alone
                        } else if (!end[i-1][j].equals(Tuple.IMPOSSIBLE)) {
                            if (end[i-1][j].total() < end[i][j].total()) {
                                 end[i][j] = end[i-1][j];
                            } else {
                                // leave it alone
                            } 
                        }
                    } else {                        
                        if (!(end[i-1][j].equals(Tuple.IMPOSSIBLE))) {
                            end[i][j] = end[i-1][j];
                        }
                    } 
                } 
            }
        }
        return end[denominations.length-1][amount];
    }
   /**
    *  Method to tell user how to properly input coins and desired amount.
    *  Supposed to show when user fails to input correct values into the terminal.
    */
    private static void printUsage() {
        System.out.println("Usage: java DynamicChangemaker <denominations> <amount>");
        System.out.println("  - <denominations> is a comma-separated list of denominations (no spaces)");
        System.out.println("  - <amount> is the amount for which to make change");
    }
   /**
    *  Method to make coin plural if there is more than one of the same coin being used.
    *  @param count  the number of coins
    *
    *  @return adds an s if there is more of the same coin being used
    */
    private static String getSimplePluralSuffix(int count) {
        return count == 1 ? "" : "s";
    }

}
