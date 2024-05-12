//Leetcode
//2373. Largest Local Values in a Matrix - Optimized
//Time complexity: O(N^2)
//Space complexity: O(N^2) - Space complexity is not improved but time complexity is improved as it eliminated 4 for loops to 2.

package Leetcode;

public class LargestLocalValuesInAMatrix_2 {

    public static void main(String[] args) {
        int[][] grid = { { 9, 9, 8, 1 }, { 5, 6, 2, 6 }, { 8, 2, 6, 4 }, { 6, 2, 2, 2 } };
        int[][] res = largestLocal(grid);
        for (int[] row : res) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int m = n - 2;
        int[][] ans = new int[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = largestLocalUtil(grid, i, j);
            }
        }
        return ans;
    }

    static int largestLocalUtil(int[][] grid, int x, int y) {
        int max = 0;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }
}
