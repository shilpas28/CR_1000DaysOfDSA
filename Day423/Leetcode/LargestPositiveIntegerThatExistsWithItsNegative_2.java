//Leetcode
//2441. Largest Positive Integer That Exists With Its Negative - Sorting
//Time complexity: O(nlogn)
//Space complexity: O(1)

package Leetcode;

import java.util.Arrays;

public class LargestPositiveIntegerThatExistsWithItsNegative_2 {

    public static void main(String[] args) {
        int[] nums = { -1, 10, 6, 7, -7, 1 };
        System.out.println(findMaxK(nums));
    }

    public static int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > 0 && Arrays.binarySearch(nums, -nums[i]) >= 0) {
                return nums[i];
            }
        }
        return -1; // If no such pair found
    }
}
