//Leetcode
//2684. Maximum Number of Moves in a Grid
//Time complexity: O(M*N)
//Space complexity: O(M)

public class MaximumNumberOfMovesInAGrid_2 {

    public static void main(String[] args) {
        int[][] grid = { { 2, 4, 3, 5 }, { 5, 4, 9, 3 }, { 3, 4, 2, 11 }, { 10, 9, 13, 15 } };
        System.out.println(maxMoves(grid));
    }

    public static int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        int[] dp = new int[m];

        for (int j = 1; j < n; j++) {
            int leftTop = 0;
            boolean found = false;

            for (int i = 0; i < m; i++) {
                int cur = -1;
                int nxtLeftTop = dp[i];

                if (i - 1 >= 0 && leftTop != -1 && grid[i][j] > grid[i - 1][j - 1])
                    cur = Math.max(cur, leftTop + 1);

                if (dp[i] != -1 && grid[i][j] > grid[i][j - 1])
                    cur = Math.max(cur, dp[i] + 1);

                if (i + 1 < m && dp[i + 1] != -1 && grid[i][j] > grid[i + 1][j - 1])
                    cur = Math.max(cur, dp[i + 1] + 1);

                dp[i] = cur;
                found = found || (dp[i] != -1);
                leftTop = nxtLeftTop;
            }

            if (!found)
                break;
            res = j;
        }
        return res;
    }
}
