//Leetcode - Brute Force
//3264. Final Array State After K Multiplication Operations I - K Full Array Scans for Minimum Element Multiplication
//Time complexity: O(N*k)
//Space complexity: O(1)

import java.util.Arrays;

public class FinalArrayStateAfterKMultiplicationOperationsI {

    public static void main(String[] args) {
        int nums[] = { 2, 1, 3, 5, 6 };
        int k = 5, multiplier = 2;
        System.out.println(Arrays.toString(getFinalState(nums, k, multiplier)));
    }

    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        for (int j = 0; j < k; j++) {
            // Find the index of the smallest element in the array
            int minIndex = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] < nums[minIndex]) {
                    minIndex = i;
                }
            }
            // Multiply the smallest element by the multiplier
            nums[minIndex] *= multiplier;
        }
        return nums;
    }
}
