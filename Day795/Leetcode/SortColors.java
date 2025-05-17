//Leetcode
//75. Sort Colors - Using bubble sort - stable sorting algorithm
//Time complexity: O(N^2)
//Space complexity: O(1)

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {
        int[] nums = { 2, 0, 2, 1, 1, 0 };
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int len = nums.length;
        int temp = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
