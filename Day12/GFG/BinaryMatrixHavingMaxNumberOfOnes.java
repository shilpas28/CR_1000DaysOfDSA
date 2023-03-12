//GFG
//Binary matrix having maximum number of 1s
//Time complexity: O(N^2)
//Space complexity: O(1)

package GFG;

import java.util.Arrays;

public class BinaryMatrixHavingMaxNumberOfOnes {

    public static void main(String[] args) {
        int mat[][] = { { 0, 0, 1 }, { 0, 1, 1 }, { 0, 0, 0 } };
        System.out.println(Arrays.toString(findMaxRow(mat, 3)));
    }

    public static int[] findMaxRow(int mat[][], int N) {
        // code here
        int res[] = new int[2];
        int ans = 0, row = 0;
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == 1)
                    count++;
            }
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
