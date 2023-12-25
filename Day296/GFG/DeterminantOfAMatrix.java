//GFG
//Determinant of a Matrix
//Time complexity: O(N^4)
//Space complexity: O(N^2) 

package GFG;

public class DeterminantOfAMatrix {

    public static void main(String[] args) {
        int matrix[][] = { { 1, 0, 2, -1 },
                { 3, 0, 0, 5 },
                { 2, 1, 4, -3 },
                { 1, 0, 5, 0 } };
        int n = 4;
        System.out.println(determinantOfMatrix(matrix, n));
    }

    // Function for finding determinant of matrix.
    static int determinantOfMatrix(int matrix[][], int n) {
        // code here
        if (n == 1)
            return matrix[0][0];
        if (n == 2)
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        int det = 0;

        for (int i = 0; i < n; i++) {
            int cof = (int) Math.pow(-1, i) * matrix[0][i] * determinantOfMatrix(sub(matrix, 0, i), n - 1);
            det = det + cof;
        }
        return det;
    }

    static int[][] sub(int[][] mat, int r, int c) {
        int n = mat.length;
        int arr[][] = new int[n - 1][n - 1];

        int row = 0, col = 0;
        for (int i = 0; i < n; i++) {
            if (i != r) {
                for (int j = 0; j < n; j++) {
                    if (j != c) {
                        arr[row][col] = mat[i][j];
                        col++;
                    }
                }
                col = 0;
                row++;
            }
        }
        return arr;
    }
}
