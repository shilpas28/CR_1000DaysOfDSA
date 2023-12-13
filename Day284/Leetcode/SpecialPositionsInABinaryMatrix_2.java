//Leetcode
//1582. Special Positions in a Binary Matrix - Pre Count
//Time complexity: O(m.n)
//Space complexity: O(m+n)

package Leetcode;

public class SpecialPositionsInABinaryMatrix_2 {

    public static void main(String[] args) {
        int[][] mat = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
        System.out.println(numSpecial(mat));
    }

    public static int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] == 1) {
                    rowCount[row]++;
                    colCount[col]++;
                }
            }
        }

        int ans = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] == 1) {
                    if (rowCount[row] == 1 && colCount[col] == 1) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }
}
