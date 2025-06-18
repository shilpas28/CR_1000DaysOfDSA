//Leetcode
//2966. Divide Array Into Arrays With Max Difference
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivideArrayIntoArraysWithMaxDifference {

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
        Arrays.sort(nums);
        List<int[]> res = new ArrayList<>();
        for (int i = 2; i < nums.length; i += 3) {
            if (nums[i] - nums[i - 2] > k)
                return new int[][] {};
            res.add(new int[] { nums[i - 2], nums[i - 1], nums[i] });
        }
        return res.toArray(new int[res.size()][]);
    }
}
