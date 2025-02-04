//Leetcode
//1800. Maximum Ascending Subarray Sum - Brute Force
//Time complexity: O(N^2)
//Space complexity: O(1)

public class MaximumAscendingSubarraySum {

    public static void main(String[] args) {
        int[] nums = { 10, 20, 30, 5, 10, 50 };
        System.out.println(maxAscendingSum(nums));
    }

    public static int maxAscendingSum(int[] nums) {
        int maxSum = 0;
        // Outer loop to start from each element in the array
        for (int startIdx = 0; startIdx < nums.length; startIdx++) {
            int currentSubarraySum = nums[startIdx];
            // Inner loop to check the next elements forming an ascending subarray
            for (int endIdx = startIdx + 1; endIdx < nums.length && nums[endIdx] > nums[endIdx - 1]; endIdx++) {
                currentSubarraySum += nums[endIdx];
            }
            // Update maxSum if we find a larger ascending subarray sum
            maxSum = Math.max(maxSum, currentSubarraySum);
        }
        return maxSum;
    }
}
