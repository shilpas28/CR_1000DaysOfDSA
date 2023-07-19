//Leetcode
//435. Non-overlapping Intervals
//Time complexity: O(NlogN)
//Space complexity: O(1)

package Leetcode;

import java.util.Arrays;

public class NonOverlappingIntervals {

    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length < 2)
            return 0;
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int count = 0, last_included = 0;
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] < intervals[last_included][1]) {
                count++;
                if (intervals[i][1] < intervals[last_included][1])
                    last_included = i;
            } else
                last_included = i;
        }
        return count;
    }
}
