//GFG
//Coin Change - Tabulation
//Time complexity: O(N*T)
//Space complexity: O(N*T) 

package GFG;

public class CoinChange_2 {

    public static void main(String[] args) {
        int N = 3, sum = 4;
        int[] coins = { 1, 2, 3 };
        System.out.println(count(coins, N, sum));
    }

    public static long count(int coins[], int N, int sum) {
        // code here.
        long dp[][] = new long[N][sum + 1];
        // Initializing base condition
        for (int i = 0; i <= sum; i++) {
            if (i % coins[0] == 0)
                dp[0][i] = 1;
            // Else condition is automatically fulfilled,
            // as dp array is initialized to zero
        }
        for (int ind = 1; ind < N; ind++) {
            for (int target = 0; target <= sum; target++) {
                long notTaken = dp[ind - 1][target];
                long taken = 0;
                if (coins[ind] <= target)
                    taken = dp[ind][target - coins[ind]];
                dp[ind][target] = notTaken + taken;
            }
        }
        return dp[N - 1][sum];
    }
}
