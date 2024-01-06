//Leetcode
//1235. Maximum Profit in Job Scheduling - Top Down/Memoization
//Time complexity: O(n^2)
//Space complexity: O(n)

package Leetcode;

import java.util.Arrays;

public class MaximumProfitInJobScheduling_2 {

    static class Job {
        public int start, end, profit;

        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        int[] startTime = { 1, 2, 3, 3 };
        int[] endTime = { 3, 4, 5, 6 };
        int[] profit = { 50, 10, 40, 70 };
        System.out.println(jobScheduling(startTime, endTime, profit));
    }

    static int[] table;

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        table = new int[n];
        Arrays.fill(table, -1);

        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, (j1, j2) -> {
            return Integer.compare(j1.start, j2.start);
        });

        return recursiveUtil(jobs, 0, n);
    }

    static int recursiveUtil(Job[] jobs, int index, int n) {
        if (index >= n)
            return 0;

        if (table[index] != -1)
            return table[index];

        int include = jobs[index].profit;
        int gncj = findIndexOfNonConflictingJob(jobs, index, n);
        if (gncj != -1)
            include += recursiveUtil(jobs, gncj, n);
        int exclude = recursiveUtil(jobs, index + 1, n);

        return table[index] = Math.max(include, exclude);
    }

    static int findIndexOfNonConflictingJob(Job[] jobs, int index, int n) {
        for (int i = index + 1; i < n; i++) {
            if (jobs[i].start >= jobs[index].end) {
                return i;
            }
        }
        return -1;
    }
}
