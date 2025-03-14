//GFG
//Coin Change (Count Ways) - Memoization
//Time complexity: O(N*T)
//Space complexity: O(N*T) + O(N)

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int coins[] = { 2, 5, 3, 6 };
        int sum = 10;
        System.out.println(count(coins, sum));
    }

    public static int count(int coins[], int sum) {
        // code here.
        int N = coins.length;
        int dp[][] = new int[N][sum + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return countWaysToMakeChangeUtil(coins, N - 1, sum, dp);
    }

    static int countWaysToMakeChangeUtil(int[] arr, int ind, int T, int[][] dp) {

        if (ind == 0) {
            if (T % arr[0] == 0)
                return 1;
            else
                return 0;
        }
        if (dp[ind][T] != -1)
            return dp[ind][T];
        int notTaken = countWaysToMakeChangeUtil(arr, ind - 1, T, dp);
        int taken = 0;
        if (arr[ind] <= T)
            taken = countWaysToMakeChangeUtil(arr, ind, T - arr[ind], dp);
        return dp[ind][T] = notTaken + taken;
    }
}
