//GFG - using Tabulation
//Maximum subset sum
//Time complexity:O(N)
//Space complexity: O(N)

public class MaximumSubsetSum_2 {
    public static void main(String[] args) {
        int N = 4;
        int A[] = { 1, -1, 3, 4 };
        System.out.println(findMaxSubsetSum(N, A));
    }

    public static long findMaxSubsetSum(int N, int[] A) {
        // code here
        long[][] dp = new long[N + 1][2];
        dp[N][0] = 0;
        dp[N][1] = 0;
        for (int i = N - 1; i >= 0; i--) {
            dp[i][0] = dp[i + 1][1];
            dp[i][1] = A[i] + Math.max(dp[i + 1][0], dp[i + 1][1]);
        }
        return Math.max(dp[0][0], dp[0][1]);
    }
}
