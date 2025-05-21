//Leetcode
//73. Set Matrix Zeroes - Brute Force 
//Time complexity: O(3*(N*M))
//Space complexity: O(N) + O(M)

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        setZeroes(matrix);
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }

        for (int i = 0; i < row.size(); i++)
            for (int j = 0; j < n; j++)
                matrix[row.get(i)][j] = 0;

        for (int i = 0; i < col.size(); i++)
            for (int j = 0; j < m; j++)
                matrix[j][col.get(i)] = 0;
    }
}
