//Leetcode - Also accepted with simpler logic
//905. Sort Array By Parity
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

import java.util.Arrays;

public class SortArrayByParity_2 {

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2, 4 };
        System.out.println(Arrays.toString(sortArrayByParity(nums)));
    }

    public static int[] sortArrayByParity(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                swap(nums, i, j);
                j++;
            }
        }
        return nums;
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
