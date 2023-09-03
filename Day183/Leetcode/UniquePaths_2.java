//Leetcode
//62. Unique Paths - Tabulation/Bottom up
//Time complexity: O(M*N) - There are two nested loops
//Space complexity: O(M*N) - We are using an external array of size 'M*N'.

package Leetcode;

import java.util.Arrays;

public class UniquePaths_2 {

    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println(uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return countWaysUtil(m, n, dp);
    }

    static int countWaysUtil(int m, int n, int[][] dp) {

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // base condition
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;
                if (i > 0)
                    up = dp[i - 1][j];
                if (j > 0)
                    left = dp[i][j - 1];
                dp[i][j] = up + left;
            }
        }
        return dp[m - 1][n - 1];
    }
}
