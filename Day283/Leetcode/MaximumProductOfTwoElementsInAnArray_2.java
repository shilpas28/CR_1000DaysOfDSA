//Leetcode
//1464. Maximum Product of Two Elements in an Array - Sorting
//Time complexity: O(nlogn)
//Space complexity: O(logn) or O(n)

package Leetcode;

import java.util.Arrays;

public class MaximumProductOfTwoElementsInAnArray_2 {

    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 2 };
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int x = nums[nums.length - 1];
        int y = nums[nums.length - 2];
        return (x - 1) * (y - 1);
    }
}
