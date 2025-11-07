//GFG
//Weighted Job Scheduling
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.Arrays;

public class WeightedJobScheduling_2 {

    public static void main(String[] args) {
        int jobs[][] = { { 1, 2, 50 },
                { 3, 5, 20 },
                { 6, 19, 100 },
                { 2, 100, 200 } };
        System.out.println(maxProfit(jobs));
    }

    public static int maxProfit(int[][] jobs) {
        // code here
        int n = jobs.length;
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        int[] dp = new int[n];
        dp[0] = jobs[0][2];
        for (int i = 1; i < n; i++) {
            int profitExcludingCurrent = dp[i - 1];
            int profitIncludingCurrent = jobs[i][2];
            int lastNonOverlappingJobIndex = findLastNonOverlappingJob(jobs, i);
            if (lastNonOverlappingJobIndex != -1) {
                profitIncludingCurrent += dp[lastNonOverlappingJobIndex];
            }
            dp[i] = Math.max(profitExcludingCurrent, profitIncludingCurrent);
        }
        return dp[n - 1];
    }

    static int findLastNonOverlappingJob(int[][] jobs, int currentIndex) {
        int low = 0, high = currentIndex - 1;
        int currentStartTime = jobs[currentIndex][0];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (jobs[mid][1] <= currentStartTime) {
                if (jobs[mid + 1][1] <= currentStartTime) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
