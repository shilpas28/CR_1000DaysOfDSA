//Leetcode
//1458. Max Dot Product of Two Subsequences - Tabulation/Bottom up
//Time complexity: O(n∗m) where n is the length of the nums1 list and m is the length of the nums2 list.
//Space complexity:O(n∗m) where n is the length of the nums1 list and m is the length of the nums2 list.

package Leetcode;

public class MaxDotProductOfTwoSubsequences_2 {

    public static void main(String[] args) {
        int[] nums1 = { 2, 1, -2, 5 };
        int[] nums2 = { 3, 0, -6 };
        System.out.println(maxDotProduct(nums1, nums2));
    }

    public static int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = Integer.MIN_VALUE;
                } else {
                    dp[i][j] = Math.max(
                            nums1[i - 1] * nums2[j - 1] + Math.max(dp[i - 1][j - 1], 0),
                            Math.max(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        return dp[n][m];
    }
}
