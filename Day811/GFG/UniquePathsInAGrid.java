//GFG
//Unique Paths in a Grid - Tabulation 
//Time complexity: O(n*m)
//Space complexity: O(n*m)

import java.util.Arrays;

public class UniquePathsInAGrid {

    public static void main(String[] args) {
        int grid[][] = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        System.out.println(uniquePaths(grid));
    }

    public static int uniquePaths(int[][] grid) {
        // code here
        int dp[][] = new int[grid.length][grid[0].length];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        return rec(0, 0, grid, dp);
    }

    static int rec(int i, int j, int grid[][], int dp[][]) {
        if (i == grid.length || j == grid[0].length || grid[i][j] == 1)
            return 0;
        if (i == grid.length - 1 && j == grid[0].length - 1)
            return 1;
        if (dp[i][j] != -1)
            return dp[i][j];
        int count = 0;
        count += rec(i + 1, j, grid, dp);
        count += rec(i, j + 1, grid, dp);
        return dp[i][j] = count;
    }
}
