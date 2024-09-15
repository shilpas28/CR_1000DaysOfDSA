//Leetcode
//1371. Find the Longest Substring Containing Vowels in Even Counts
//Time complexity: O(N)
//Space complexity: O(2 ^ m), where m is the number of characters we need to track counts for

package Leetcode;

import java.util.Arrays;

public class FindTheLongestSubstringContainingVowelsInEvenCounts {

    public static void main(String[] args) {
        String s = "eleetminicoworoep";
        System.out.println(findTheLongestSubstring(s));
    }

    static char[] c_m = { 1, 0, 0, 0, 2, 0, 0, 0, 4, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 16, 0, 0, 0, 0, 0 };

    public static int findTheLongestSubstring(String s) {
        int mask = 0, res = 0;
        int[] m = new int[32];
        Arrays.fill(m, -1);
        for (int i = 0; i < s.length(); ++i) {
            mask ^= c_m[s.charAt(i) - 'a'];
            if (mask != 0 && m[mask] == -1)
                m[mask] = i;
            res = Math.max(res, i - m[mask]);
        }
        return res;
    }
}
