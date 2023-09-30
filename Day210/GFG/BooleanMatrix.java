//GFG
//Boolean Matrix - Brute force method
//Time complexity: O((N*M)*(N + M)) + O(N*M), where N = no. of rows in the matrix and M = no. of columns in the matrix. = O(N^3)
//Space complexity: O(1)

public class BooleanMatrix {

    public static void main(String[] args) {
        int matrix[][] = { { 1, 0 },
                { 0, 0 } };
        booleanMatrix(matrix);
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    // Function to modify the matrix such that if a matrix cell matrix[i][j]
    // is 1 then all the cells in its ith row and jth column will become 1.
    static void booleanMatrix(int matrix[][]) {
        // code here
        int n = matrix.length;
        int m = matrix[0].length;
        // Set x for rows and cols that contains 0. Don't mark any 0 as x:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    markRow(matrix, n, m, i);
                    markCol(matrix, n, m, j);
                }
            }
        }
        // Finally, mark all x as 0:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == (char) ('x')) {
                    matrix[i][j] = 1;
                }
            }
        }
    }

    static void markRow(int[][] matrix, int n, int m, int i) {
        // set all non-zero elements as x in the row i:
        for (int j = 0; j < m; j++) {
            if (matrix[i][j] != 1) {
                matrix[i][j] = (char) ('x');
            }
        }
    }

    static void markCol(int[][] matrix, int n, int m, int j) {
        // set all non-zero elements as x in the col j:
        for (int i = 0; i < n; i++) {
            if (matrix[i][j] != 1) {
                matrix[i][j] = (char) ('x');
            }
        }
    }

}
