//Leetcode 
//746. Min Cost Climbing Stairs - Memoization/Top down
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

public class MinCostClimbingStairs_2 {

    public static void main(String[] args) {
        int[] cost = { 10, 15, 20 };
        System.out.println(minCostClimbingStairs(cost));
    }

    static int[] dp;

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n];
        return Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
    }

    static int minCost(int[] cost, int n) {
        if (n < 0)
            return 0;
        if (n == 0 || n == 1)
            return cost[n];
        if (dp[n] != 0)
            return dp[n];
        dp[n] = cost[n] + Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
        return dp[n];
    }
}
