package DynamicProgramming;

/**
 * Problem Stmt You are given coins of different denominations and a total amount of money.
 * Write a function to compute the number of combinations that make up that amount.
 * You may assume that you have infinite number of each kind of coin.
 * <p>
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 ***/
/**
 *
 * attribution_read,
 * ads_read,
 * read_insights,
 *
 * **/

import java.util.Arrays;

/**
 *
 * Steps to solve DP problem
 *
 * Create a DP Array for the problem with n+1 size of the changing variables
 *
 * do basic validations
 *
 * write base conditons
 *
 * memoize the solution
 *
 * */
public class UnboundedKnapsack {
    private static Integer[][] dp;

    public static void coinChange(int[] coins, int amount) {
        // First Validation and change matrix size
        if (amount == 0) {
            System.out.println(1);return;
        }

        if (coins.length == 0) {
            System.out.println(0);return;
        }
        dp = new Integer[coins.length][amount+1];
        //Arrays.fill(dp, -1);
        System.out.println(coinChangeRecursive(coins, amount, 0));
        System.out.println(Arrays.deepToString(dp));
    }

    public static int coinChangeRecursive(int[] coins, int amount, int currentIndex) {
        // Base Condition
        if (amount == 0)
            return 1;
        if (currentIndex == coins.length || amount < 0)
            return 0;
        if (dp[currentIndex][amount] != null)
            return dp[currentIndex][amount];
        // choices if we include the coin or exclude the coin
        // INCL
        int sum1 = coinChangeRecursive(coins, (amount - coins[currentIndex]),currentIndex );

        // EXCL
        int sum2 = coinChangeRecursive(coins, amount ,currentIndex +1 );
        dp[currentIndex][amount] = sum1 + sum2;
        return dp[currentIndex][amount];
    }

    public static void main(String[] args) {
        int[] coins = {10};
        int amount = 10;
        coinChange(coins, amount);
    }

}
