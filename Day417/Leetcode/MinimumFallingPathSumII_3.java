//Leetcode
//1289. Minimum Falling Path Sum II - Bottom Up DP
//Time complexity: O(N^3)
//Space complexity: O(N^2)

package Leetcode;

import java.util.Arrays;

public class MinimumFallingPathSumII_3 {

    public static void main(String[] args) {
        int[][] grid = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(minFallingPathSum(grid));
    }

    public static int minFallingPathSum(int[][] grid) {
        int result = Integer.MAX_VALUE;
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            dp[0][i] = grid[0][i];
        }

        for (int i = 1; i < grid.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for (int j = 0; j < grid[0].length; j++) {
                for (int k = 0; k < grid[0].length; k++) {
                    if (k != j) {
                        dp[i][j] = Math.min(dp[i][j], grid[i][j] + dp[i - 1][k]);
                    }
                }
            }
        }

        for (int i = 0; i < grid[0].length; i++) {
            result = Math.min(result, dp[grid.length - 1][i]);
        }
        return result;
    }
}
