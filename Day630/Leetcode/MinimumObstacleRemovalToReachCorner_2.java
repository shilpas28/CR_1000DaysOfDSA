//Leetcode
//2290. Minimum Obstacle Removal to Reach Corner - Modified BFS
//Time complexity: O(m * n)
//Space complexity: O(m * n)

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MinimumObstacleRemovalToReachCorner_2 {

    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 1 }, { 1, 1, 0 }, { 1, 1, 0 } };
        System.out.println(minimumObstacles(grid));
    }

    static final int[] d = { 0, 1, 0, -1, 0 };
    static final int M = Integer.MAX_VALUE;

    public static int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int[] di : dist) {
            Arrays.fill(di, M);
        }
        dist[0][0] = 0;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[3]);
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int o = cur[0], r = cur[1], c = cur[2];
            for (int k = 0; k < 4; ++k) {
                int i = r + d[k], j = c + d[k + 1];
                if (0 <= i && i < m && 0 <= j && j < n && dist[i][j] == M) {
                    if (grid[i][j] == 1) {
                        dist[i][j] = o + 1;
                        dq.offer(new int[] { o + 1, i, j });
                    } else {
                        dist[i][j] = o;
                        dq.offerFirst(new int[] { o, i, j });
                    }
                }
            }
        }
        return dist[m - 1][n - 1];
    }
}
