//Leetcode 
//746. Min Cost Climbing Stairs - Tabulation/Bottom up
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

public class MinCostClimbingStairs_3 {

    public static void main(String[] args) {
        int[] cost = { 10, 15, 20 };
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < 2)
                dp[i] = cost[i];
            else
                dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
