//GFG
//New Year Resolution
//Time complexity: O(N*(Sum of coins))
//Space complexity: O(N*(Sum of coins))

package GFG;

import java.util.Arrays;

public class NewYearResolution_2 {

    public static void main(String[] args) {
        int N = 8;
        int[] coins = { 5, 8, 9, 10, 14, 2, 3, 5 };
        System.out.println(isPossible(N, coins));
    }

    public static boolean isPossible(int N, int[] coins) {
        // code here
        int[][] dp = new int[N][2025];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(coins, 0, N, 0, dp) == 1;
    }

    public static int helper(int[] coins, int i, int N, int sum, int[][] dp) {
        if (i == N) {
            if (sum != 0 && (sum % 20 == 0 || sum % 24 == 0 || sum == 2024)) {
                return 1;
            }
            return 0;
        }
        if (sum != 0 && (sum % 20 == 0 || sum % 24 == 0 || sum == 2024)) {
            return 1;
        }
        if (dp[i][sum] != -1) {
            return dp[i][sum];
        }
        int take = helper(coins, i + 1, N, sum + coins[i], dp);
        int notTake = helper(coins, i + 1, N, sum, dp);
        return dp[i][sum] = take | notTake;
    }
}
