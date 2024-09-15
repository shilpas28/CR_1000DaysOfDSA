//Leetcode
//1371. Find the Longest Substring Containing Vowels in Even Counts
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

import java.util.HashMap;

public class FindTheLongestSubstringContainingVowelsInEvenCounts_2 {

    public static void main(String[] args) {
        String s = "eleetminicoworoep";
        System.out.println(findTheLongestSubstring(s));
    }

    public static int findTheLongestSubstring(String s) {
        int n = s.length();
        int mask = 0;
        int maxLength = 0;
        HashMap<Integer, Integer> m = new HashMap<>();
        m.put(0, -1);

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'a')
                mask ^= (1 << 0);
            else if (c == 'e')
                mask ^= (1 << 1);
            else if (c == 'i')
                mask ^= (1 << 2);
            else if (c == 'o')
                mask ^= (1 << 3);
            else if (c == 'u')
                mask ^= (1 << 4);

            if (m.containsKey(mask)) {
                maxLength = Math.max(maxLength, i - m.get(mask));
            } else {
                m.put(mask, i);
            }
        }
        return maxLength;
    }
}
