//Leetcode
//3440. Reschedule Meetings for Maximum Free Time II
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.TreeMap;

public class RescheduleMeetingsForMaximumFreeTimeII {

    public static void main(String[] args) {
        int eventTime = 10;
        int[] startTime = { 0, 7, 9 };
        int[] endTime = { 1, 8, 10 };
        System.out.println(maxFreeTime(eventTime, startTime, endTime));
    }

    public static int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        TreeMap<Integer, Integer> multiset = new TreeMap<>();

        // simulate multiset
        add(multiset, startTime[0]);
        for (int i = 1; i < n; i++) {
            int cur_st = startTime[i];
            int prev_end = endTime[i - 1];
            int calc = cur_st - prev_end;
            add(multiset, calc);
        }

        add(multiset, eventTime - endTime[n - 1]);

        int mx = 0;
        for (int i = 0; i < n; i++) {
            int cur_st = startTime[i];
            int cur_end = endTime[i];
            int cur_time = cur_end - cur_st;

            int prev_end = (i == 0) ? 0 : endTime[i - 1];
            int prev_free = cur_st - prev_end;

            int nxt_st = (i == n - 1) ? eventTime : startTime[i + 1];
            int nxt_free = nxt_st - cur_end;

            remove(multiset, prev_free);
            remove(multiset, nxt_free);

            if (multiset.ceilingKey(cur_time) != null) {
                int endpoint_free = prev_free + nxt_free + cur_time;
                mx = Math.max(mx, endpoint_free);
            }

            mx = Math.max(mx, prev_free + nxt_free);

            add(multiset, prev_free);
            add(multiset, nxt_free);
        }

        return mx;
    }

    static void add(TreeMap<Integer, Integer> map, int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
    }

    static void remove(TreeMap<Integer, Integer> map, int val) {
        if (map.get(val) == 1)
            map.remove(val);
        else
            map.put(val, map.get(val) - 1);
    }
}
