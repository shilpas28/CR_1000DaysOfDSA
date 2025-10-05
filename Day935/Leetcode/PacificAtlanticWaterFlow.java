//Leetcode
//417. Pacific Atlantic Water Flow - DFS
//Time complexity: O(m*n)
//Space complexity: O(m*n)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {

    public static void main(String[] args) {
        int[][] heights = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
                { 5, 1, 1, 2, 4 } };
        System.out.println(pacificAtlantic(heights));
    }

    static int m, n;
    static int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int j = 0; j < n; j++)
            dfs(0, j, heights, pacific);
        for (int i = 0; i < m; i++)
            dfs(i, 0, heights, pacific);
        for (int j = 0; j < n; j++)
            dfs(m - 1, j, heights, atlantic);
        for (int i = 0; i < m; i++)
            dfs(i, n - 1, heights, atlantic);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    static void dfs(int i, int j, int[][] heights, boolean[][] visited) {
        if (visited[i][j])
            return;
        visited[i][j] = true;
        for (int[] d : directions) {
            int x = i + d[0], y = j + d[1];
            if (x < 0 || x >= m || y < 0 || y >= n)
                continue;
            if (heights[x][y] < heights[i][j])
                continue;
            dfs(x, y, heights, visited);
        }
    }
}
