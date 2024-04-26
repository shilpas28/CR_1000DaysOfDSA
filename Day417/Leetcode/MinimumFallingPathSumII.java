//Leetcode - Not accepted as TLE
//1289. Minimum Falling Path Sum II - Recursion
//Time complexity: O(N^2)
//Space complexity: O(N)

package Leetcode;

public class MinimumFallingPathSumII {

    public static void main(String[] args) {
        int[][] grid = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(minFallingPathSum(grid));
    }

    public static int minFallingPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = rows;
        int result = Integer.MAX_VALUE;

        for (int j = 0; j < cols; j++) {
            result = Math.min(result, recurHelper(grid, rows - 1, j));
        }
        return result;
    }

    public static int recurHelper(int[][] nums, int rowIndex, int colIndex) {
        if (rowIndex < 0 || colIndex < 0 || colIndex > nums[0].length) {
            return 200;
        } else if (rowIndex == 0) {
            return nums[rowIndex][colIndex];
        }

        int res = nums[rowIndex][colIndex];
        int val = 250;
        for (int i = 0; i < nums[0].length; i++) {
            if (i == colIndex) {
                continue;
            }
            val = Math.min(val, recurHelper(nums, rowIndex - 1, i));
        }
        return res + val;
    }
}
