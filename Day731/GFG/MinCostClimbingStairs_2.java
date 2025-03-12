//GFG
//Min Cost Climbing Stairs
//Time complexity: O(N)
//Space complexity: O(N)

public class MinCostClimbingStairs_2 {

    public static void main(String[] args) {
        int cost[] = { 10, 15, 20 };
        System.out.println(minCostClimbingStairs(cost));
    }

    static int minCostClimbingStairs(int[] cost) {
        // Write your code here
        int n = cost.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        int ans = Math.min(solve(0, cost, dp), solve(1, cost, dp));
        return ans;
    }

    static int solve(int ind, int[] cost, int[] dp) {
        if (ind >= cost.length) {
            return 0;
        }
        if (dp[ind] != -1) {
            return dp[ind];
        }
        int op1 = cost[ind] + solve(ind + 1, cost, dp);
        int op2 = cost[ind] + solve(ind + 2, cost, dp);
        return dp[ind] = Math.min(op1, op2);
    }
}
