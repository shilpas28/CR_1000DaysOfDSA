//Leetcode
//486. Predict the Winner
//Time complexity: O(N^2)
//Space complexity: O(N)

package Leetcode;

import java.util.Arrays;

public class PredictTheWinner {

    public static void main(String[] args) {
        int nums[] = { 1, 5, 2 };
        System.out.println(predictTheWinner(nums));
    }

    static int[][] dp;

    public static boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        dp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], -1);
        }
        return score(nums, 0, n - 1) >= 0;
    }

    public static int score(int[] nums, int l, int r) {
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        if (l == r) {
            return nums[l];
        }
        int left = nums[l] - score(nums, l + 1, r);
        int right = nums[r] - score(nums, l, r - 1);
        dp[l][r] = Math.max(left, right);
        return dp[l][r];
    }
}
