//Leetcode
//2419. Longest Subarray With Maximum Bitwise AND - One Pass
//Time complexity: O(N)
//Space complexity: O(1) 

public class LongestSubarrayWithMaximumBitwiseAND_2 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 3, 2, 2 };
        System.out.println(longestSubarray(nums));
    }

    public static int longestSubarray(int[] nums) {
        int max = 0, longest = 0, cur = 0;
        for (int num : nums) {
            if (num == max) {
                longest = Math.max(longest, ++cur);
            } else if (num > max) {
                max = num;
                cur = longest = 1;
            } else {
                cur = 0;
            }
        }
        return longest;
    }
}
