//Leetcode
//673. Number of Longest Increasing Subsequence
//Time complexity: O(N^2)
//Space complexity: O(N)

package Leetcode;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 4, 7 };
        System.out.println(findNumberOfLIS(nums));
    }

    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] ct = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(ct, 1);
        int maxi = 1;
        for (int i = 0; i <= n - 1; i++) {
            for (int prev_index = 0; prev_index <= i - 1; prev_index++) {
                if (nums[prev_index] < nums[i] && dp[prev_index] + 1 > dp[i]) {
                    dp[i] = dp[prev_index] + 1;
                    // inherit
                    ct[i] = ct[prev_index];
                } else if (nums[prev_index] < nums[i] && dp[prev_index] + 1 == dp[i]) {
                    // increase the count
                    ct[i] = ct[i] + ct[prev_index];
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        int nos = 0;
        for (int i = 0; i <= n - 1; i++) {
            if (dp[i] == maxi)
                nos += ct[i];
        }
        return nos;
    }
}
