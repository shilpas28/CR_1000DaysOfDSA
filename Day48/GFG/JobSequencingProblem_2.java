//GFG
//Job Sequencing Problem
//Time complexity: O(NlogN)
//Space complexity: O(N)

package GFG;

import java.util.Arrays;

public class JobSequencingProblem_2 {
    static class Job {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    public static void main(String[] args) {
        int N = 4;
        Job job1 = new Job(1,4,20);
        Job job2 = new Job(2,1,10);
        Job job3 = new Job(3,1,40);
        Job job4 = new Job(4,1,30);
        Job arr[] = {job1, job2, job3, job4};
        System.out.println(Arrays.toString(JobScheduling(arr, N)));
    }

    static int[] JobScheduling(Job arr[], int n) {
        // Your code here
        boolean[] jobsDone = new boolean[n];
        Arrays.fill(jobsDone, false);
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        int cnt = 0, profit = 0;
        for (Job job : arr) {
            for (int i = Math.min(job.deadline - 1, n - 1); i >= 0; i--) {
                if (!jobsDone[i]) {
                    cnt++;
                    profit += job.profit;
                    jobsDone[i] = true;
                    break;
                }
            }
        }
        return new int[]{cnt, profit};
    }
}
