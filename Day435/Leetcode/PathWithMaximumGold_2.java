//Leetcode
//1219. Path with Maximum Gold - DFS code without modification of input
//Time complexity: O(k * 4 ^ k + m * n - k) where k = number of gold cells, m = grid.length, n = grid[0].length.
//Space complexity: O(m * n) where k = number of gold cells, m = grid.length, n = grid[0].length.

package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class PathWithMaximumGold_2 {

    public static void main(String[] args) {
        int[][] grid = { { 0, 6, 0 }, { 5, 8, 7 }, { 0, 9, 0 } };
        System.out.println(getMaximumGold(grid));
    }

    static final int[] d = { 0, 1, 0, -1, 0 };

    public static int getMaximumGold(int[][] grid) {
        int ans = 0, n = grid[0].length;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < n; ++j) {
                ans = Math.max(ans, dfs(grid, i, j, n, 0, new HashSet<Integer>()));
            }
        }
        return ans;
    }

    static int dfs(int[][] g, int i, int j, int n, int sum, Set<Integer> seen) {
        if (i < 0 || i >= g.length || j < 0 || j >= n || g[i][j] == 0)
            return sum;
        if (!seen.add(i * n + j))
            return sum; // mark (i, j) visited.
        sum += g[i][j];
        int mx = 0;
        for (int k = 0; k < 4; ++k) { // traverse 4 neighbors to get max value.
            mx = Math.max(mx, dfs(g, i + d[k], j + d[k + 1], n, sum, seen));
        }
        seen.remove(i * n + j); // reset to unvisited.
        return mx;
    }
}
