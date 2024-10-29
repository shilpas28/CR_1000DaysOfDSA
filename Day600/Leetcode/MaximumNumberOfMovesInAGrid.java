//Leetcode
//2684. Maximum Number of Moves in a Grid
//Time complexity: O(M*N)
//Space complexity: O(M*N) 

import java.util.Arrays;

public class MaximumNumberOfMovesInAGrid {

    public static void main(String[] args) {
        int[][] grid = { { 2, 4, 3, 5 }, { 5, 4, 9, 3 }, { 3, 4, 2, 11 }, { 10, 9, 13, 15 } };
        System.out.println(maxMoves(grid));
    }

    static int dirs[][] = { { 0, 1 }, { 1, 1 }, { -1, 1 } }, m, n, cache[][];

    public static int maxMoves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        cache = new int[m][n];
        Arrays.stream(cache).forEach(row -> Arrays.fill(row, -1));

        int res = 0;
        for (int i = 0; i < m; i++)
            res = Math.max(res, dp(grid, i, 0));
        return res;
    }

    static int dp(int[][] grid, int i, int j) {
        if (cache[i][j] != -1)
            return cache[i][j];
        int ans = 0;
        for (int[] dir : dirs) {
            int ni = i + dir[0], nj = j + dir[1];
            if (ni >= 0 && ni < m && nj < n && grid[i][j] < grid[ni][nj])
                ans = Math.max(ans, 1 + dp(grid, ni, nj));
        }
        return cache[i][j] = ans;
    }
}
