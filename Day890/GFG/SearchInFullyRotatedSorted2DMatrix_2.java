//GFG
//Search in fully rotated sorted 2D matrix
//Time complexity: O(NlogN)
//Space complexity: O(1)

import java.util.Arrays;

public class SearchInFullyRotatedSorted2DMatrix_2 {

    public static void main(String[] args) {
        int x = 3;
        int mat[][] = { { 7, 8, 9, 10 },
                { 11, 12, 13, 1 },
                { 2, 3, 4, 5 } };
        System.out.println(searchMatrix(mat, x));
    }

    public static boolean searchMatrix(int[][] mat, int x) {
        // code here
        int rl = mat[0].length; // 4
        int cl = mat.length; // 3
        int[] temp = new int[rl];
        for (int i = 0; i < cl; i++) {
            temp = mat[i];
            Arrays.sort(temp);
            if (x > temp[0] - 1 && x < temp[rl - 1] + 1) {
                for (int j = 0; j < rl; j++) {
                    if (temp[j] == x) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
