//GFG
//Anti Diagonal Traversal of Matrix
//Time complexity: O(N*N)
//Space complexity: O(N*N)

package GFG;

import java.util.Arrays;

public class AntiDiagonalTraversalOfMatrix_2 {

    public static void main(String[] args) {

        int matrix[][] = { { 3, 2, 3 },
                { 4, 5, 1 },
                { 7, 8, 9 } };
        System.out.println(Arrays.toString(antiDiagonalPattern(matrix)));
    }

    public static int[] antiDiagonalPattern(int[][] matrix) {
        // Code here
        int n = matrix.length, k = 0, x = 0;
        int arr[] = new int[n * n];

        for (int i = 0; i < n; i++) {
            k = 0;
            for (int j = i; j >= 0; j--)
                arr[x++] = matrix[k++][j];
        }
        for (int i = 1; i < n; i++) {
            k = i;
            for (int j = n - 1; j >= i; j--)
                arr[x++] = matrix[k++][j];
        }
        return arr;
    }
}
