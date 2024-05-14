//Leetcode
//1219. Path with Maximum Gold - BFS
//Time complexity: O(k * 4 ^ k + m * n - k), where k = number of gold cells, m = grid.length, n = grid[0].length.
//Space complexity: O(k * 4 ^ k + m * n - k), where k = number of gold cells, m = grid.length, n = grid[0].length.

package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class PathWithMaximumGold_3 {

    public static void main(String[] args) {
        int[][] grid = { { 0, 6, 0 }, { 5, 8, 7 }, { 0, 9, 0 } };
        System.out.println(getMaximumGold(grid));
    }

    static final int[] d = { 0, 1, 0, -1, 0 };

    public static int getMaximumGold(int[][] grid) {
        int ans = 0, m = grid.length, n = grid[0].length;
        int[][] oneCellTrace = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0, goldCellId = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > 0) {
                    oneCellTrace[i][j] = 1 << goldCellId++;
                    q.offer(new int[] { i, j, grid[i][j], oneCellTrace[i][j] });
                }
            }
        }
        while (!q.isEmpty()) {
            int i = q.peek()[0], j = q.peek()[1], sum = q.peek()[2], trace = q.poll()[3];
            ans = Math.max(sum, ans);
            for (int k = 0; k < 4; ++k) {
                int r = i + d[k], c = j + d[k + 1];
                if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] > 0 && (trace & oneCellTrace[r][c]) == 0) {
                    q.offer(new int[] { r, c, sum + grid[r][c], trace | oneCellTrace[r][c] });
                }
            }
        }
        return ans;
    }
}
