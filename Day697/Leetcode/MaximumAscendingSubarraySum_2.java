//Leetcode
//1800. Maximum Ascending Subarray Sum - Linear Scan  
//Time complexity: O(N)
//Space complexity: O(1)

public class MaximumAscendingSubarraySum_2 {

    public static void main(String[] args) {
        int[] nums = { 10, 20, 30, 5, 10, 50 };
        System.out.println(maxAscendingSum(nums));
    }

    public static int maxAscendingSum(int[] nums) {
        int maxSum = 0;
        int currentSubarraySum = nums[0];
        // Loop through the array starting from the second element
        for (int currentIdx = 1; currentIdx < nums.length; ++currentIdx) {
            if (nums[currentIdx] <= nums[currentIdx - 1]) {
                // If the current element is not greater than the previous one,
                // update maxSum
                maxSum = Math.max(maxSum, currentSubarraySum);
                // Reset the sum for the next ascending subarray
                currentSubarraySum = 0;
            }
            currentSubarraySum += nums[currentIdx];
        }
        // Final check after the loop ends to account for the last ascending
        // subarray
        return Math.max(maxSum, currentSubarraySum);
    }
}
