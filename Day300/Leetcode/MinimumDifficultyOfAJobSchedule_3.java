//Leetcode
//1335. Minimum Difficulty of a Job Schedule - Tabulation/Bottom-up 
//Time complexity: O((n^2)*d)
//Space complexity: O(nd)   

package Leetcode;

public class MinimumDifficultyOfAJobSchedule_3 {

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
        int[][] dp = new int[d + 1][n];

        // initialization
        dp[1][0] = jobDifficulty[0];
        for (int i = 1; i < n; i++) {
            dp[1][i] = Math.max(dp[1][i - 1], jobDifficulty[i]);
        }

        for (int i = 2; i <= d; i++) {
            for (int j = i - 1; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;

                int lastMax = jobDifficulty[j]; // last subarray's max difficulty
                for (int k = j - 1; k >= i - 2; k--) { // assume second last subarray ends at A[k]
                    lastMax = Math.max(lastMax, jobDifficulty[k + 1]); // max(A[k+1..j])
                    dp[i][j] = Math.min(dp[i][j], lastMax + dp[i - 1][k]);
                }
            }
        }
        return dp[d][n - 1];
    }
}
