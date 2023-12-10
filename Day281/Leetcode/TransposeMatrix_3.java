//Leetcode - NOTE THIS SOLUTION IS ACCEPTABLE ONLY FOR SQUARE MATRICES. HENCE NOT ACCEPTED BY LEETCODE.
//867. Transpose Matrix - Slightly better solution - only one traversal (using extra array) 
//Time complexity: O(n^2)
//Space complexity: O(1) because we are not using any extra space

package Leetcode;

public class TransposeMatrix_3 {

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
        for (int i = 0; i < matrix.length; i++)
            for (int j = i + 1; j < matrix[i].length; j++)
                swap(matrix, i, j);

        return matrix;
    }

    static void swap(int matrix[][], int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

}
