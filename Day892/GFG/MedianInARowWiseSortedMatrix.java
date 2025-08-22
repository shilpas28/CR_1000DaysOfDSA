//GFG
//Median in a row-wise sorted Matrix
//Time complexity: O(N^2)
//Space complexity: O(1)

import java.util.Arrays;

public class MedianInARowWiseSortedMatrix {

    public static void main(String[] args) {
        int mat[][] = { { 1, 3, 5 },
                { 2, 6, 9 },
                { 3, 6, 9 } };
        System.out.println(median(mat));
    }

    public static int median(int[][] mat) {
        // code here
        int[] ans = new int[mat.length * mat[0].length];
        int k = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                ans[k++] = mat[i][j];
            }
        }
        Arrays.sort(ans);
        return ans[k / 2];
    }
}
