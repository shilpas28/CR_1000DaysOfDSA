//GFG
//Coin Change (Count Ways) - Tabulation
//Time complexity: O(N*T)
//Space complexity: O(N*T) 

public class CoinChange_2 {

    public static void main(String[] args) {
        int coins[] = { 2, 5, 3, 6 };
        int sum = 10;
        System.out.println(count(coins, sum));
    }

    public static int count(int coins[], int sum) {
        // code here.
        int N = coins.length;
        int dp[][] = new int[N][sum + 1];
        // Initializing base condition
        for (int i = 0; i <= sum; i++) {
            if (i % coins[0] == 0)
                dp[0][i] = 1;
            // Else condition is automatically fulfilled,
            // as dp array is initialized to zero
        }
        for (int ind = 1; ind < N; ind++) {
            for (int target = 0; target <= sum; target++) {
                int notTaken = dp[ind - 1][target];
                int taken = 0;
                if (coins[ind] <= target)
                    taken = dp[ind][target - coins[ind]];
                dp[ind][target] = notTaken + taken;
            }
        }
        return dp[N - 1][sum];
    }
}
