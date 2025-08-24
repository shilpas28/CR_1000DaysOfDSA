//Leetcode
//1493. Longest Subarray of 1's After Deleting One Element - Sliding window that size doesn't shrink
//Time complexity: O(N)
//Space complexity: O(1) 

package Leetcode;

public class LongestSubarrayOf1sAfterDeletingOneElement_2 {

    public static void main(String[] args) {
        int[] nums = { 0, 1, 1, 1, 0, 1, 1, 0, 1 };
        System.out.println(longestSubarray(nums));
    }

    public static int longestSubarray(int[] nums) {
        int i = 0, j, k = 1;
        for (j = 0; j < nums.length; ++j) {
            if (nums[j] == 0)
                k--;
            if (k < 0 && nums[i++] == 0)
                k++;
        }
        return j - i - 1;
    }
}
