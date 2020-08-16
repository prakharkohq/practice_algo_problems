package DynamicProgramming;

public class MinimumCoinChange {

    /**
     *
     * You are given coins of different denominations and a total amount of money amount.
     * Write a function to compute the fewest number of coins that you need to make up that
     * amount. If that amount of money cannot be made up by any combination of the coins, return -1.
     *
     * Input: coins = [1, 2, 5], amount = 11
     * Output: 3
     * Explanation: 11 = 5 + 5 + 1
     *
     * For the iterative solution, we think in bottom-up manner. Suppose we have already computed all the minimum counts up to sum,
     * what would be the minimum count for sum+1?
     *
     * */

    public static int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        // coins array should be sorted
        for(int i=1;i<=amount;i++){
            int min = Integer.MAX_VALUE;
            for(int coin:coins){
                // check if the coin fits the denomination
                if(i-coin>=0 && dp[i-coin] != -1)
                    min = dp[i-coin] < min ? dp[i-coin] :min;
            }
            // Set dp[i] to -1 if i (current amount) can not be reach by  coins array
            dp[i] = min== Integer.MAX_VALUE ? -1 : 1+min;
        }
        return dp[amount];
    }

    // count is for memoization coins[] array is input
    public static int minCoinRecursive(int [] coins, int rem, int[] count)
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
            int res = minCoinRecursive(coins, rem-coin, count);
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
       // int [] count = new int[rem];
        //System.out.println(minCoin(coins, rem , count));
       // System.out.println(Arrays.toString(count));
        System.out.println(coinChange(coins,rem));
    }
}
