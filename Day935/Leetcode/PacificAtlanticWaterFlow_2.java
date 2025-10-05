//Leetcode
//417. Pacific Atlantic Water Flow - BFS
//Time complexity: O(n*m)
//Space complexity: O(n*m)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow_2 {

    public static void main(String[] args) {
        int[][] heights = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
                { 5, 1, 1, 2, 4 } };
        System.out.println(pacificAtlantic(heights));
    }

    static int dirs[][] = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList<>();
        int n = heights.length, m = heights[0].length;
        boolean po[][] = new boolean[n][m];
        boolean ao[][] = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            bfs(i, 0, po, heights);
            bfs(i, m - 1, ao, heights);
        }
        for (int j = 0; j < m; j++) {
            bfs(0, j, po, heights);
            bfs(n - 1, j, ao, heights);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (po[i][j] && ao[i][j])
                    list.add(Arrays.asList(i, j));
            }
        }
        return list;
    }

    static void bfs(int X, int Y, boolean vis[][], int heights[][]) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { X, Y });
        vis[X][Y] = true;

        int n = heights.length, m = heights[0].length;
        while (!q.isEmpty()) {
            int[] top = q.remove();
            int x = top[0], y = top[1];

            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m &&
                        !vis[nx][ny] && heights[nx][ny] >= heights[x][y]) {
                    vis[nx][ny] = true;
                    q.add(new int[] { nx, ny });
                }
            }
        }
    }
}
