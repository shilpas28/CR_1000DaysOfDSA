//GFG - Code not accepted as TLE 
//Wall Coloring II - using Memoization
//Time complexity: O((N*K)*K)
//Space complexity:
package GFG;

public class WallColoring2_2 {

    public static void main(String[] args) {
        // int N = 4, K = 3;
        int[][] costs = { { 1, 5, 7 }, { 5, 8, 4 }, { 3, 2, 9 }, { 1, 2, 4 } };
        System.out.println(minCost(costs));
    }

    static Integer[][] dp;

    public static int minCost(int[][] costs) {
        dp = new Integer[costs.length + 1][costs[0].length + 1];
        int ans = solve(0, costs, -1);
        if (ans >= Integer.MAX_VALUE / 2)
            return -1;
        return ans;
    }

    static int solve(int cur, int[][] costs, int prev) {
        if (cur == costs.length)
            return 0;
        if (prev != -1 && dp[cur][prev] != null)
            return dp[cur][prev];
        int min = Integer.MAX_VALUE / 2;

        for (int i = 0; i < costs[0].length; i++) {
            if (prev == -1) {
                min = Math.min(min, costs[cur][i] + solve(cur + 1, costs, i));
            } else if (i != prev) {
                int val = dp[cur + 1][i] != null ? dp[cur + 1][i] : solve(cur + 1, costs, i);
                min = Math.min(min, costs[cur][i] + val);
            }
        }

        if (prev != -1)
            dp[cur][prev] = min;
        return min;
    }

}
