//GFG
//Job Sequencing Problem
//Time complexity: O(N log N) (due to sorting)
//Space complexity: O(N) (for job scheduling)

package GFG;

import java.util.ArrayList;
import java.util.Arrays;

public class JobSequencingProblem {

    public static void main(String[] args) {
        int deadline[] = { 4, 1, 1, 1 };
        int profit[] = { 20, 10, 40, 30 };
        System.out.println(jobSequencing(deadline, profit));
    }

    // Custom class to store job details
    static class Job {
        int deadline, profit;

        Job(int deadline, int profit) {
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n = deadline.length;
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(deadline[i], profit[i]);
        }

        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        boolean[] slot = new boolean[maxDeadline + 1];

        int maxProfit = 0, countJobs = 0;

        for (Job job : jobs) {
            for (int j = job.deadline; j > 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    maxProfit += job.profit;
                    countJobs++;
                    break;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(countJobs);
        result.add(maxProfit);
        return result;
    }
}
