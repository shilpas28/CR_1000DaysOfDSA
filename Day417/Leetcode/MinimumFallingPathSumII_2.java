//Leetcode
//1289. Minimum Falling Path Sum II - Memoization
//Time complexity: O(N^2)
//Space complexity: O(N)

package Leetcode;

import java.util.Arrays;

public class MinimumFallingPathSumII_2 {

    public static void main(String[] args) {
        int[][] grid = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(minFallingPathSum(grid));
    }

    static int[][] dp;

    public static int minFallingPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = rows;
        dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        int result = Integer.MAX_VALUE;

        for (int j = 0; j < cols; j++) {
            result = Math.min(result, recurHelper(grid, rows - 1, j));
        }
        return result;
    }

    public static int recurHelper(int[][] nums, int rowIndex, int colIndex) {
        if (rowIndex < 0 || colIndex < 0 || colIndex > nums[0].length) {
            return Integer.MAX_VALUE;
        } else if (rowIndex == 0) {
            return nums[rowIndex][colIndex];
        } else {
            if (dp[rowIndex][colIndex] != Integer.MAX_VALUE) {
                return dp[rowIndex][colIndex];
            } else {
                int res = nums[rowIndex][colIndex];
                int val = Integer.MAX_VALUE;
                for (int i = 0; i < nums[0].length; i++) {
                    if (i == colIndex) {
                        continue;
                    }
                    val = Math.min(val, recurHelper(nums, rowIndex - 1, i));
                }
                dp[rowIndex][colIndex] = res + val;
                return res + val;
            }
        }
    }
}
