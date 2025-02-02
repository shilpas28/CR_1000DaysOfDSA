//Leetcode
//1752. Check if Array Is Sorted and Rotated - Compare with sorted array
//Time complexity: O(N^2)
//Space complexity: O(N)

import java.util.Arrays;

public class CheckIfArrayIsSortedAndRotated_2 {

    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 1, 2 };
        System.out.println(check(nums));
    }

    public static boolean check(int[] nums) {
        int size = nums.length;
        // Create a sorted copy of the array
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        // Compare the original array with the sorted array, considering all possible
        // rotations
        for (int rotationOffset = 0; rotationOffset < size; ++rotationOffset) {
            boolean isMatch = true;
            for (int index = 0; index < size; ++index) {
                if (nums[(rotationOffset + index) % size] != sortedNums[index]) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                return true;
            }
        }
        return false;
    }
}
