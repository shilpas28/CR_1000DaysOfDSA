//Leetcode
//1335. Minimum Difficulty of a Job Schedule - Memoization/Top Down
//Time complexity: O((n^2)*d)
//Space complexity: O(nd) 

package Leetcode;

public class MinimumDifficultyOfAJobSchedule_2 {

    public static void main(String[] args) {
        int[] jobDifficulty = { 6, 5, 4, 3, 2, 1 };
        int d = 2;
        System.out.println(minDifficulty(jobDifficulty, d));
    }

    static Integer[][] memo;
    static int[] maxSoFar;

    public static int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty == null || jobDifficulty.length < d || d <= 0) {
            return -1;
        }
        int n = jobDifficulty.length;
        memo = new Integer[d + 1][n];

        maxSoFar = new int[n];
        maxSoFar[0] = jobDifficulty[0];
        for (int i = 1; i < n; i++) {
            maxSoFar[i] = Math.max(maxSoFar[i - 1], jobDifficulty[i]);
        }

        return dfs(jobDifficulty, d, n - 1);
    }

    // return min difficulty if dividing A[0..j] to i days
    static int dfs(int[] A, int i, int j) {
        if (i > j + 1) { // more days than tasks
            return -1;
        } else if (i == 1) {
            return maxSoFar[j];
        } else if (memo[i][j] != null) {
            return memo[i][j];
        }

        memo[i][j] = Integer.MAX_VALUE;

        int maxK2J = A[j]; // max(A[k+1..j])
        for (int k = j - 1; k >= i - 2; k--) { // assume second last subarray ends at A[k]
            maxK2J = Math.max(maxK2J, A[k + 1]);
            memo[i][j] = Math.min(memo[i][j], maxK2J + dfs(A, i - 1, k));
        }
        return memo[i][j];
    }
}
