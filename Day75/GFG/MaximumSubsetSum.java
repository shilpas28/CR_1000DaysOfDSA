//GFG - using Memoization
//Maximum subset sum
//Time complexity:O(N)
//Space complexity: O(N)

public class MaximumSubsetSum {

    public static void main(String[] args) {
        int N = 4;
        int A[] = { 1, -1, 3, 4 };
        System.out.println(findMaxSubsetSum(N, A));
    }

    public static long findMaxSubsetSum(int N, int[] A) {
        // code here
        Long[][] dp = new Long[N + 1][2];
        return solve(0, 1, A, dp);
    }

    public static long solve(int i, int prevTaken, int[] arr, Long[][] dp) {

        if (i == arr.length)
            return dp[i][prevTaken] = 0L;
        // memoization
        if (dp[i][prevTaken] != null)
            return dp[i][prevTaken];
        if (prevTaken == 0) {
            return dp[i][prevTaken] = solve(i + 1, 1, arr, dp) + arr[i];
        } else {
            return dp[i][prevTaken] = Math.max(solve(i + 1, 1, arr, dp) + arr[i], solve(i + 1, 0, arr, dp));
        }
    }
}
