//Leetcode
//1749. Maximum Absolute Sum of Any Subarray : Greedy - Prefix Sum - Shorter
//Time complexity: O(N)
//Space complexity: O(1) 

package Leetcode;

public class MaximumAbsoluteSumOfAnySubarray_2 {

    public static void main(String[] args) {
        int[] nums = { 1, -3, 2, 3, -4 };
        System.out.println(maxAbsoluteSum(nums));
    }

    public static int maxAbsoluteSum(int[] nums) {
        int minPrefixSum = 0, maxPrefixSum = 0;
        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            minPrefixSum = Math.min(minPrefixSum, prefixSum);
            maxPrefixSum = Math.max(maxPrefixSum, prefixSum);
        }
        return maxPrefixSum - minPrefixSum;
    }
}
