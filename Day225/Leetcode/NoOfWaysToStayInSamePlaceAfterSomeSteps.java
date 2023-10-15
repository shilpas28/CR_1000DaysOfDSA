//Leetcode
//1269. Number of Ways to Stay in the Same Place After Some Steps - Tabulation/Bottom up
//Time complexity: The code uses a nested loop, where the outer loop runs m times, and the inner loop runs n times. So, the 
//time complexity is O(m∗n). In the worst case, where m is large, this algorithm can have a time complexity 
//of O(steps^2)
//Space complexity: The space complexity is determined by the 2D array dp, which has dimensions (m + 1) x n. So, the 
//space complexity is O(m * n). In the worst case, where m is large, this algorithm can have a space complexity of O(steps^2).

package Leetcode;

public class NoOfWaysToStayInSamePlaceAfterSomeSteps {

    public static void main(String[] args) {
        int steps = 3, arrLen = 2;
        System.out.println(numWays(steps, arrLen));
    }

    public static int numWays(int steps, int arrLen) {
        int m = steps;
        int n = Math.min(steps / 2 + 1, arrLen);
        int[][] dp = new int[m + 1][n];
        dp[0][0] = 1;
        int mod = 1000000007;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j > 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % mod;
                }
                if (j < n - 1) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % mod;
                }
            }
        }
        
        return dp[m][0];
    }
}
