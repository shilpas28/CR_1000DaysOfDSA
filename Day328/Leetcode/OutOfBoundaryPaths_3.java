//Leetcode
//576. Out of Boundary Paths - 3d DP
//Time complexity: O(Nmn)
//Space complexity: O(Nmn)

package Leetcode;

public class OutOfBoundaryPaths_3 {

    public static void main(String[] args) {
        int m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0;
        System.out.println(findPaths(m, n, maxMove, startRow, startColumn));
    }

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[maxMove + 1][m][n];
        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for (int step = 1; step <= maxMove; step++)
            for (int x = 0; x < m; x++)
                for (int y = 0; y < n; y++)
                    for (int d = 0; d < 4; d++) {
                        int a = x + dir[d][0], b = y + dir[d][1];
                        dp[step][x][y] = (dp[step][x][y]
                                + (a < 0 || a == m || b < 0 || b == n ? 1 : dp[step - 1][a][b])) % 1000000007;
                    }
        return dp[maxMove][startRow][startColumn];
    }
}
