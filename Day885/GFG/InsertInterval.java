//GFG
//Insert Interval
//Time complexity: O(N)
//Space complexity: O(N) 

import java.util.ArrayList;

public class InsertInterval {

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 4, 5 }, { 6, 7 }, { 8, 10 } };
        int[] newInterval = { 5, 6 };
        ArrayList<int[]> res = insertInterval(intervals, newInterval);
        for (int[] row : res) {
            for (int val : row) {
                System.out.print(val + " ");
            }
        }
    }

    public static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        // code here
        int n = intervals.length;
        int i = 0;
        ArrayList<int[]> res = new ArrayList<>();
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            ++i;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            ++i;
        }
        res.add(newInterval);
        while (i < n) {
            res.add(intervals[i]);
            ++i;
        }
        return res;
    }
}
