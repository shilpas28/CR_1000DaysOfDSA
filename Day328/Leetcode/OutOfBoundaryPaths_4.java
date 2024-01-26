//Leetcode
//576. Out of Boundary Paths - 2d DP  
//Time complexity: O(mn)
//Space complexity: O(mn)

package Leetcode;

public class OutOfBoundaryPaths_4 {

    public static void main(String[] args) {
        int m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0;
        System.out.println(findPaths(m, n, maxMove, startRow, startColumn));
    }

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][] dp = new int[m][n];
        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for (int step = 1; step <= maxMove; step++) {
            int[][] nxt = new int[m][n];
            for (int x = 0; x < m; x++)
                for (int y = 0; y < n; y++)
                    for (int d = 0; d < 4; d++) {
                        int a = x + dir[d][0], b = y + dir[d][1];
                        nxt[x][y] = (nxt[x][y] + (a < 0 || a == m || b < 0 || b == n ? 1 : dp[a][b])) % 1000000007;
                    }
            dp = nxt;
        }
        return dp[startRow][startColumn];
    }
}
