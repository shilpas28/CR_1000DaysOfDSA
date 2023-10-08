//Leetcode
//1458. Max Dot Product of Two Subsequences - Using longest common sequence method.
//Time complexity: O(MN)
//Space complexity: O(MN)

package Leetcode;

public class MaxDotProductOfTwoSubsequences_4 {

    public static void main(String[] args) {
        int[] nums1 = { 2, 1, -2, 5 };
        int[] nums2 = { 3, 0, -6 };
        System.out.println(maxDotProduct(nums1, nums2));
    }

    public static int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length, dp[][] = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                dp[i][j] = nums1[i] * nums2[j];
                if (i > 0 && j > 0)
                    dp[i][j] += Math.max(dp[i - 1][j - 1], 0);
                if (i > 0)
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                if (j > 0)
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
            }
        }
        return dp[n - 1][m - 1];
    }
}
