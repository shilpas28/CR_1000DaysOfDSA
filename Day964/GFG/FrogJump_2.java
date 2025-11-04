//GFG
//Frog Jump - Tabulation
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.Arrays;

public class FrogJump_2 {

    public static void main(String[] args) {
        int heights[] = { 20, 30, 40, 20 };
        System.out.println(minCost(heights));
    }

    static int minCost(int[] height) {
        // code here
        int n = height.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int ind = 1; ind < n; ind++) {
            int jumpTwo = Integer.MAX_VALUE;
            int jumpOne = dp[ind - 1] + Math.abs(height[ind] - height[ind - 1]);
            if (ind > 1)
                jumpTwo = dp[ind - 2] + Math.abs(height[ind] - height[ind - 2]);

            dp[ind] = Math.min(jumpOne, jumpTwo);
        }
        return dp[n - 1];
    }
}
