//Leetcode
//3169. Count Days Without Meetings - Sorting
//Time complexity: O(NlogN)
//Space complexity: O(logN) or O(N)

import java.util.Arrays;
import java.util.Comparator;

public class CountDaysWithoutMeetings_2 {

    public static void main(String[] args) {
        int days = 10;
        int[][] meetings = { { 5, 7 }, { 1, 3 }, { 9, 10 } };
        System.out.println(countDays(days, meetings));
    }

    public static int countDays(int days, int[][] meetings) {
        int freeDays = 0, latestEnd = 0;
        // Sort meetings based on starting times
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            // Add current range of days without a meeting
            if (start > latestEnd + 1) {
                freeDays += start - latestEnd - 1;
            }
            // Update latest meeting end
            latestEnd = Math.max(latestEnd, end);
        }
        // Add all days after the last day of meetings
        freeDays += days - latestEnd;

        return freeDays;
    }
}
