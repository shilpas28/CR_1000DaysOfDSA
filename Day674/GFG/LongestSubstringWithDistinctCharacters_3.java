//GFG
//Longest substring with distinct characters - Optimised  Approach 2 - Correct solution but GFG is not allowing HashSet
//Time complexity: O(N)
//Space complexity: O(N) where N represents the size of HashSet where we are storing our elements

import java.util.HashMap;

public class LongestSubstringWithDistinctCharacters_3 {

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(longestUniqueSubstr(s));
    }

    public static int longestUniqueSubstr(String s) {
        // code here
        HashMap<Character, Integer> mpp = new HashMap<Character, Integer>();
        int left = 0, right = 0;
        int n = s.length();
        int len = 0;
        while (right < n) {
            if (mpp.containsKey(s.charAt(right)))
                left = Math.max(mpp.get(s.charAt(right)) + 1, left);

            mpp.put(s.charAt(right), right);

            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }
}
