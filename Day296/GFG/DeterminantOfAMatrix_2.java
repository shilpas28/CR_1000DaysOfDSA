//GFG
//Determinant of a Matrix
//Time complexity: O(N^4)
//Space complexity: O(N^2) 

package GFG;

public class DeterminantOfAMatrix_2 {

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
        int ans = 0;
        if (n == 1) {
            return matrix[0][0];
        }
        int[][] temp = new int[n][n];
        int sign = 1;
        for (int i = 0; i < n; i++) {
            cofactor(matrix, temp, 0, i, n);
            ans += sign * matrix[0][i] * determinantOfMatrix(temp, n - 1);
            sign *= -1;
        }
        return ans;
    }

    static void cofactor(int matrix[][], int temp[][], int R, int C, int n) {
        int i = 0, j = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row != R && col != C) {
                    temp[i][j] = matrix[row][col];
                    j++;
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }
}
