//Leetcode
//1751. Maximum Number of Events That Can Be Attended II - Bottom-up Dynamic Programming + Binary Search
//Time complexity: O(n*k*logn)
//Space complexity: O(n*k) 

import java.util.Arrays;

public class MaximumNumberOfEventsThatCanBeAttendedII_3 {

    public static void main(String[] args) {
        int[][] events = { { 1, 2, 4 }, { 3, 4, 3 }, { 2, 3, 1 } };
        int k = 2;
        System.out.println(maxValue(events, k));
    }

    public static int maxValue(int[][] events, int k) {
        int n = events.length;
        int[][] dp = new int[k + 1][n + 1];
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        for (int curIndex = n - 1; curIndex >= 0; --curIndex) {
            for (int count = 1; count <= k; count++) {
                int nextIndex = bisectRight(events, events[curIndex][1]);
                dp[count][curIndex] = Math.max(dp[count][curIndex + 1], events[curIndex][2] + dp[count - 1][nextIndex]);
            }
        }
        return dp[k][0];
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
