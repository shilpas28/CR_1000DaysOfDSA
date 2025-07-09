//Leetcode
//3439. Reschedule Meetings for Maximum Free Time I - Greedy + Prefix Sum
//Time complexity: O(N)
//Space complexity: O(N)

public class RescheduleMeetingsForMaximumFreeTimeI_2 {

    public static void main(String[] args) {
        int eventTime = 5, k = 1;
        int[] startTime = { 1, 3 };
        int[] endTime = { 2, 5 };
        System.out.println(maxFreeTime(eventTime, k, startTime, endTime));
    }

    public static int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int res = 0;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + endTime[i] - startTime[i];
        }
        for (int i = k - 1; i < n; i++) {
            int right = i == n - 1 ? eventTime : startTime[i + 1];
            int left = i == k - 1 ? 0 : endTime[i - k];
            res = Math.max(res, right - left - (sum[i + 1] - sum[i - k + 1]));
        }
        return res;
    }
}
