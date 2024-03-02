//Leetcode
//977. Squares of a Sorted Array - Sort Function
//Time complexity: O(nlogn)
//Space complexity: O(1)

package Leetcode;

import java.util.Arrays;

public class SquaresOfASortedArray_2 {

    public static void main(String[] args) {
        int[] nums = { -4, -1, 0, 3, 10 };
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    public static int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
