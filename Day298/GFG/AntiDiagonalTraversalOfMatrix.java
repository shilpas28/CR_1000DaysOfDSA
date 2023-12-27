//GFG
//Anti Diagonal Traversal of Matrix
//Time complexity: O(N*N)
//Space complexity: O(N*N)

package GFG;

import java.util.Arrays;

public class AntiDiagonalTraversalOfMatrix {

    public static void main(String[] args) {

        int matrix[][] = { { 3, 2, 3 },
                { 4, 5, 1 },
                { 7, 8, 9 } };
        System.out.println(Arrays.toString(antiDiagonalPattern(matrix)));
    }

    public static int[] antiDiagonalPattern(int[][] matrix) {
        // Code here
        int n = matrix.length;
        int[] result = new int[n * n];
        int pos = 0;
        for (int i = 0; i < n; i++) { // Upper triangle traversal
            int row = 0, col = i;
            while (col >= 0) {
                result[pos++] = matrix[row][col];
                row++;
                col--;
            }
        }
        for (int i = 1; i < n; i++) { // Lower triangle traversal
            int row = i, col = n - 1;
            while (row < n) {
                result[pos++] = matrix[row][col];
                row++;
                col--;
            }
        }
        return result;
    }
}
