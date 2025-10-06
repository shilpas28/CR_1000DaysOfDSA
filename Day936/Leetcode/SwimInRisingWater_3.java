//Leetcode
//778. Swim in Rising Water - Heap
//Time complexity: O(N^2*logN)
//Space complexity: O(N^2) 

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SwimInRisingWater_3 {

    public static void main(String[] args) {
        int[][] grid = { { 0, 2 }, { 1, 3 } };
        System.out.println(swimInWater(grid));
    }

    public static int swimInWater(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        Set<String> seen = new HashSet<>();

        pq.offer(new int[] { grid[0][0], 0, 0 });

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int max_d = curr[0], r = curr[1], c = curr[2];

            String key = r + "," + c;
            if (seen.contains(key))
                continue;
            seen.add(key);

            if (r == m - 1 && c == n - 1)
                return max_d;

            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !seen.contains(nr + "," + nc)) {
                    int new_d = Math.max(max_d, grid[nr][nc]);
                    pq.offer(new int[] { new_d, nr, nc });
                }
            }
        }
        return -1;
    }
}
