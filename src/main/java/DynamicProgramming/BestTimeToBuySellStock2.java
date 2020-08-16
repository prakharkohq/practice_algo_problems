package DynamicProgramming;


/***
 *
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 *
 *   O(n) for every step either you can buy stock or sell. Maintain two variables 'cash'
 *   to save max value if you had sold the stock at current price and 'stock' to save max value if you
 *   had purchased the stock at current price. Return max cash
 *
 * */
public class BestTimeToBuySellStock2 {
    public static int MaxProfit(int[] prices) {
         // Easier Explanation
        /*
            profit: maximum total profit.
            buy: the day when buy stock.
            sell: the day when sell stock.
            days: maximum trade days.
        */
        int profit = 0, buy = 0, sell = 0, days = prices.length;

        while(buy < days && sell < days)
        {
            while(buy < days - 1 && prices[buy + 1] < prices[buy])
                buy++; // find the valley of prices

            sell = buy;

            while(sell < days - 1 && prices[sell + 1] > prices[sell])
                sell++; // find the peak of prices

            profit += prices[sell] - prices[buy];

            buy = sell + 1;
        }

        return profit;
    }

    public static int getMaxProfit(int[] prices) {
        int cash = 0, stock = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, prices[i] + stock );  // What is the status of the old purchase
            stock = Math.max(stock, cash - prices[i]); // Should i need to buy here
        }
        return cash;
    }

    public static void main(String[] args) {
        //1, 3, 2, 8, 4, 9
        int[] input = {7,1,4,4,4,5,3,6,4};
        System.out.println(MaxProfit(input));
    }


    public static int getMaxProfitWithFee(int[] prices, int fee) {
        int cash = 0, stock = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, prices[i] + stock - fee);
            stock = Math.max(stock, cash - prices[i]);
        }
        return cash;
    }
}
