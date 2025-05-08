//Leetcode
//3342. Find Minimum Time to Reach Last Room II
//Time complexity: O(mnlogmn)
//Space complexity: O(mn)

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMinimumTimeToReachLastRoomII {

    public static void main(String[] args) {
        int[][] moveTime = { { 0, 4 }, { 4, 4 } };
        System.out.println(minTimeToReach(moveTime));
    }

    public static int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length, inf = Integer.MAX_VALUE;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], inf);
        }
        PriorityQueue<int[]> h = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        h.offer(new int[] { 0, 0, 0 }); // arrive time, i, j
        moveTime[0][0] = -1;

        while (!h.isEmpty()) {
            int[] cur = h.poll();
            int t = cur[0], i = cur[1], j = cur[2];
            if (t >= dp[i][j])
                continue;
            if (i == n - 1 && j == m - 1)
                return t;
            dp[i][j] = t;

            int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1], c = (i + j) % 2 + 1;
                if (0 <= x && x < n && 0 <= y && y < m && dp[x][y] == inf) {
                    h.offer(new int[] { Math.max(moveTime[x][y], t) + c, x, y });
                }
            }
        }
        return -1;
    }
}
