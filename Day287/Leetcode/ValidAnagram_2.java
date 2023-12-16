//Leetcode
//242. Valid Anagram - Hash Table
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram_2 {

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {

        Map<Character, Integer> count = new HashMap<>();
        // Count the frequency of characters in string s
        for (char x : s.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        // Decrement the frequency of characters in string t
        for (char x : t.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) - 1);
        }
        // Check if any character has non-zero frequency
        for (int val : count.values()) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
}
