//GFG
//Letters Collection
//Time complexity: O(q)
//Space complexity: O(q) 

package GFG;

import java.util.ArrayList;
import java.util.List;

public class LettersCollection {

    public static void main(String[] args) {
        int n = 4, m = 5;
        int[][] mat = { { 1, 2, 3, 4, 10 },
                { 5, 6, 7, 8, 10 },
                { 9, 1, 3, 4, 10 },
                { 1, 2, 3, 4, 10 } };
        int q = 2;
        int[][] queries = { { 1, 0, 1 }, { 2, 0, 1 } };
        System.out.println(matrixSum(n, m, mat, q, queries));
    }

    static List<Integer> matrixSum(int n, int m, int mat[][], int q, int queries[][]) {
        // code here
        int[] dx1 = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dy1 = { -1, 0, 1, -1, 1, -1, 0, 1 };
        int[] dx2 = { -2, -2, -2, -2, -2, -1, -1, 0, 0, 1, 1, 2, 2, 2, 2, 2, };
        int[] dy2 = { -2, -1, 0, 1, 2, -2, 2, -2, 2, -2, 2, -2, -1, 0, 1, 2 };
        List<Integer> al = new ArrayList<>();
        for (int x = 0; x < q; x++) {
            int sum = 0;
            int i = queries[x][1], j = queries[x][2];
            if (queries[x][0] == 1) {
                for (int k = 0; k < dx1.length; k++) {
                    int n_x = i + dx1[k], n_y = j + dy1[k];
                    if (isSafe(n_x, n_y, n, m))
                        sum += mat[n_x][n_y];
                }
            } else {
                for (int k = 0; k < dx2.length; k++) {
                    int n_x = i + dx2[k], n_y = j + dy2[k];
                    if (isSafe(n_x, n_y, n, m))
                        sum += mat[n_x][n_y];
                }
            }
            al.add(sum);
        }
        return al;
    }

    static boolean isSafe(int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m)
            return false;
        return true;
    }
}
