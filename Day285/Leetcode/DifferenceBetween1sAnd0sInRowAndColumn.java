//Leetcode
//2482. Difference Between Ones and Zeros in Row and Column - Method 1 (Without Equation Simplication)
//Time complexity: O(row ∗ col)
//Space complexity: O(row + col)

package Leetcode;

public class DifferenceBetween1sAnd0sInRowAndColumn {

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
        int m = grid.length, n = grid[0].length;
        int[][] diff = new int[m][n];
        int[] rows = new int[m], cols = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rows[i] += grid[i][j]; // # of 1s in row
                cols[j] += grid[i][j]; // # of 1s in col
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // zeros in rowi = length of rowi - ones in rowi
                // zeros in colj = length of colj - ones in colj
                diff[i][j] = rows[i] + cols[j] - (n - rows[i]) - (m - cols[j]);
            }
        }
        return diff;
    }
}
