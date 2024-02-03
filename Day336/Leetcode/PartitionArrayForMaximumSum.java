//Leetcode - Not accepted as TLE 
//1043. Partition Array for Maximum Sum - Recursion 
//Time complexity:
//Space complexity: 

package Leetcode;

public class PartitionArrayForMaximumSum {

    public static void main(String[] args) {
        int[] arr = { 1, 15, 7, 9, 2, 5, 10 };
        int k = 3;
        System.out.println(maxSumAfterPartitioning(arr, k));
    }

    public static int maxSumAfterPartitioning(int[] arr, int k) {
        return maxSumAfterPartitioning(arr, k, 0);
    }

    static int maxSumAfterPartitioning(int[] arr, int k, int i) {
        if (i == arr.length) {
            return 0;
        }
        int currMax = 0;
        int sumMax = 0;
        for (int j = 0; j < k; j++) { // k decision to partition the array
            int to = i + j;
            if (to >= arr.length) { // stop partition when we we reach end of the array
                break;
            }
            currMax = Math.max(currMax, arr[to]); // Running maximum of left partition array
            int leftPartionSum = currMax * (j + 1); // sum of left partition
            int rightPartionMaxSum = maxSumAfterPartitioning(arr, k, to + 1); // Max Sum of right partition - Sub
                                                                              // problem
            sumMax = Math.max(sumMax, leftPartionSum + rightPartionMaxSum); // Since problem asks for largest sum, we
                                                                            // track the largest sum of k decisions we
                                                                            // are making in this loop.
        }
        return sumMax;
    }
}
