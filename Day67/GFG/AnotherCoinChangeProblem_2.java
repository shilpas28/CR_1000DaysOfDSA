//GFG
//Another Coin Change Problem - using Tabulation
//Time complexity: O(n*k*target)
//Space complexity: O(k*target)

package GFG;

public class AnotherCoinChangeProblem_2 {
    public static void main(String[] args) {
        int n = 5, k = 3, target = 11;
        int[] coins = { 1, 10, 5, 8, 6 };
        System.out.println(makeChanges(n, k, target, coins));
    }

    public static boolean makeChanges(int N, int K, int target, int[] coins) {
        // code here
        boolean[][] dp = new boolean[K + 1][target + 1];
        dp[0][0] = true;
        for (int i = 1; i < K + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                for (int coin : coins) {
                    if (j < coin)
                        continue;
                    dp[i][j] |= dp[i - 1][j - coin];
                }
            }
        }
        return dp[K][target];
    }
}
