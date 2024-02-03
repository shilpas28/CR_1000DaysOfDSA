//Leetcode
//1043. Partition Array for Maximum Sum - Tabulation/Bottom up
//Time complexity: O(NK)
//Space complexity: O(N)

package Leetcode;

public class PartitionArrayForMaximumSum_3 {

    public static void main(String[] args) {
        int[] arr = { 1, 15, 7, 9, 2, 5, 10 };
        int k = 3;
        System.out.println(maxSumAfterPartitioning(arr, k));
    }

    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        for (int to = 0; to < arr.length; to++) {
            int currMax = 0;
            for (int j = 0; j < k; j++) {
                int from = to - j;
                if (from < 0) {
                    continue;
                }
                currMax = Math.max(currMax, arr[from]);
                int newSplitVal = (currMax * (j + 1)) + getVal(dp, from - 1);
                dp[to] = Math.max(dp[to], newSplitVal);
            }
        }
        return dp[arr.length - 1];
    }

    static int getVal(int[] dp, int i) {
        if (i < 0) {
            return 0;
        }
        return dp[i];
    }
}
