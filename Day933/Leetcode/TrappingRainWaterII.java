//Leetcode
//407. Trapping Rain Water II - BFS + Priority Queue
//Time complexity: O((m*n)*(log(m*n)))
//Space complexity: O(m*n)

import java.util.PriorityQueue;

public class TrappingRainWaterII {

    public static void main(String[] args) {
        int[][] heightMap = { { 1, 4, 3, 1, 3, 2 }, { 3, 2, 1, 3, 2, 4 }, { 2, 3, 3, 2, 3, 1 } };
        System.out.println(trapRainWater(heightMap));
    }

    static int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static int trapRainWater(int[][] heightMap) {

        int m = heightMap.length;
        int n = (m == 0 ? 0 : heightMap[0].length);
        int res = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            pq.offer(new int[] { i, 0, heightMap[i][0] });
            pq.offer(new int[] { i, n - 1, heightMap[i][n - 1] });
            visited[i][0] = visited[i][n - 1] = true;
        }

        for (int j = 1; j < n - 1; j++) {
            pq.offer(new int[] { 0, j, heightMap[0][j] });
            pq.offer(new int[] { m - 1, j, heightMap[m - 1][j] });
            visited[0][j] = visited[m - 1][j] = true;
        }

        while (!pq.isEmpty()) {
            int[] cell = pq.poll();

            for (int[] d : dirs) {
                int i = cell[0] + d[0], j = cell[1] + d[1];
                if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j])
                    continue;
                res += Math.max(0, cell[2] - heightMap[i][j]);
                pq.offer(new int[] { i, j, Math.max(heightMap[i][j], cell[2]) });
                visited[i][j] = true;
            }
        }
        return res;
    }
}
