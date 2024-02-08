//Leetcode
//279. Perfect Squares - Bottom UP DP (Using DP Array)
//Time complexity: O(N * sqrt(N))
//Space complexity: O(N)

package Leetcode;

public class PerfectSquares_3 {

    public static void main(String[] args) {
        int n = 12;
        System.out.println(numSquares(n));
    }

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = i;

            for (int j = 1; j * j <= i; j++) {
                int square = j * j;
                dp[i] = Math.min(dp[i], 1 + dp[i - square]);
            }
        }
        return dp[n];
    }
}
