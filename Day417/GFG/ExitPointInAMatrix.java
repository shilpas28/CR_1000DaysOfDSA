//GFG
//Exit Point in a Matrix
//Time complexity: O(n * m) where n = number of rows and m = number of columns.
//Space complexity: O(1)

import java.util.Arrays;

public class ExitPointInAMatrix {

    public static void main(String[] args) {
        int n = 3, m = 3;
        int[][] matrix = { { 0, 1, 0 },
                { 0, 1, 1 },
                { 0, 0, 0 } };
        System.out.println(Arrays.toString(FindExitPoint(n, m, matrix)));
    }

    public static int[] FindExitPoint(int n, int m, int[][] matrix) {
        // code here
        int i = 0, j = 0, previ = 0, prevj = 0, face = 0;
        while (i < n && i >= 0 && j >= 0 && j < m) {
            previ = i;
            prevj = j;
            if (matrix[i][j] == 1) {
                matrix[i][j] = 0;
                if (face == 0) {
                    i++;
                    face = 1;
                } else if (face == 1) {
                    j--;
                    face = 2;
                } else if (face == 2) {
                    i--;
                    face = 3;
                } else {
                    j++;
                    face = 0;
                }
            } else {
                if (face == 0)
                    j++;
                else if (face == 1)
                    i++;
                else if (face == 2)
                    j--;
                else
                    i--;
            }
        }
        int ans[] = new int[2];
        ans[0] = previ;
        ans[1] = prevj;
        return ans;
    }
}
