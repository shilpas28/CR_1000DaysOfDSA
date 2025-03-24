//Leetcode
//3169. Count Days Without Meetings - Line Sweep 
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.Map;
import java.util.TreeMap;

public class CountDaysWithoutMeetings {

    public static void main(String[] args) {
        int days = 10;
        int[][] meetings = { { 5, 7 }, { 1, 3 }, { 9, 10 } };
        System.out.println(countDays(days, meetings));
    }

    public static int countDays(int days, int[][] meetings) {
        TreeMap<Integer, Integer> dayMap = new TreeMap<>();
        int prefixSum = 0, freeDays = 0, previousDay = days;

        for (int[] meeting : meetings) {
            // Set first day of meetings
            previousDay = Math.min(previousDay, meeting[0]);
            // Process start and end of meeting
            dayMap.put(meeting[0], dayMap.getOrDefault(meeting[0], 0) + 1);
            dayMap.put(
                    meeting[1] + 1,
                    dayMap.getOrDefault(meeting[1] + 1, 0) - 1);
        }
        // Add all days before the first day of meetings
        freeDays += (previousDay - 1);
        for (Map.Entry<Integer, Integer> day : dayMap.entrySet()) {
            int currentDay = day.getKey();
            // Add current range of days without a meeting
            if (prefixSum == 0) {
                freeDays += (currentDay - previousDay);
            }
            prefixSum += day.getValue();
            previousDay = currentDay;
        }
        // Add all days after the last day of meetings
        freeDays += days - previousDay + 1;
        return freeDays;
    }
}
