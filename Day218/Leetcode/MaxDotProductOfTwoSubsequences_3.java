//Leetcode
//1458. Max Dot Product of Two Subsequences - Space optimization - Not acceptes as some case is giving wrong answer.
//Time complexity: O(m∗n) where m is the length of nums1, and n is the length of nums2.
//Space complexity: O(m∗n) where m is the length of nums1, and n is the length of nums2.

package Leetcode;

public class MaxDotProductOfTwoSubsequences_3 {

    public static void main(String[] args) {
        int[] nums1 = { 2, 1, -2, 5 };
        int[] nums2 = { 3, 0, -6 };
        System.out.println(maxDotProduct(nums1, nums2));
    }

    public static int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(
                        dp[i - 1][j - 1] + nums1[i - 1] * nums2[j - 1],
                        Math.max(dp[i - 1][j], dp[i][j - 1]));
                dp[i][j] = Math.max(dp[i][j], nums1[i - 1] * nums2[j - 1]);
            }
        }

        return dp[m][n];
    }
}
