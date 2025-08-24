//Leetcode
//1493. Longest Subarray of 1's After Deleting One Element - Sliding window with at most one 0 inside
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class LongestSubarrayOf1sAfterDeletingOneElement {

    public static void main(String[] args) {
        int[] nums = { 0, 1, 1, 1, 0, 1, 1, 0, 1 };
        System.out.println(longestSubarray(nums));
    }

    public static int longestSubarray(int[] nums) {
        int i = 0, j, k = 1, res = 0;
        for (j = 0; j < nums.length; ++j) {
            if (nums[j] == 0) {
                k--;
            }
            while (k < 0) {
                if (nums[i] == 0) {
                    k++;
                }
                i++;
            }
            res = Math.max(res, j - i);
        }
        return res;
    }
}
