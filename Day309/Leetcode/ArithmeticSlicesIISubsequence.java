//Leetcode
//446. Arithmetic Slices II - Subsequence
//Time complexity: O(n^2) - The nested loops iterate through each pair of indices, leading to a quadratic time complexity.
//Space complexity: O(n^2) - The 2D array dp has dimensions n x n, contributing to a quadratic space complexity.

package Leetcode;

import java.util.HashMap;

public class ArithmeticSlicesIISubsequence {

    public static void main(String[] args) {
        int[] nums = { 2, 4, 6, 8, 10 };
        System.out.println(numberOfArithmeticSlices(nums));
    }

    @SuppressWarnings("all")
    public static int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int total_count = 0;

        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = new HashMap<>();
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                long diff = (long) nums[i] - nums[j];

                if (diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE) {
                    continue;
                }
                int diffInt = (int) diff;
                dp[i].put(diffInt, dp[i].getOrDefault(diffInt, 0) + 1);
                if (dp[j].containsKey(diffInt)) {
                    dp[i].put(diffInt, dp[i].get(diffInt) + dp[j].get(diffInt));
                    total_count += dp[j].get(diffInt);
                }
            }
        }
        return total_count;
    }
}
