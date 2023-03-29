//Leetcode - using Tabulation
//1402. Reducing Dishes
//Time complexity: O(N^2)
//Space complexity: O(N^2)

import java.util.Arrays;

public class ReducingDishes_2 {

    public static void main(String[] args) {
        int[] satisfaction = { -1, -8, 0, 5, -9 };
        System.out.println(maxSatisfaction(satisfaction));
    }

    public static int maxSatisfaction(int[] satisfaction) {
        // sort
        Arrays.sort(satisfaction);
        return solve(satisfaction);
    }

    static int solve(int[] satisfaction) {
        // base case
        int n = satisfaction.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = 0;
            }
        }

        for (int index = n - 1; index >= 0; index--) {
            for (int time = index; time >= 0; time--) {

                int include = satisfaction[index] * (time + 1) + dp[index + 1][time + 1];
                int exclude = 0 + dp[index + 1][time];

                dp[index][time] = Math.max(include, exclude);
            }
        }
        return dp[0][0];
    }
}
