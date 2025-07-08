//Leetcode
//1751. Maximum Number of Events That Can Be Attended II - Top-down Dynamic Programming + Binary Search
//Time complexity: O(n*k*logn)
//Space complexity: O(n*k)

import java.util.Arrays;

public class MaximumNumberOfEventsThatCanBeAttendedII_2 {

    public static void main(String[] args) {
        int[][] events = { { 1, 2, 4 }, { 3, 4, 3 }, { 2, 3, 1 } };
        int k = 2;
        System.out.println(maxValue(events, k));
    }

    public static int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;

        dp = new int[k + 1][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(0, k, events);
    }

    static int[][] dp;

    static int dfs(int curIndex, int count, int[][] events) {
        if (count == 0 || curIndex == events.length) {
            return 0;
        }
        if (dp[count][curIndex] != -1) {
            return dp[count][curIndex];
        }
        int nextIndex = bisectRight(events, events[curIndex][1]);
        dp[count][curIndex] = Math.max(dfs(curIndex + 1, count, events),
                events[curIndex][2] + dfs(nextIndex, count - 1, events));
        return dp[count][curIndex];
    }

    static int bisectRight(int[][] events, int target) {
        int left = 0, right = events.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (events[mid][0] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
