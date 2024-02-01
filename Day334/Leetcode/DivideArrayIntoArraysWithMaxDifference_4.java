//Leetcode
//2966. Divide Array Into Arrays With Max Difference
//Time complexity: O(NlogN)
//Space complexity: O(N)

package Leetcode;

import java.util.Arrays;

public class DivideArrayIntoArraysWithMaxDifference_4 {

    public static void main(String[] args) {
        int[] nums = { 1, 3, 4, 8, 7, 9, 3, 5, 1 };
        int k = 2;
        int[][] res = divideArray(nums, k);
        for (int row[] : res) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static int[][] divideArray(int[] nums, int k) {
        int len = nums.length;
        int[][] res = new int[len / 3][3];
        Arrays.sort(nums);
        for (int i = 0, m = 0; i < len; i = i + 3, m++) {
            res[m][0] = nums[i];
            for (int j = 1; j < 3; j++) {
                if (nums[i + j] - res[m][0] <= k) {
                    res[m][j] = nums[i + j];
                } else {
                    return new int[0][0];
                }
            }
        }
        return res;
    }
}
