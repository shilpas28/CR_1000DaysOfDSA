//GFG
//Unique Paths in a Grid - Space Optimization
//Time complexity: O(n*m)
//Space complexity: O(m)

public class UniquePathsInAGrid_2 {

    public static void main(String[] args) {
        int grid[][] = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        System.out.println(uniquePaths(grid));
    }

    public static int uniquePaths(int[][] grid) {
        // code here
        int n = grid.length;
        int m = grid[0].length;
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1)
            return 0;
        int[] dp = new int[m + 1];
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[j] = grid[i - 1][j - 1] == 0 ? dp[j] + dp[j - 1] : 0;
            }
        }
        return dp[m];
    }
}
