//Leetcode
//1218. Longest Arithmetic Subsequence of Given Difference
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequenceOfGivenDifference {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        int difference = 1;
        System.out.println(longestSubsequence(arr, difference));
    }

    public static int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int ans = 1;
        for (int i : arr) {
            int prev = map.getOrDefault(i - difference, 0);
            map.put(i, prev + 1);
            ans = Math.max(ans, prev + 1);
        }
        return ans;
    }
}
