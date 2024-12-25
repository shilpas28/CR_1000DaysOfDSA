//GFG
//Set Matrix Zeroes - Brute Force - Not accepted
//Time complexity: O((N*M)*(N + M)) + O(N*M), where N = no. of rows in the matrix and M = no. of columns in the matrix. = O(N^3)
//Space complexity: O(1) 

public class SetMatrixZeroes {

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
        // Set x for rows and cols that contains 0. Don't mark any 0 as x:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    markRow(mat, n, m, i);
                    markCol(mat, n, m, j);
                }
            }
        }
        // Finally, mark all x as 0:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == (char) ('x')) {
                    mat[i][j] = 0;
                }
            }
        }
    }

    static void markRow(int[][] matrix, int n, int m, int i) {
        // set all non-zero elements as x in the row i:
        for (int j = 0; j < m; j++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = (char) ('x');
            }
        }
    }

    static void markCol(int[][] matrix, int n, int m, int j) {
        // set all non-zero elements as x in the col j:
        for (int i = 0; i < n; i++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = (char) ('x');
            }
        }
    }
}
