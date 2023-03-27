//Leetcode - Recursive solution
//64. Minimum Path Sum
//Time complexity:  O(N*M)
//Space complexity: O((M-1)+(N-1)) + O(N*M)

import java.util.Arrays;

public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return minSumPathUtil(n - 1, m - 1, grid, dp);
    }

    static int minSumPathUtil(int i, int j, int[][] matrix, int[][] dp) {
        if (i == 0 && j == 0)
            return matrix[0][0];
        if (i < 0 || j < 0)
            return (int) Math.pow(10, 9);
        if (dp[i][j] != -1)
            return dp[i][j];

        int up = matrix[i][j] + minSumPathUtil(i - 1, j, matrix, dp);
        int left = matrix[i][j] + minSumPathUtil(i, j - 1, matrix, dp);

        return dp[i][j] = Math.min(up, left);
    }
}
