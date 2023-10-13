//Leetcode 
//746. Min Cost Climbing Stairs - Space Optimization
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class MinCostClimbingStairs_4 {

    public static void main(String[] args) {
        int[] cost = { 10, 15, 20 };
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int first = cost[0];
        int second = cost[1];
        if (n <= 2)
            return Math.min(first, second);
        for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(first, second);
            first = second;
            second = curr;
        }
        return Math.min(first, second);
    }
}
