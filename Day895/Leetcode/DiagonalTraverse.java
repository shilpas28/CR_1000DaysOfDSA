//Leetcode
//498. Diagonal Traverse - Using a dirs array 
//Time complexity:
//Space complexity:

import java.util.Arrays;

public class DiagonalTraverse {

    public static void main(String[] args) {
        int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(Arrays.toString(findDiagonalOrder(mat)));
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0)
            return new int[0];
        int m = mat.length, n = mat[0].length;

        int[] result = new int[m * n];
        int row = 0, col = 0, d = 0;
        int[][] dirs = { { -1, 1 }, { 1, -1 } };

        for (int i = 0; i < m * n; i++) {
            result[i] = mat[row][col];
            row += dirs[d][0];
            col += dirs[d][1];

            if (row >= m) {
                row = m - 1;
                col += 2;
                d = 1 - d;
            }
            if (col >= n) {
                col = n - 1;
                row += 2;
                d = 1 - d;
            }
            if (row < 0) {
                row = 0;
                d = 1 - d;
            }
            if (col < 0) {
                col = 0;
                d = 1 - d;
            }
        }

        return result;
    }
}
