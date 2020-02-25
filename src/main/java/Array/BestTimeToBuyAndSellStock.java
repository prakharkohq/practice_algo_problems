package Array;

/**
 * Problem Statement
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * // If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 * <p>
 * // Example 1:
 * // Input: [7, 1, 5, 3, 6, 4]
 * // Output: 5
 * <p>
 * // max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 * // Example 2:
 * // Input: [7, 6, 4, 3, 1]
 * // Output: 0
 * <p>
 * // In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuyAndSellStock {
    public static int findMaxProfit(int [] input )
    {
        int local_max = 0 ,global_max =0;
        int len = input.length;
        for (int i=0;i<len ;i++)
        {
            for (int j=i+1;j<len;j++)
            {
                if( input[i] < input[j] && local_max < input [j])
                    local_max = input[j];
            }
            int profit = local_max - input[i];
            if (profit > global_max)
            {
                 global_max = profit;
            }
        }
        return global_max;
    }
    public static void main(String[] args) {
        int [] input = {7, 6, 4, 3, 1};
        System.out.println(findMaxProfit(input));
    }
}
