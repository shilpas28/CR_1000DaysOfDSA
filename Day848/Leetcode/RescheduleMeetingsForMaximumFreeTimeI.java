//Leetcode
//3439. Reschedule Meetings for Maximum Free Time I - Sort + Sliding Window + Greedy
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RescheduleMeetingsForMaximumFreeTimeI {

    public static void main(String[] args) {
        int eventTime = 5, k = 1;
        int[] startTime = { 1, 3 };
        int[] endTime = { 2, 5 };
        System.out.println(maxFreeTime(eventTime, k, startTime, endTime));
    }

    public static int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        // 1. Combine and Sort Meetings:
        List<int[]> meetings = new ArrayList<>();
        for (int i = 0; i < startTime.length; i++) {
            meetings.add(new int[] { startTime[i], endTime[i] });
        }
        Collections.sort(meetings, (a, b) -> a[0] - b[0]);
        // 2. Add Boundary Meetings:
        meetings.add(0, new int[] { -1, 0 });
        meetings.add(new int[] { eventTime, eventTime + 1 });
        int n = meetings.size();
        // 3. Calculate Free Time Intervals:
        List<Integer> freeTime = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            freeTime.add(meetings.get(i)[0] - meetings.get(i - 1)[1]);
        }
        // 4. Handle Edge Case
        if (k + 1 > freeTime.size()) {
            int totalFreeTime = 0;
            for (int ft : freeTime) {
                totalFreeTime += ft;
            }
            return totalFreeTime;
        }
        // 5. Calculate Initial Window Sum:
        int windowSum = 0;
        for (int i = 0; i < k + 1; i++) {
            windowSum += freeTime.get(i);
        }
        int maxFreeTime = windowSum;
        // 6. Sliding Window:
        for (int i = k + 1; i < freeTime.size(); i++) {
            windowSum += freeTime.get(i) - freeTime.get(i - (k + 1));
            maxFreeTime = Math.max(maxFreeTime, windowSum);
        }
        return maxFreeTime;
    }
}
