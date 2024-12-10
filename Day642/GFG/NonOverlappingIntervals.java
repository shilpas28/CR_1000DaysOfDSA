//GFG
//Non-overlapping Intervals
//Time complexity: O(NlogN)
//Space complexity: O(1)

import java.util.Arrays;

public class NonOverlappingIntervals {

    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        System.out.println(minRemoval(intervals));
    }

    static int minRemoval(int intervals[][]) {
        // code here
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int end = intervals[0][1];
        int cnt = 0;
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] < end) {
                ++cnt;
            } else {
                end = intervals[i][1];
            }
        }
        return cnt;
    }
}
