//Leetcode
//62. Unique Paths - Memoization/Top down 
//Time complexity: O(M*N) -  At max, there will be M*N calls of recursion.
//Space complexity: O((N-1)+(M-1)) + O(M*N) - We are using a recursion stack space:O((N-1)+(M-1)), 
//here (N-1)+(M-1) is the path length and an external DP Array of size 'M*N'.

package Leetcode;

import java.util.Arrays;

public class UniquePaths {

    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println(uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return countWaysUtil(m - 1, n - 1, dp);
    }

    static int countWaysUtil(int i, int j, int[][] dp) {
        if (i == 0 && j == 0)
            return 1;
        if (i < 0 || j < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int up = countWaysUtil(i - 1, j, dp);
        int left = countWaysUtil(i, j - 1, dp);
        return dp[i][j] = up + left;
    }

}
