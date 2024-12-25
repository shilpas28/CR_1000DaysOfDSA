//GFG
//Set Matrix Zeroes - Optimal solution
//Time complexity: O(2*(N*M)), where N = no. of rows in the matrix and M = no. of columns in the matrix.
//Space complexity: O(1) as we are not using any extra space.

public class SetMatrixZeroes_3 {

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
        int col0 = 1;
        // step 1: Traverse the matrix and
        // mark 1st row & col accordingly:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    // mark i-th row:
                    mat[i][0] = 0;
                    // mark j-th column:
                    if (j != 0)
                        mat[0][j] = 0;
                    else
                        col0 = 0;
                }
            }
        }
        // Step 2: Mark with 0 from (1,1) to (n-1, m-1):
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] != 0) {
                    // check for col & row:
                    if (mat[i][0] == 0 || mat[0][j] == 0) {
                        mat[i][j] = 0;
                    }
                }
            }
        }
        // step 3: Finally mark the 1st col & then 1st row:
        if (mat[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                mat[0][j] = 0;
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                mat[i][0] = 0;
            }
        }
    }
}
