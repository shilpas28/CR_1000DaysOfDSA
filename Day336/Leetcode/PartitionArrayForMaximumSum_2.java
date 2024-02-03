//Leetcode
//1043. Partition Array for Maximum Sum - Memoization/Top down
//Time complexity: O(NK)
//Space complexity: O(N)

package Leetcode;

public class PartitionArrayForMaximumSum_2 {

    public static void main(String[] args) {
        int[] arr = { 1, 15, 7, 9, 2, 5, 10 };
        int k = 3;
        System.out.println(maxSumAfterPartitioning(arr, k));
    }

    public static int maxSumAfterPartitioning(int[] arr, int k) {
        Integer[] memo = new Integer[arr.length];
        return maxSumAfterPartitioning(arr, k, 0, memo);
    }

    static int maxSumAfterPartitioning(int[] arr, int k, int i, Integer[] memo) {
        if (i == arr.length) {
            return 0;
        }
        if (memo[i] != null) {
            return memo[i];
        }

        int currMax = 0;
        int sumMax = 0;
        for (int j = 0; j < k; j++) {
            int to = i + j;
            if (to >= arr.length) {
                break;
            }
            currMax = Math.max(currMax, arr[to]);
            sumMax = Math.max(sumMax, (currMax * (j + 1)) + maxSumAfterPartitioning(arr, k, to + 1, memo));
        }
        return memo[i] = sumMax;
    }
}
