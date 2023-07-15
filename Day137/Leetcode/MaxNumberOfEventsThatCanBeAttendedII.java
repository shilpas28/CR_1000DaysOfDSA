//Leetcode
//1751. Maximum Number of Events That Can Be Attended II
//Time complexity: O(N*N*K) 
//Space complexity: O(N*K) 

package Leetcode;

import java.util.Arrays;

public class MaxNumberOfEventsThatCanBeAttendedII {

    public static void main(String[] args) {
        int[][] events = { { 1, 2, 4 }, { 3, 4, 3 }, { 2, 3, 1 } };
        int k = 2;
        System.out.println(maxValue(events, k));
    }

    public static int maxValue(int[][] events, int k) {
        Arrays.sort(events, (ar1, ar2) -> ar1[0] - ar2[0]);
        int[][] memo = new int[k + 1][events.length];
        return dfs(events, k, 0, memo);
    }

    public static int dfs(int[][] events, int k, int idx, int[][] memo) {
        if (k == 1) {
            int max = 0;
            while (idx < events.length)
                max = Math.max(max, events[idx++][2]);
            return max;
        }
        if (memo[k][idx] != 0)
            return memo[k][idx];
        int ret = 0;
        for (int i = idx; i < events.length; i++) {
            // If I attend ith event..
            int val = events[i][2];
            // what event can I attend next?
            for (int j = i + 1; j < events.length; j++) {
                if (events[j][0] > events[i][1]) {
                    ret = Math.max(ret, val + dfs(events, k - 1, j, memo));
                }
            }
            ret = Math.max(ret, val);
        }
        return memo[k][idx] = ret;
    }
}
