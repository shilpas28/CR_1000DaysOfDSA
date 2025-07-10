//Leetcode
//3440. Reschedule Meetings for Maximum Free Time II
//Time complexity: O(N)
//Space complexity: O(N) 

import java.util.ArrayList;
import java.util.List;

public class RescheduleMeetingsForMaximumFreeTimeII_2 {

    public static void main(String[] args) {
        int eventTime = 10;
        int[] startTime = { 0, 7, 9 };
        int[] endTime = { 1, 8, 10 };
        System.out.println(maxFreeTime(eventTime, startTime, endTime));
    }

    public static int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;

        List<Integer> free = new ArrayList<>();
        free.add(startTime[0]); // before first
        for (int i = 1; i < n; i++) {
            free.add(startTime[i] - endTime[i - 1]);
        }
        free.add(eventTime - endTime[n - 1]); // after last

        int m = free.size();
        int[] pre = new int[m];
        int[] suf = new int[m];

        // prefix max
        pre[0] = free.get(0);
        for (int i = 1; i < m; i++) {
            pre[i] = Math.max(pre[i - 1], free.get(i));
        }

        // suffix max
        suf[m - 1] = free.get(m - 1);
        for (int i = m - 2; i >= 0; i--) {
            suf[i] = Math.max(suf[i + 1], free.get(i));
        }

        int mx = 0;
        for (int i = 0; i < n; i++) {
            int cur_time = endTime[i] - startTime[i];

            int prev_end = (i == 0) ? 0 : endTime[i - 1];
            int next_st = (i == n - 1) ? eventTime : startTime[i + 1];

            int prev_free = startTime[i] - prev_end;
            int next_free = next_st - endTime[i];

            int total_gap = prev_free + next_free;
            mx = Math.max(mx, total_gap);

            int max_outside = 0;
            if (i > 0)
                max_outside = Math.max(max_outside, pre[i - 1]);
            if (i + 2 < m)
                max_outside = Math.max(max_outside, suf[i + 2]);

            if (max_outside >= cur_time) {
                int extended = total_gap + cur_time;
                mx = Math.max(mx, extended);
            }
        }

        return mx;
    }
}
