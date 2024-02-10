//GFG
//Number of paths in a matrix with k coins
//Time complexity: O(n*n*k)
//Space complexity: O(n*n*k)

package GFG;

import java.util.Arrays;

public class NumberOfPathsInAMatrixWithKCoins {

    public static void main(String[] args) {
        int k = 12, n = 3;
        int arr[][] = { { 1, 2, 3 },
                { 4, 6, 5 },
                { 3, 2, 1 } };
        System.out.println(numberOfPath(n, k, arr));
    }

    static long numberOfPath(int n, int k, int[][] arr) {
        // code here
        long[][][] dp = new long[n + 1][n + 1][k + 1];
        for (long[][] row : dp) {
            for (long[] row2 : row) {
                Arrays.fill(row2, -1);
            }
        }
        return f(0, 0, n, k, arr, dp);
    }

    static long f(int i, int j, int n, int k, int[][] arr, long[][][] dp) {
        if (i == n - 1 && j == n - 1 && k == arr[i][j])
            return 1;
        if (i >= n || j >= n || k < 0)
            return 0;
        if (dp[i][j][k] != -1)
            return dp[i][j][k];

        long d = f(i + 1, j, n, k - arr[i][j], arr, dp);
        long r = f(i, j + 1, n, k - arr[i][j], arr, dp);

        return dp[i][j][k] = d + r;
    }
}
