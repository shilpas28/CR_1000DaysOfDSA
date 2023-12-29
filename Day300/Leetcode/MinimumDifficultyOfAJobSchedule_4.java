//Leetcode
//1335. Minimum Difficulty of a Job Schedule - Space optimization
//Time complexity: O((n^2)*d)
//Space complexity: O(n)  

package Leetcode;

public class MinimumDifficultyOfAJobSchedule_4 {

    public static void main(String[] args) {
        int[] jobDifficulty = { 6, 5, 4, 3, 2, 1 };
        int d = 2;
        System.out.println(minDifficulty(jobDifficulty, d));
    }

    public static int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty == null || jobDifficulty.length < d || d <= 0) {
            return -1;
        }
        int n = jobDifficulty.length;
        int[] dp = new int[n];

        // initialization for d = 1
        dp[0] = jobDifficulty[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], jobDifficulty[i]);
        }

        for (int i = 2; i <= d; i++) {
            for (int j = n - 1; j >= i - 1; j--) { // space optimization requires this
                dp[j] = Integer.MAX_VALUE;

                int lastMax = jobDifficulty[j]; // last subarray's max difficulty
                for (int k = j - 1; k >= i - 2; k--) { // assume second last subarray ends at A[k]
                    lastMax = Math.max(lastMax, jobDifficulty[k + 1]); // max(A[k+1..j])
                    dp[j] = Math.min(dp[j], lastMax + dp[k]);
                }
            }
        }
        return dp[n - 1];
    }
}
