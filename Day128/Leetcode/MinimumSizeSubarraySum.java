//Leetcode
//209. Minimum Size Subarray Sum
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        int target = 7;
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int currSum = 0, window = Integer.MAX_VALUE;
        int start = 0, end = 0;
        for (end = 0; end < nums.length; end++) {
            currSum += nums[end];
            while (currSum >= target) {
                window = Math.min(window, end - start + 1);
                currSum -= nums[start];
                start++;
            }
        }
        return window == Integer.MAX_VALUE ? 0 : window;
    }
}
