//GFG
//Job Sequencing Problem
//Time complexity: O(NlogN)
//Space complexity: O(N)

package GFG;

import java.util.Arrays;
import java.util.Comparator;

public class JobSequencingProblem {

    static class Job {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    static class jobComparator implements Comparator<Job> {
        public int compare(Job j1, Job j2) {
            return j2.profit - j1.profit;
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
        Arrays.sort(arr, new jobComparator());
        int res = 0;
        int tot_job = 0;
        boolean[] slot = new boolean[n]; // track of free time slots. - all false now

        // itr for all jobs.
        for (int i = 0; i < n; i++) {
            // linear search [deadline to 0] - explained in dry run
            for (int j = arr[i].deadline - 1; j >= 0; j--) {
                // if free slot found - add the profits, tot_job++, mark slot filled
                if (slot[j] == false) {
                    res += arr[i].profit;
                    tot_job++;
                    slot[j] = true;
                    break;
                }
            }
        }
        int ans[] = { tot_job, res };
        return ans;
    }
}
