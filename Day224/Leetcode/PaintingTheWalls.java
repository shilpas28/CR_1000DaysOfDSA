//Leetcode
//2742. Painting the Walls
//Time complexity: O(N^2)
//Space complexity: O(N)

package Leetcode;

import java.util.Arrays;

public class PaintingTheWalls {

    public static void main(String[] args) {
        int[] cost = { 1, 2, 3, 2 };
        int[] time = { 1, 2, 3, 2 };
        System.out.println(paintWalls(cost, time));
    }

    public static int paintWalls(int[] cost, int[] time) {
        int n = cost.length, dp[] = new int[n + 1];
        Arrays.fill(dp, (int) 1e9);
        dp[0] = 0;
        for (int i = 0; i < n; ++i)
            for (int j = n; j > 0; --j)
                dp[j] = Math.min(dp[j], dp[Math.max(j - time[i] - 1, 0)] + cost[i]);
        return dp[n];
    }
}
