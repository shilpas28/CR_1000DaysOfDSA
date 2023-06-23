//Leetcode
//1027. Longest Arithmetic Subsequence
//Time complexity: O(N^2)
//Space complexity: O(N^2)

package Leetcode;

import java.util.HashMap;

public class LongestArithmeticSubsequence {

    public static void main(String[] args) {
        int[] nums = { 3, 6, 9, 12 };
        System.out.println(longestArithSeqLength(nums));
    }

    public static int longestArithSeqLength(int[] nums) {
        int len = nums.length;
        HashMap<Integer, Integer>[] dp = new HashMap[len];
        int maxValue = 1;
        for (int i = 0; i < len; i++) {
            int currentElement = nums[i];
            dp[i] = new HashMap<>();
            HashMap<Integer, Integer> currentMap = dp[i];
            // Empty hashmap of the current element that we are going to construct now
            for (int j = 0; j < i; j++) {
                int difference = currentElement - nums[j];
                HashMap<Integer, Integer> prevMap = dp[j];
                int newValue = prevMap.getOrDefault(difference, 0) + 1;
                currentMap.put(difference, newValue);
                dp[i] = currentMap;
                maxValue = Math.max(maxValue, currentMap.get(difference));
            }
        }
        return maxValue + 1;
    }
}
