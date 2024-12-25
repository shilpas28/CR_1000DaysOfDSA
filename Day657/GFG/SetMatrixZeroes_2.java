//GFG
//Set Matrix Zeroes - Better solution
//Time complexity: O(2*(N*M)), where N = no. of rows in the matrix and M = no. of columns in the matrix. = O(N^2)
//Space complexity: O(N) + O(M), where N = no. of rows in the matrix and M = no. of columns in the matrix.

public class SetMatrixZeroes_2 {

    public static void main(String[] args) {
        int mat[][] = { { 1, -1, 1 },
                { -1, 0, 1 },
                { 1, -1, 1 } };
        setMatrixZeroes(mat);
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void setMatrixZeroes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] row = new int[n]; // row array
        int[] col = new int[m]; // col array

        // Traverse the matrix:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    // mark ith index of row wih 1:
                    row[i] = 1;
                    // mark jth index of col wih 1:
                    col[j] = 1;
                }
            }
        }
        // Finally, mark all (i, j) as 0
        // if row[i] or col[j] is marked with 1.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    mat[i][j] = 0;
                }
            }
        }
    }
}
