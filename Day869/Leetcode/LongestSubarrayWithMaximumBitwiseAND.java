//Leetcode
//2419. Longest Subarray With Maximum Bitwise AND - Two Pass
//Time complexity: O(N)
//Space complexity: O(1) 

public class LongestSubarrayWithMaximumBitwiseAND {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 3, 2, 2 };
        System.out.println(longestSubarray(nums));
    }

    public static int longestSubarray(int[] nums) {
        int max = 0, longest = 1, cur = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        for (int num : nums) {
            if (num == max) {
                longest = Math.max(longest, ++cur);
            } else {
                cur = 0;
            }
        }
        return longest;
    }
}
