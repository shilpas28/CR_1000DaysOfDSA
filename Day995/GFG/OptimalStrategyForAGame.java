//GFG
//Optimal Strategy For A Game
//Time complexity: O(n^2)
//Space complexity: O(n^2) 

import java.util.Arrays;

public class OptimalStrategyForAGame {

    public static void main(String[] args) {
        int arr[] = {5, 3, 7, 10};
        System.out.println(maximumAmount(arr));
    }

    public static int maximumAmount(int arr[]) {
        // code here
        int n = arr.length;
        long dp[][] = new long[n][n];
        for (long temp[] : dp) {
            Arrays.fill(temp, -1);
        }
        return (int) help(0, n - 1, arr, dp);
    }

    static long help(int i, int j, int arr[], long dp[][]) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        long sum1 = arr[i], sum2 = arr[j];
        sum1 += Math.min(help(i + 2, j, arr, dp), help(i + 1, j - 1, arr, dp));
        sum2 += Math.min(help(i + 1, j - 1, arr, dp), help(i, j - 2, arr, dp));
        return dp[i][j] = Math.max(sum1, sum2);
    }
}
