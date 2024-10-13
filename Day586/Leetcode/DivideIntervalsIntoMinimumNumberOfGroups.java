//Leetcode
//2406. Divide Intervals Into Minimum Number of Groups - Method 1
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.Arrays;

public class DivideIntervalsIntoMinimumNumberOfGroups {

    public static void main(String[] args) {
        int[][] intervals = { { 5, 10 }, { 6, 8 }, { 1, 5 }, { 2, 3 }, { 1, 10 } };
        System.out.println(minGroups(intervals));
    }

    public static int minGroups(int[][] intervals) {
        int n = intervals.length;
        int[] start_times = new int[n];
        int[] end_times = new int[n];
        // Extract start and end times
        for (int i = 0; i < n; i++) {
            start_times[i] = intervals[i][0];
            end_times[i] = intervals[i][1];
        }
        // Sort start and end times
        Arrays.sort(start_times);
        Arrays.sort(end_times);

        int end_ptr = 0, group_count = 0;
        // Traverse through the start times
        for (int start : start_times) {
            if (start > end_times[end_ptr]) {
                end_ptr++;
            } else {
                group_count++;
            }
        }
        return group_count;
    }
}
