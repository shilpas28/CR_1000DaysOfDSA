//Leetcode
//1458. Max Dot Product of Two Subsequences - Memoization/Top down
//Time complexity: O(n∗m) where n is the length of the nums1 list and m is the length of the nums2 list.
//Space complexity:O(n∗m) where n is the length of the nums1 list and m is the length of the nums2 list.

package Leetcode;

public class MaxDotProductOfTwoSubsequences {

    public static void main(String[] args) {
        int[] nums1 = { 2, 1, -2, 5 };
        int[] nums2 = { 3, 0, -6 };
        System.out.println(maxDotProduct(nums1, nums2));
    }

    public static int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] memo = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                memo[i][j] = Integer.MIN_VALUE;
            }
        }
        return dp(nums1, nums2, 0, 0, memo);
    }

    static int dp(int[] nums1, int[] nums2, int i, int j, int[][] memo) {
        int n = nums1.length;
        int m = nums2.length;

        if (i == n || j == m) {
            return Integer.MIN_VALUE;
        }
        if (memo[i][j] != Integer.MIN_VALUE) {
            return memo[i][j];
        }
        memo[i][j] = Math.max(
                nums1[i] * nums2[j] + Math.max(dp(nums1, nums2, i + 1, j + 1, memo), 0),
                Math.max(dp(nums1, nums2, i + 1, j, memo), dp(nums1, nums2, i, j + 1, memo)));

        return memo[i][j];
    }
}
