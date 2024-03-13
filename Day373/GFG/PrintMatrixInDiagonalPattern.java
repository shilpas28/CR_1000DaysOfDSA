//GFG
//Print matrix in diagonal pattern
//Time complexity: O(N^2)
//Space complexity: O(1)

package GFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PrintMatrixInDiagonalPattern {

    public static void main(String[] args) {
        int mat[][] = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        System.out.println(Arrays.toString(matrixDiagonally(mat)));
    }

    public static int[] matrixDiagonally(int[][] mat) {
        int row = 0, col = 0, n = mat.length;
        boolean isReverse = false;
        int ans[] = new int[n * n];
        int index = 0;
        while (col < n) {
            ArrayList<Integer> temp = new ArrayList<>();
            int i = row, j = col;
            while (i < n && j < n && i >= 0 && j >= 0) {
                temp.add(mat[i][j]);
                i--;
                j++;
            }
            if (isReverse)
                Collections.reverse(temp);
            for (int k = 0; k < temp.size(); k++) {
                ans[index++] = temp.get(k);
            }
            if (row != n - 1) {
                row++;
                col = 0;
            } else {
                col++;
            }
            isReverse = !isReverse;
        }
        return ans;
    }
}
