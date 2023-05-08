//Leetcode
//Matrix Diagonal Sum
//Time complexity: O(N)
//Space complexity: O(1) 

package Leetcode;

public class MatrixDiagonalSum {
    public static void main(String[] args) {
        int[][] mat = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        System.out.println(diagonalSum(mat));
    }

    public static int diagonalSum(int[][] mat) {
        int n = mat.length;
        int diagonalSum = 0;
        for (int i = 0; i < n; i++)
            diagonalSum += mat[i][i] + mat[i][n - i - 1];
        if (n % 2 == 1)
            return diagonalSum -= mat[n / 2][n / 2];
        return diagonalSum;
    }
}
