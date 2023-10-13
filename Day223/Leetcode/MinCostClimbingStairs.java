//Leetcode - Not accepted as TLE
//746. Min Cost Climbing Stairs - Recursive method
//Time complexity: O(2^N)
//Space complexity: O(N^2)

package Leetcode;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] cost = { 10, 15, 20 };
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        return Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
    }

    static int minCost(int[] cost, int n) {
        if (n < 0)
            return 0;
        if (n == 0 || n == 1)
            return cost[n];
        return cost[n] + Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
    }
}
