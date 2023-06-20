//Leetcode
//2090. K Radius Subarray Averages - Using Prefix Sum
//Time complexity: O(N)
//Space complexity: O(N) 

package Leetcode;

import java.util.Arrays;

public class KRadiusSubarrayAverages {

    public static void main(String[] args) {
        int[] nums = { 7, 4, 3, 9, 1, 8, 5, 2, 6 };
        int k = 3;
        System.out.println(Arrays.toString(getAverages(nums, k)));
    }

    public static int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int windowSize = 2 * k + 1;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        if (n < windowSize) {
            return ans;
        }
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        for (int i = k; i + k < n; ++i) {
            ans[i] = (int) ((prefixSum[i + k + 1] - prefixSum[i - k]) / windowSize);
        }
        return ans;
    }
}
