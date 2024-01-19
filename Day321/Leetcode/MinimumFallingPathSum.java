//Leetcode - Not accepted as TLE
//931. Minimum Falling Path Sum - Memoization/Top down
//Time complexity: O(N*N) - At max, there will be M*N calls of recursion to solve a new problem
//Space complexity: O(N) + O(N*M) - We are using a recursion stack space: O(N), where N is the path length and an external DP Array 
//of size 'N*M'.

package Leetcode;

import java.util.Arrays;

public class MinimumFallingPathSum {

    public static void main(String[] args) {
        int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
        System.out.println(minFallingPathSum(matrix));
    }

    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n][m];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            int ans = getMinUtil(n - 1, j, m, matrix, dp);
            mini = Math.min(mini, ans);
        }
        return mini;
    }

    static int getMinUtil(int i, int j, int m, int[][] matrix, int[][] dp) {
        // Base Conditions
        if (j < 0 || j >= m)
            return (int) Math.pow(10, 9);
        if (i == 0)
            return matrix[0][j];

        if (dp[i][j] != -1)
            return dp[i][j];

        int up = matrix[i][j] + getMinUtil(i - 1, j, m, matrix, dp);
        int leftDiagonal = matrix[i][j] + getMinUtil(i - 1, j - 1, m, matrix, dp);
        int rightDiagonal = matrix[i][j] + getMinUtil(i - 1, j + 1, m, matrix, dp);

        return dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
    }

}
