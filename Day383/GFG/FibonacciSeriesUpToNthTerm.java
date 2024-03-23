//GFG
//Fibonacci series up to Nth term - Using DP
//Time complexity: O(n)
//Space complexity: O(n)

package GFG;

import java.util.Arrays;

public class FibonacciSeriesUpToNthTerm {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(Arrays.toString(Series(n)));
    }

    static int[] Series(int n) {
        // code here
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        int mod = 1000000007;

        for (int i = 2; i <= n; ++i) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }
        return dp;
    }
}
