//Leetcode
//409. Longest Palindrome
//Time complexity: O(N) where n is the length of the string s. This is because we are iterating through the string only once.
//Space complexity: O(m) where m is the number of unique characters in the string. This is because we are using an 
//unordered map to store the count of each character.

package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }

    public static int longestPalindrome(String s) {
        int oddCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.get(ch) % 2 == 1)
                oddCount++;
            else
                oddCount--;
        }
        if (oddCount > 1)
            return s.length() - oddCount + 1;
        return s.length();
    }
}
