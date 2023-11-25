//Leetcode
//1685. Sum of Absolute Differences in a Sorted Array - Better Method
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.Arrays;

public class SumOfAbsoluteDifferencesInASortedArray_2 {

    public static void main(String[] args) {
        int[] nums = { 1, 4, 6, 8, 10 };
        System.out.println(Arrays.toString(getSumAbsoluteDifferences(nums)));
    }

    public static int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int sumBelow = 0;
        int sumTotal = Arrays.stream(nums).sum();

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            sumTotal -= num;
            res[i] = sumTotal - (n - i - 1) * num + i * num - sumBelow;
            sumBelow += num;
        }
        return res;
    }
}
