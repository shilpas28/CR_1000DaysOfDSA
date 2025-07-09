//Leetcode
//3439. Reschedule Meetings for Maximum Free Time I - Greedy + Sliding Window 
//Time complexity: O(N)
//Space complexity: O(1)

public class RescheduleMeetingsForMaximumFreeTimeI_3 {

    public static void main(String[] args) {
        int eventTime = 5, k = 1;
        int[] startTime = { 1, 3 };
        int[] endTime = { 2, 5 };
        System.out.println(maxFreeTime(eventTime, k, startTime, endTime));
    }

    public static int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int res = 0;
        int t = 0;
        for (int i = 0; i < n; i++) {
            t += endTime[i] - startTime[i];
            int left = i <= k - 1 ? 0 : endTime[i - k];
            int right = i == n - 1 ? eventTime : startTime[i + 1];
            res = Math.max(res, right - left - t);
            if (i >= k - 1) {
                t -= endTime[i - k + 1] - startTime[i - k + 1];
            }
        }
        return res;
    }
}
