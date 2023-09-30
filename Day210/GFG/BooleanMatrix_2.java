//GFG
//Boolean Matrix - Better method
//Time complexity: O(2*(N*M)), where N = no. of rows in the matrix and M = no. of columns in the matrix. = O(N^2)
//Space complexity: O(N) + O(M), where N = no. of rows in the matrix and M = no. of columns in the matrix.

public class BooleanMatrix_2 {

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
        int[] row = new int[n]; // row array
        int[] col = new int[m]; // col array

        // Traverse the matrix:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
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
                    matrix[i][j] = 1;
                }
            }
        }
    }
}
