//Leetcode - not accepted as TLE
//1425. Constrained Subsequence Sum - DP Straight forward (Brute force))
//Time complexity: O(N*K)
//Space complexity: O(N)

package Leetcode;

public class ConstrainedSubsequenceSum {

    public static void main(String[] args) {
        int[] nums = { 10, 2, -10, 5, 20 };
        int k = 2;
        System.out.println(constrainedSubsetSum(nums, k));
    }

    public static int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = Math.max(i - k, 0); j < i; j++) { // choose the max element in latest k elements, it's in range
                                                           // [i-k, i-1]
                max = Math.max(max, dp[j]);
            }
            dp[i] = nums[i] + max;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
