package DynamicProgramming;


/****
 *  Caching basis the memoization for 3D array s
 *
 * 	// Method2A1()- recursive solution with memoization (Top-down approach caching on method level)
 * 	public static int LCSubStrM2A1(char[] X, char[] Y, int m, int n, int lcsCount, Integer[][][] dp) {
 * 		if (m <= 0 || n <= 0)
 * 			return lcsCount;
 *
 * 		if (dp[m][n][lcsCount] != null)
 * 			return dp[m][n][lcsCount];
 *
 * 		int lcsCount1=lcsCount;
 * 		if (X[m - 1] == Y[n - 1])
 * 			lcsCount1 = LCSubStrM2A1(X, Y, m - 1, n - 1, lcsCount + 1, dp);
 *
 * 		int lcsCount2 = LCSubStrM2A1(X, Y, m, n - 1, 0, dp);
 * 		int lcsCount3 = LCSubStrM2A1(X, Y, m - 1, n, 0, dp);
 *
 * 		return dp[m][n][lcsCount] = Math.max(lcsCount1, Math.max(lcsCount2, lcsCount3));
 *        }
 *
 *  // Method3()- DP solution(Bottom up approach)
 * 	// time complexity - O(m*n)
 * 	// space complexity - O(m*n)
 *
 *  public static int LCSubStrA3(char[] X, char[] Y, int m, int n) {
 * 		int memo[][] = new int[m + 1][n + 1];
 * 		int result = 0;
 *
 * 		for (int i = 0; i <= m; i++) {
 * 			for (int j = 0; j <= n; j++) {
 * 				if (i == 0 || j == 0) {
 * 					memo[i][j] = 0;
 *                                }
 *               else if (X[i - 1] == Y[j - 1]) {
 * 					memo[i][j] = memo[i - 1][j - 1] + 1;
 * 					result = Math.max(result, memo[i][j]);
 *                } else {
 * 					memo[i][j] = 0;
 *                }*                    }
 * 		}
 * 		return     result;
 * 	}
 *
 * ****/
public class LongestCommonSubstring {
    static String X ="abcdxyz";
    static String Y ="xyzabcd";

    // Using recursion to solve this problem
    static int lcs(int i, int j ,int count)
    {
        // Base condition { Smallest valid input }
        if ( i ==0 || j==0 )
            return count;
        // Other choice diagram { two choices if two values can be having same char or not }
        if (X.charAt(i-1) == Y.charAt(j-1))
            count = lcs(i-1 , j-1  ,count+1);
        else
            // In case final count will be max of existing count and both the calls made by decreasing the strings both by one one length
            count = Math.max(count , Math.max(lcs(i-1 , j ,0 ),lcs(i , j-1 , 0)));

        return count;
    }

    public static void main(String[] args) {
        // Always remember when calling string length use len -1
        System.out.println(lcs(X.length(),Y.length(),0));
    }

}
