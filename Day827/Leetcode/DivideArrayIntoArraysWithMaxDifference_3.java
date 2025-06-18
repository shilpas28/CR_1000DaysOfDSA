//Leetcode
//2966. Divide Array Into Arrays With Max Difference
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.Arrays;

public class DivideArrayIntoArraysWithMaxDifference_3 {

    public static void main(String[] args) {
        int[] nums = { 1, 3, 4, 8, 7, 9, 3, 5, 1 };
        int k = 2;
        int[][] res = divideArray(nums, k);
        for (int[] row : res) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static int[][] divideArray(int[] nums, int k) {

        int ans[][] = new int[nums.length / 3][3];
        int ind = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 3) {
            int first = nums[i];
            int second = nums[i + 1];
            int third = nums[i + 2];
            if (third - first <= k) {
                ans[ind][0] = first;
                ans[ind][1] = second;
                ans[ind][2] = third;
                ind++;
            } else {
                return new int[0][0];
            }
        }
        return ans;
    }
}
