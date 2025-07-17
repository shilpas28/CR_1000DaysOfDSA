//Leetcode
//3202. Find the Maximum Length of Valid Subsequence II - Dynamic Programming
//Time complexity: O(k^2 + (n*k))
//Space complexity: O(k^2)

package Leetcode;

public class FindTheMaximumLengthOfValidSubsequenceII {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        int k = 2;
        System.out.println(maximumLength(nums, k));
    }

    public static int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int res = 0;
        for (int num : nums) {
            num %= k;
            for (int prev = 0; prev < k; prev++) {
                dp[prev][num] = dp[num][prev] + 1;
                res = Math.max(res, dp[prev][num]);
            }
        }
        return res;
    }
}
