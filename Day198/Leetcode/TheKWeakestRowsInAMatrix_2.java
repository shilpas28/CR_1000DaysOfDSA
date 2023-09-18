//leetcode - using Array
//1337. The K Weakest Rows in a Matrix
//Time complexity: O(M*N) where M = rows and N = columns
//Space complexity: O(M) where M = rows and N = columns

package Leetcode;

import java.util.Arrays;

public class TheKWeakestRowsInAMatrix_2 {

    public static void main(String[] args) {
        int[][] mat = { { 1, 1, 0, 0, 0 },
                { 1, 1, 1, 1, 0 },
                { 1, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 0 },
                { 1, 1, 1, 1, 1 } };
        int k = 3;
        System.out.println(Arrays.toString(kWeakestRows(mat, k)));
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int[] count = new int[mat.length];
        int[] res = new int[k];

        for (int i = 0; i < mat.length; i++) {
            int soldiers = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1)
                    soldiers++;
                else
                    break;
            }
            count[i] = soldiers * 1000 + i;
        }

        Arrays.sort(count);

        for (int i = 0; i < k; i++)
            res[i] = count[i] % 1000;

        return res;
    }
}
