//Leetcode - Solution accepted 
//931. Minimum Falling Path Sum - Tabulation/Bottom up
//Time complexity: O(N*M) - There are two nested loops
//Space complexity: O(N*M) - We are using an external array of size 'N*M'. The stack space will be eliminated.

package Leetcode;

public class MinimumFallingPathSum_2 {

    public static void main(String[] args) {
        int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
        System.out.println(minFallingPathSum(matrix));
    }

    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];

        // Initializing first row - base condition
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int up = matrix[i][j] + dp[i - 1][j];

                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0)
                    leftDiagonal += dp[i - 1][j - 1];
                else
                    leftDiagonal += (int) Math.pow(10, 9);

                int rightDiagonal = matrix[i][j];
                if (j + 1 < m)
                    rightDiagonal += dp[i - 1][j + 1];
                else
                    rightDiagonal += (int) Math.pow(10, 9);

                dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
        }
        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            mini = Math.min(mini, dp[n - 1][j]);
        }
        return mini;
    }
}
