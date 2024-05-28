//GFG
//Minimum cost to fill given weight in a bag
//Time complexity: O(n*w)
//Space complexity: O(n*w)

import java.util.Arrays;

public class MinimumCostToFillGivenWeightInABag {

    public static void main(String[] args) {
        int n = 5;
        int cost[] = { 20, 10, 4, 50, 100 };
        int w = 5;
        System.out.println(minimumCost(n, w, cost));
    }

    public static int minimumCost(int n, int w, int[] cost) {
        // code here
        int dp[] = new int[w + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            if (cost[i] != -1) {
                for (int j = i + 1; j <= w; j++) {
                    dp[j] = Math.min(dp[j], cost[i] + dp[j - i - 1]);
                }
            }
        }
        return dp[w] != Integer.MAX_VALUE ? dp[w] : -1;
    }
}
