//GFG
//Binary matrix having maximum number of 1s
//Time complexity: O(NlogN)
//Space complexity: O(1)

package GFG;

import java.util.Arrays;

public class BinaryMatrixHavingMaxNumberOfOnes_1 {

    public static void main(String[] args) {
        int mat[][] = { { 0, 0, 1 }, { 0, 1, 1 }, { 0, 0, 0 } };
        System.out.println(Arrays.toString(findMaxRow(mat, 3)));
    }

    public static int[] findMaxRow(int mat[][], int N) {
        // code here
        int res[] = new int[2];
        int ans = 0, row = 0;

        for (int i = 0; i < N; i++) {

            // binary search
            int l = 0, h = N - 1;
            while (l <= h) {
                int m = l + (h - l) / 2;
                if (mat[i][m] == 1)
                    h = m - 1;
                else
                    l = m + 1;
            }

            int count = N - l;
            if (count > ans) {
                ans = count;
                row = i;
            }
        }
        res[0] = row;
        res[1] = ans;
        return res;
    }
}
