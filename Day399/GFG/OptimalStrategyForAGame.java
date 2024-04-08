//GFG
//Optimal Strategy For A Game
//Time complexity: O(N*N)
//Space complexity: O(N*N)

package GFG;

import java.util.Arrays;

public class OptimalStrategyForAGame {

    public static void main(String[] args) {
        int n = 4;
        int arr[] = { 5, 3, 7, 10 };
        System.out.println(countMaximum(n, arr));
    }

    // Function to find the maximum possible amount of money we can win.
    static long countMaximum(int n, int arr[]) {
        // Your code here
        long dp[][] = new long[n][n];
        for (long temp[] : dp)
            Arrays.fill(temp, -1);
        return help(0, n - 1, arr, dp);
    }

    static long help(int i, int j, int arr[], long dp[][]) {
        if (i > j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        long sum1 = arr[i], sum2 = arr[j];
        sum1 += Math.min(help(i + 2, j, arr, dp), help(i + 1, j - 1, arr, dp));
        sum2 += Math.min(help(i + 1, j - 1, arr, dp), help(i, j - 2, arr, dp));
        return dp[i][j] = Math.max(sum1, sum2);
    }
}
