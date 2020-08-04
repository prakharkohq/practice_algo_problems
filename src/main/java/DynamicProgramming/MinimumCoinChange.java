package DynamicProgramming;

import java.util.Arrays;

public class MinimumCoinChange {

    /**
     * You are given coins of different denominations and a total amount of money amount.
     * Write a function to compute the fewest number of coins that you need to make up that
     * amount. If that amount of money cannot be made up by any combination of the coins, return -1.
     *
     * Input: coins = [1, 2, 5], amount = 11
     * Output: 3
     * Explanation: 11 = 5 + 5 + 1
     *
     * */
    // count is for memoization coins[] array is input
    public static int minCoin(int [] coins, int rem, int[] count)
    {
        if (rem == 0)
            return 0; // completed
        if (rem < 0)
            return  -1; // Invalid
        // check memoized array
        if (count[rem -1 ] != 0)
            return count[rem -1 ];
        int min = Integer.MAX_VALUE;
        // Call all recursive methods to populate the met
        for (int coin:coins)
        {
            int res = minCoin(coins, rem-coin, count);
            if (res >= 0 && res < min)
                min = 1+ res;
        }
        count[rem -1] = ((min == Integer.MAX_VALUE) ? -1: min );
        return count[rem - 1 ];

    }

    public static void main(String[] args) {
    // Int [] coins for { 9,6,5,1 } Weight which is desired
        int [] coins = { 9,6,5,1 };
        int  rem = 11 ; // Amount that we want to process
        int [] count = new int[rem];
        System.out.println(minCoin(coins, rem , count));
        System.out.println(Arrays.toString(count));
    }
}
