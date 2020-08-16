package DynamicProgramming;
import java.util.Arrays;
public class BestTimeToBuySellStock {
    /**
     *
     * Solution is written for One Transaction
     *
     * **/
    static int getMaxProfit(int[] arr) {
        int[] dp = new int[arr.length ];
        Arrays.fill(dp, 0);
        int min = arr[0];
        dp[0] = 0;
        for (int i = 1; i < arr.length ; i++) {
            if (arr[i] < min)
                min = arr[i];
            dp[i] = arr[i] - min;
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        int[] input = {2, 1, 1, 1, 100};
        System.out.println(getMaxProfit(input));
    }
}
