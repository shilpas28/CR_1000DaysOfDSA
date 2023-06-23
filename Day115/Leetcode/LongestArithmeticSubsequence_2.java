//Leetcode
//1027. Longest Arithmetic Subsequence
//Time complexity: O(N^2)
//Space complexity: O(N^2)

package Leetcode;

import java.util.HashMap;

public class LongestArithmeticSubsequence_2 {

    public static void main(String[] args) {
        int[] nums = { 3, 6, 9, 12 };
        System.out.println(longestArithSeqLength(nums));
    }

    public static int longestArithSeqLength(int[] nums) {
        int res = 2, n = nums.length;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for (int j = 0; j < nums.length; j++) {
            dp[j] = new HashMap<>();
            for (int i = 0; i < j; i++) {
                int d = nums[j] - nums[i];
                dp[j].put(d, dp[i].getOrDefault(d, 1) + 1);
                res = Math.max(res, dp[j].get(d));
            }
        }
        return res;
    }
}
