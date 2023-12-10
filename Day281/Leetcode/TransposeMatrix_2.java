//Leetcode
//867. Transpose Matrix - Slightly better solution - only one traversal (using extra array) 
//Time complexity: O(n^2)
//Space complexity: O(m*n) 

package Leetcode;

public class TransposeMatrix_2 {

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

        for (int j = 0; j < cols; j++)
            for (int i = 0; i < rows; i++)
                temp[j][i] = matrix[i][j];

        return temp;
    }

}
