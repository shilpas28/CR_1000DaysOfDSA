//Leetcode
//2441. Largest Positive Integer That Exists With Its Negative - Brute Force
//Time complexity: O(N^2)
//Space complexity: O(1) 

package Leetcode;

import java.util.Arrays;

public class LargestPositiveIntegerThatExistsWithItsNegative {

    public static void main(String[] args) {
        int[] nums = { -1, 10, 6, 7, -7, 1 };
        System.out.println(findMaxK(nums));
    }

    public static int findMaxK(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j >= 0; j--) {
                if (nums[i] + nums[j] == 0)
                    return nums[j];
            }
        }
        return -1;
    }
}
