//GFG
//Min Cost Climbing Stairs
//Time complexity: O(N)
//Space complexity: O(N)

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int cost[] = { 10, 15, 20 };
        System.out.println(minCostClimbingStairs(cost));
    }

    static int minCostClimbingStairs(int[] cost) {
        // Write your code here
        int n = cost.length;
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int onestep = cost[i] + dp[i + 1];
            int twostep = Integer.MAX_VALUE;
            if (i + 2 <= n)
                twostep = cost[i] + dp[i + 2];
            dp[i] = Math.min(onestep, twostep);
        }
        return Math.min(dp[0], dp[1]);
    }
}
