//Leetcode
//1685. Sum of Absolute Differences in a Sorted Array - Optimal Method
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

import java.util.Arrays;

public class SumOfAbsoluteDifferencesInASortedArray_3 {

    public static void main(String[] args) {
        int[] nums = { 1, 4, 6, 8, 10 };
        System.out.println(Arrays.toString(getSumAbsoluteDifferences(nums)));
    }

    public static int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length, rightSum = 0, leftSum = 0, totalSum = 0;
        for (int i : nums)
            rightSum += i;
        for (int i = 0; i < n; i++) {
            rightSum -= nums[i];
            leftSum += nums[i];
            totalSum = Math.abs((i + 1) * nums[i] - leftSum) +
                    Math.abs((n - i - 1) * nums[i] - rightSum);
            nums[i] = totalSum;
        }
        return nums;
    }
}
