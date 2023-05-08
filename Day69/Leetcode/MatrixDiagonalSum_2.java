//Leetcode
//Matrix Diagonal Sum
//Time complexity: O(N)
//Space complexity: O(1) 

package Leetcode;

public class MatrixDiagonalSum_2 {
    public static void main(String[] args) {
        int[][] mat = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        System.out.println(diagonalSum(mat));
    }

    public static int diagonalSum(int[][] mat) {
        int n = mat.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += mat[i][i];
            if (i != n - 1 - i)
                res += mat[i][n - 1 - i];
        }
        return res;
    }
}
