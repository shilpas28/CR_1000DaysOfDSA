//Leetcode
//1335. Minimum Difficulty of a Job Schedule - Recursive solution - Not accepted as TLE 
//Time complexity: O(2^n)
//Space complexity: O(n) 

package Leetcode;

public class MinimumDifficultyOfAJobSchedule {

    public static void main(String[] args) {
        int[] jobDifficulty = { 6, 5, 4, 3, 2, 1 };
        int d = 2;
        System.out.println(minDifficulty(jobDifficulty, d));
    }

    public static int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) {
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < jobDifficulty.length; i++) {
            sum += jobDifficulty[i];
        }
        if (sum == 0) {
            return 0;
        }
        return helper(jobDifficulty, d, 0);
    }

    static int helper(int[] jd, int daysLeft, int idx) {
        int len = jd.length;
        if (daysLeft == 1) {
            int num = 0;
            for (int i = idx; i < len; i++) {
                num = Math.max(num, jd[i]);
            }
            return num;
        }

        int max = jd[idx];
        daysLeft--;
        int stop = len - idx - daysLeft + 1;

        int res = Integer.MAX_VALUE;
        for (int i = 1; i < stop; i++) {
            max = Math.max(max, jd[idx + i - 1]);
            int other = helper(jd, daysLeft, idx + i);
            res = Math.min(res, other + max);
        }
        return res;
    }
}
