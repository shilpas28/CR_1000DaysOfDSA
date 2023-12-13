//Leetcode
//1582. Special Positions in a Binary Matrix - Brute Force
//Time complexity: O(m.n.(m+n)))
//Space complexity: O(1)

package Leetcode;

public class SpecialPositionsInABinaryMatrix {

    public static void main(String[] args) {
        int[][] mat = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
        System.out.println(numSpecial(mat));
    }

    public static int numSpecial(int[][] mat) {
        int ans = 0;
        int m = mat.length;
        int n = mat[0].length;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] == 0) {
                    continue;
                }

                boolean good = true;
                for (int r = 0; r < m; r++) {
                    if (r != row && mat[r][col] == 1) {
                        good = false;
                        break;
                    }
                }

                for (int c = 0; c < n; c++) {
                    if (c != col && mat[row][c] == 1) {
                        good = false;
                        break;
                    }
                }

                if (good) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
