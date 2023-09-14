//GFG 
//Perfect Sum Problem - using Memoization/Top down
//Time complexity: O(N^2)
//Space complexity: O(N^2) + O(N)

package GFG;

import java.util.Arrays;

public class PerfectSumProblem_2 {

    public static void main(String[] args) {
        int N = 6;
        int arr[] = { 2, 3, 5, 6, 8, 10 };
        int sum = 10;
        System.out.println(perfectSum(arr, N, sum));
    }

    static int mod = 1000000007;

    public static int perfectSum(int arr[], int n, int sum) {
        // Your code goes here
        int dp[][] = new int[n][sum + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        return fun(0, sum, arr, n, dp);
    }

    static int fun(int pos, int sum, int arr[], int n, int[][] dp) {
        if (sum < 0)
            return 0;
        if (pos == n)
            return sum == 0 ? 1 : 0;

        if (dp[pos][sum] != -1)
            return dp[pos][sum];

        dp[pos][sum] = (fun(pos + 1, sum, arr, n, dp) % mod + fun(pos + 1, sum - arr[pos], arr, n, dp) % mod) % mod;
        return dp[pos][sum];
    }
}
