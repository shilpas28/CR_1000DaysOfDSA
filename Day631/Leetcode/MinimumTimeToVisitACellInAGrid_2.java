//Leetcode
//2577. Minimum Time to Visit a Cell In a Grid - Dijkstra's algorithm
//Time complexity: O(RC * log(RC))
//Space complexity: O(RC) where R = rows and C = columns

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinimumTimeToVisitACellInAGrid_2 {

    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 3, 2 }, { 5, 1, 2, 5 }, { 4, 3, 8, 6 } };
        System.out.println(minimumTime(grid));
    }

    public static int minimumTime(int[][] grid) {

        if (Math.min(grid[0][1], grid[1][0]) > 1)
            return -1;

        int ROWS = grid.length, COLS = grid[0].length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[] { 0, 0, 0 }); // {time, r, c}
        Set<String> visit = new HashSet<>();

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int t = curr[0], r = curr[1], c = curr[2];

            if (r == ROWS - 1 && c == COLS - 1)
                return t;

            int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                String key = nr + "," + nc;

                if (nr < 0 || nc < 0 || nr == ROWS || nc == COLS ||
                        visit.contains(key)) {
                    continue;
                }

                int wait = (Math.abs(grid[nr][nc] - t) % 2 == 0) ? 1 : 0;
                int nTime = Math.max(grid[nr][nc] + wait, t + 1);
                minHeap.offer(new int[] { nTime, nr, nc });
                visit.add(key);
            }
        }
        return -1;
    }
}
