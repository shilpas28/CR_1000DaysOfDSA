//Leetcode
//3381. Maximum Subarray Sum With Length Divisible by K
//Time complexity: O(n)
//Space complexity: O(k) 

public class MaximumSubarraySumWithLengthDivisibleByK {

    public static void main(String[] args) {
        int[] nums = {1, 2};
        int k = 1;
        System.out.println(maxSubarraySum(nums, k));
    }

    public static long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long prefixSum = 0;
        long maxSum = Long.MIN_VALUE;
        long[] kSum = new long[k];
        for (int i = 0; i < k; i++) {
            kSum[i] = Long.MAX_VALUE / 2;
        }
        
        kSum[k - 1] = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            maxSum = Math.max(maxSum, prefixSum - kSum[i % k]);
            kSum[i % k] = Math.min(kSum[i % k], prefixSum);
        }
        return maxSum;
    }
}
