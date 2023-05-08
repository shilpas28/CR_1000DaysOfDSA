//Leetcode
//Matrix Diagonal Sum
//Time complexity: O(N)
//Space complexity: O(1) 

package Leetcode;

public class MatrixDiagonalSum_3 {
    public static void main(String[] args) {
        int[][] mat = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        System.out.println(diagonalSum(mat));
    }

    public static int diagonalSum(int[][] mat) {
        int sum = 0;
        for (int i = 0, k = mat.length - 1; i < mat.length; i++, k--) {
            sum = sum + mat[i][i];

            if (i != k) {
                sum = sum + mat[i][k];
            }
        }
        return sum;
    }
}
