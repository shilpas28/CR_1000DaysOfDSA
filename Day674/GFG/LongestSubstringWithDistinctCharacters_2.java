//GFG
//Longest substring with distinct characters - Optimised  Approach 1 - Correct solution but GFG is not allowing HashSet
//Time complexity: O(2*N) (sometimes left and right both have to travel complete array)
//Space complexity: O(N) where N is the size of HashSet taken for storing the elements

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithDistinctCharacters_2 {

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(longestUniqueSubstr(s));
    }

    public static int longestUniqueSubstr(String s) {
        // code here
        if (s.length() == 0)
            return 0;
        int maxans = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        int l = 0;
        for (int r = 0; r < s.length(); r++) // outer loop for traversing the string
        {
            if (set.contains(s.charAt(r))) // if duplicate element is found
            {
                while (l < r && set.contains(s.charAt(r))) {
                    set.remove(s.charAt(l));
                    l++;
                }
            }
            set.add(s.charAt(r));
            maxans = Math.max(maxans, r - l + 1);
        }
        return maxans;
    }
}
