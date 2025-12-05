//GFG
//Walls Coloring II - Not accepted as TLE
//Time complexity: O(n*k)
//Space complexity: O(1) 

public class WallsColoringII {

    public static void main(String[] args) {
        // int n = 4, k = 3;
        int costs[][] = {{1, 5, 7},
        {5, 8, 4},
        {3, 2, 9},
        {1, 2, 4}};
        System.out.println(minCost(costs));
    }

    static Integer[][] dp;

    static int minCost(int[][] costs) {
        // code here
        dp = new Integer[costs.length + 1][costs[0].length + 1];
        int ans = solve(0, costs, -1);
        if (ans >= Integer.MAX_VALUE / 2) {
            return -1;
        }
        return ans;
    }

    static int solve(int cur, int[][] costs, int prev) {
        if (cur == costs.length) {
            return 0;
        }
        if (prev != -1 && dp[cur][prev] != null) {
            return dp[cur][prev];
        }
        int min = Integer.MAX_VALUE / 2;

        for (int i = 0; i < costs[0].length; i++) {
            if (prev == -1) {
                min = Math.min(min, costs[cur][i] + solve(cur + 1, costs, i));
            } else if (i != prev) {
                int val = dp[cur + 1][i] != null ? dp[cur + 1][i] : solve(cur + 1, costs, i);
                min = Math.min(min, costs[cur][i] + val);
            }
        }

        if (prev != -1) {
            dp[cur][prev] = min;
        }
        return min;
    }
}
