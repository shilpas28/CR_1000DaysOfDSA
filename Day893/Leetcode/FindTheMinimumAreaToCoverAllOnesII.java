//Leetcode
//3197. Find the Minimum Area to Cover All Ones II
//Time complexity: O(M^3 * N^3)
//Space complexity: O(M*N)

import java.util.Arrays;

public class FindTheMinimumAreaToCoverAllOnesII {

    public static void main(String[] args) {
        int[][] grid = { { 1, 0, 1 }, { 1, 1, 1 } };
        System.out.println(minimumSum(grid));
    }

    public static int minimumSum(int[][] grid) {
        int res = Integer.MAX_VALUE;

        for (int rot = 0; rot < 4; rot++) {
            int n = grid.length, m = grid[0].length;
            for (int i = 1; i < n; i++) {
                int a1 = minimumArea(Arrays.copyOfRange(grid, 0, i));
                for (int j = 1; j < m; j++) {
                    int[][] part2 = new int[n - i][j];
                    int[][] part3 = new int[n - i][m - j];
                    for (int r = 0; r < n - i; r++) {
                        part2[r] = Arrays.copyOfRange(grid[i + r], 0, j);
                        part3[r] = Arrays.copyOfRange(grid[i + r], j, m);
                    }
                    int a2 = minimumArea(part2);
                    int a3 = minimumArea(part3);
                    res = Math.min(res, a1 + a2 + a3);
                }
                for (int i2 = i + 1; i2 < n; i2++) {
                    int[][] part2 = Arrays.copyOfRange(grid, i, i2);
                    int[][] part3 = Arrays.copyOfRange(grid, i2, n);
                    int a2 = minimumArea(part2);
                    int a3 = minimumArea(part3);
                    res = Math.min(res, a1 + a2 + a3);
                }
            }
            grid = rotate(grid);
        }
        return res;
    }

    static int minimumArea(int[][] A) {
        if (A.length == 0 || A[0].length == 0)
            return 0;
        int n = A.length, m = A[0].length;
        int left = Integer.MAX_VALUE, top = Integer.MAX_VALUE;
        int right = -1, bottom = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    left = Math.min(left, j);
                    top = Math.min(top, i);
                    right = Math.max(right, j);
                    bottom = Math.max(bottom, i);
                }
            }
        }
        if (right == -1)
            return 0;
        return (right - left + 1) * (bottom - top + 1);
    }

    static int[][] rotate(int[][] A) {
        int n = A.length, m = A[0].length;
        int[][] rotated = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotated[j][n - 1 - i] = A[i][j];
            }
        }
        return rotated;
    }
}
