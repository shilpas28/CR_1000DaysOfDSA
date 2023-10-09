//Leetcode
//34. Find First and Last Position of Element in Sorted Array - Brute force method
//Time complexity: O(N), N = size of the given array
//Reason: We are traversing the entire array.
//Space complexity: O(1) as we are not using any extra space.

package Leetcode;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int first = -1, last = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                if (first == -1)
                    first = i;
                last = i;
            }
        }
        return new int[] { first, last };
    }
}
