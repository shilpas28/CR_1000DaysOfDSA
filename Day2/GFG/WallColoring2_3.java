//GFG
//Wall Coloring II - using Tabulation
//Time complexity: O(N*K)
//Space complexity:
package GFG;

public class WallColoring2_3 {

    public static void main(String[] args) {
        // int N = 4, K = 3;
        int[][] costs = { { 1, 5, 7 }, { 5, 8, 4 }, { 3, 2, 9 }, { 1, 2, 4 } };
        System.out.println(minCost(costs));
    }

    public static int minCost(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;

        int[][] dp = new int[k][n];
        int min = Integer.MAX_VALUE, smin = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            dp[i][0] = costs[0][i];

            if (costs[0][i] < min) {
                smin = min;
                min = costs[0][i];
            } else if (costs[0][i] < smin)
                smin = costs[0][i];
        }

        int cmin, csmin;

        for (int i = 1; i < n; i++) {
            cmin = Integer.MAX_VALUE;
            csmin = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                if (dp[j][i - 1] == min)
                    dp[j][i] = costs[i][j] + smin;
                else
                    dp[j][i] = costs[i][j] + min;

                if (dp[j][i] < cmin) {
                    csmin = cmin;
                    cmin = dp[j][i];
                } else if (dp[j][i] < csmin) {
                    csmin = dp[j][i];
                }
            }
            min = cmin;
            smin = csmin;
        }
        return min == Integer.MIN_VALUE ? -1 : min;
    }
}
