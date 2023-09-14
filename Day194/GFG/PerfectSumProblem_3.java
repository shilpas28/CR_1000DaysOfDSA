//GFG 
//Perfect Sum Problem - using Tabulation/Bottom up
//Time complexity: O(N^2) 
//Space complexity: O(N^2)

package GFG;

public class PerfectSumProblem_3 {

    public static void main(String[] args) {
        int N = 6;
        int arr[] = { 2, 3, 5, 6, 8, 10 };
        int sum = 10;
        System.out.println(perfectSum(arr, N, sum));
    }

    static int mod = 1000000007;

    public static int perfectSum(int arr[], int n, int sum) {
        // Your code goes here
        int dp[][] = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0)
                    dp[i][j] = (j == 0) ? 1 : 0;
                else if (j < arr[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - arr[i - 1]]) % mod;
            }
        }

        return dp[n][sum] % mod;
    }
}
