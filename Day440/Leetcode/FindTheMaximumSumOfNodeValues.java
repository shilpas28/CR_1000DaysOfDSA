//Leetcode
//3068. Find the Maximum Sum of Node Values - Calculating deltas and sorting
//Time complexity: O(nlogn), we use sorting which is use nlogn time in most languages
//Space complexity: O(n) since we creating array deltas of size n

package Leetcode;

import java.util.Arrays;

public class FindTheMaximumSumOfNodeValues {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1 };
        int k = 3;
        int[][] edges = { { 0, 1 }, { 0, 2 } };
        System.out.println(maximumValueSum(nums, k, edges));
    }

    public static long maximumValueSum(int[] nums, int k, int[][] edges) {

        int n = nums.length;
        long[] deltas = new long[n]; // represents how will change number after XOR
        for (int i = 0; i < n; i++) {
            deltas[i] = (nums[i] ^ k) - nums[i];
        }
        Arrays.sort(deltas);
        for (int i = 0; i < n / 2; i++) {
            long temp = deltas[i];
            deltas[i] = deltas[n - i - 1];
            deltas[n - i - 1] = temp;
        }

        long res = 0;
        for (int num : nums) {
            res += num;
        }

        for (int startInd = 0; startInd < n - 1; startInd += 2) {
            long changingDelta = deltas[startInd] + deltas[startInd + 1]; // showing whether if would be beneficial if
                                                                          // we XOR this two nodes
            if (changingDelta > 0) {
                res += changingDelta;
            } else {
                break;
            }
        }
        return res;
    }
}
