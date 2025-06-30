//Leetcode
//594. Longest Harmonious Subsequence - Sorting
//Time complexity: O(nlogn)
//Space complexity: O(1)

import java.util.Arrays;

public class LongestHarmoniousSubsequence {

    public static void main(String[] args) {
        int[] nums = { 1, 3, 2, 2, 5, 2, 3, 7 };
        System.out.println(findLHS(nums));
    }

    public static int findLHS(int[] nums) {
        Arrays.sort(nums);
        int j = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - nums[j] > 1) {
                j++;
            }
            if (nums[i] - nums[j] == 1) {
                maxLength = Math.max(maxLength, i - j + 1);
            }
        }
        return maxLength;
    }
}
