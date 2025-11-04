//GFG
//Frog Jump - Memoization
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.Arrays;

public class FrogJump {

    public static void main(String[] args) {
        int heights[] = { 20, 30, 40, 20 };
        System.out.println(minCost(heights));
    }

    static int minCost(int[] height) {
        // code here
        int n = height.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return solve(n - 1, height, dp);
    }

    static int solve(int ind, int[] height, int[] dp) {
        if (ind == 0)
            return 0;
        if (dp[ind] != -1)
            return dp[ind];
        int jumpTwo = Integer.MAX_VALUE;
        int jumpOne = solve(ind - 1, height, dp) + Math.abs(height[ind] - height[ind - 1]);
        if (ind > 1)
            jumpTwo = solve(ind - 2, height, dp) + Math.abs(height[ind] - height[ind - 2]);

        return dp[ind] = Math.min(jumpOne, jumpTwo);
    }
}
