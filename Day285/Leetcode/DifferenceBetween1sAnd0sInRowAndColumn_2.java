//Leetcode
//2482. Difference Between Ones and Zeros in Row and Column - Method 1 (With Equation Simplication)
//Time complexity: O(m x n), where (m) is the number of rows and (n) is the number of columns in the grid matrix.
//Space complexity: (O(m + n) for the rowOnes and colOnes arrays.

package Leetcode;

public class DifferenceBetween1sAnd0sInRowAndColumn_2 {

    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 1 }, { 1, 0, 1 }, { 0, 0, 1 } };
        int[][] res = onesMinusZeros(grid);
        for (int[] row : res) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] onesMinusZeros(int[][] grid) {
        int[] rowOnes = new int[grid.length];
        int[] colOnes = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                rowOnes[i] += grid[i][j];
                colOnes[j] += grid[i][j];
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = 2 * (rowOnes[i] + colOnes[j]) - grid.length - grid[0].length;
            }
        }

        return grid;
    }
}
