//GFG
//Longest substring with distinct characters - Brute force Approach - Correct solution but GFG is not allowing HashSet
//Time complexity: O(N^2)
//Space complexity: O(N) where N is the size of HashSet taken for storing the elements

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithDistinctCharacters {

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(longestUniqueSubstr(s));
    }

    public static int longestUniqueSubstr(String s) {
        // code here
        if (s.length() == 0)
            return 0;
        int maxans = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) // outer loop for traversing the string
        {
            Set<Character> se = new HashSet<>();
            for (int j = i; j < s.length(); j++) // nested loop for getting different string starting with str[i]
            {
                if (se.contains(s.charAt(j))) // if element if found so mark it as ans and break from the loop
                {
                    maxans = Math.max(maxans, j - i);
                    break;
                }
                se.add(s.charAt(j));
            }
        }
        return maxans;
    }
}
