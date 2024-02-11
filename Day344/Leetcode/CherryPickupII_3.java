//Leetcode
//1463. Cherry Pickup II - Bottom Up/Tabulation
//Time complexity: O(m*n^2)
//Space complexity: O(m*n^2) 

package Leetcode;

import java.util.Arrays;

public class CherryPickupII_3 {

    public static void main(String[] args) {
        int[][] grid = { { 3, 1, 1 }, { 2, 5, 1 }, { 1, 5, 5 }, { 2, 1, 1 } };
        System.out.println(cherryPickup(grid));
    }

    public static int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][n];
        int ans = 0;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                Arrays.fill(dp[i][j], -1);

        dp[0][0][n - 1] = grid[0][0] + grid[0][n - 1];

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) { // robotA
                for (int k = j + 1; k < n; k++) { // robotB
                    int max = -1;
                    for (int x = -1; x <= 1; x++) { // we will have total 9 combinations
                        for (int y = -1; y <= 1; y++) {
                            if (j + x >= 0 && j + x < n && k + y >= 0 && k + y < n)
                                max = Math.max(
                                        max,
                                        dp[i - 1][j + x][k + y]);
                        }
                    }
                    if (max != -1)
                        dp[i][j][k] = max + grid[i][j] + grid[i][k];
                    if (ans < dp[i][j][k])
                        ans = dp[i][j][k];
                }
            }
        }
        return ans;
    }
}
