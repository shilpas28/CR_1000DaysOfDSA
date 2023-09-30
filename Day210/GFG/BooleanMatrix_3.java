//GFG
//Boolean Matrix - Optimal method
//Time complexity: O(2*(N*M)), where N = no. of rows in the matrix and M = no. of columns in the matrix.
//Space complexity: O(1) as we are not using any extra space.

public class BooleanMatrix_3 {

    public static void main(String[] args) {
        int matrix[][] = { { 1, 0, 0 },
                { 1, 0, 0 },
                { 1, 0, 0 },
                { 0, 0, 0 } };
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
        int col0 = 0;
        // step 1: Traverse the matrix and
        // mark 1st row & col accordingly:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    // mark i-th row:
                    matrix[i][0] = 1;
                    // mark j-th column:
                    if (j != 0)
                        matrix[0][j] = 1;
                    else
                        col0 = 1;
                }
            }
        }
        // Step 2: Mark with 0 from (1,1) to (n-1, m-1):
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] != 1) {
                    // check for col & row:
                    if (matrix[i][0] == 1 || matrix[0][j] == 1) {
                        matrix[i][j] = 1;
                    }
                }
            }
        }
        // step 3: Finally mark the 1st col & then 1st row:
        if (matrix[0][0] == 1) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 1;
            }
        }
        if (col0 == 1) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 1;
            }
        }
    }
}
