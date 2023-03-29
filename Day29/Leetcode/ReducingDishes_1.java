//Leetcode - using Memoization
//1402. Reducing Dishes
//Time complexity: O(N^2)
//Space complexity: O(N^2)

import java.util.Arrays;

public class ReducingDishes_1 {

    public static void main(String[] args) {
        int[] satisfaction = { -1, -8, 0, 5, -9 };
        System.out.println(maxSatisfaction(satisfaction));
    }

    public static int maxSatisfaction(int[] satisfaction) {
        // sort
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(satisfaction, 0, 0, dp);
    }

    static int solve(int[] satisfaction, int index, int time, int[][] dp) {
        // base case
        if (index == satisfaction.length)
            return 0;
        if (dp[index][time] != -1)
            return dp[index][time];
        int include = satisfaction[index] * (time + 1) + solve(satisfaction, index + 1, time + 1, dp);
        int exclude = 0 + solve(satisfaction, index + 1, time, dp);
        dp[index][time] = Math.max(include, exclude);
        return dp[index][time];
    }
}
