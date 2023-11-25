//Leetcode
//1685. Sum of Absolute Differences in a Sorted Array - Brute Force Method - Not accepted as TLE 
//Time complexity: O(N^2)
//Space complexity: O(N)

package Leetcode;

import java.util.Arrays;

public class SumOfAbsoluteDifferencesInASortedArray {

    public static void main(String[] args) {
        int[] nums = { 1, 4, 6, 8, 10 };
        System.out.println(Arrays.toString(getSumAbsoluteDifferences(nums)));
    }

    public static int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (i != j)
                    res[i] += Math.abs(nums[i] - nums[j]);
        return res;
    }
}
