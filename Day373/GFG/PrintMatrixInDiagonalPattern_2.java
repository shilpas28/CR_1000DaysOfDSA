//GFG
//Print matrix in diagonal pattern
//Time complexity: O(N^2)
//Space complexity: O(1)

package GFG;

import java.util.Arrays;

public class PrintMatrixInDiagonalPattern_2 {

    public static void main(String[] args) {
        int mat[][] = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        System.out.println(Arrays.toString(matrixDiagonally(mat)));
    }

    public static int[] matrixDiagonally(int[][] mat) {
        int n = mat.length;
        int ans[] = new int[n * n];
        int k = 0, i = 0, j = 0;
        int upper = 1;
        while (k < n * n) {
            if (upper == 1) {
                // Traverse upper diagonal
                while (i >= 0 && j < n) {
                    ans[k++] = mat[i][j];
                    if (j == n - 1) { // Switch to lower diagonal starting from next row
                        i++;
                        break;
                    } else if (i == 0) { // Switch to lower diagonal starting from next column
                        j++;
                        break;
                    }
                    // Move top right
                    i--;
                    j++;
                }
                upper = 0;
            } else {
                // Traverse lower diagonal
                while (i < n && j >= 0) {
                    ans[k++] = mat[i][j];
                    if (i == n - 1) { // Switch to upper diagonal starting from next column
                        j++;
                        break;
                    } else if (j == 0) { // Switch to upper diagonal starting from next row
                        i++;
                        break;
                    }
                    // Move bottom left
                    i++;
                    j--;
                }
                upper = 1;
            }
        }
        return ans;
    }
}
