//GFG
//Another Coin Change Problem - using Memoization
//Time complexity: O(n*k*target)
//Space complexity: O(k*target)

package GFG;

public class AnotherCoinChangeProblem {

    public static void main(String[] args) {
        int n = 5, k = 3, target = 11;
        int[] coins = { 1, 10, 5, 8, 6 };
        System.out.println(makeChanges(n, k, target, coins));
    }

    public static boolean makeChanges(int N, int K, int target, int[] coins) {
        // code here
        Boolean[][] dp = new Boolean[K + 1][target + 1];
        return solve(N, K, target, coins, dp);
    }

    public static boolean solve(int N, int K, int target, int[] coins, Boolean[][] dp) {
        if (K == 0 && target == 0)
            return true;
        if (K <= 0 || target <= 0)
            return false;
        if (dp[K][target] != null)
            return dp[K][target];
        boolean ans = false;
        for (int i = 0; i < N; i++) {
            if (target >= coins[i] && K - 1 >= 0)
                ans |= solve(N, K - 1, target - coins[i], coins, dp);
        }
        dp[K][target] = ans;
        return ans;
    }
}
