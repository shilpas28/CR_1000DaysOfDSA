//Leetcode
//1493. Longest Subarray of 1's After Deleting One Element
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class LongestSubarrayOf1sAfterDeletingOneElement {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 0, 1 };
        System.out.println(longestSubarray(nums));
    }

    public static int longestSubarray(int[] nums) {
        int cnt = 0, max = 0;
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] == 0) {
                cnt++;
            }
            while (left < right && cnt > 1) {
                if (nums[left] == 0) {
                    cnt--;
                }
                left++;
            }
            if (cnt <= 1) {
                max = Math.max(max, right - left + 1);
            }
        }
        return max - 1;
    }
}
