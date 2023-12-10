//Leetcode
//867. Transpose Matrix - Naive method using extra array and 2 traversals
//Time complexity: O(n^2)
//Space complexity: : O(m*n) or O(n*n) because rows and cols have to be same for transpose

package Leetcode;

public class TransposeMatrix {

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] result = transpose(matrix);
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int temp[][] = new int[cols][rows];

        for (int i = 0; i < cols; i++)
            for (int j = 0; j < rows; j++)
                temp[i][j] = matrix[j][i];

        matrix = new int[cols][rows];
        for (int i = 0; i < cols; i++)
            for (int j = 0; j < rows; j++)
                matrix[i][j] = temp[i][j];

        return matrix;
    }
}
