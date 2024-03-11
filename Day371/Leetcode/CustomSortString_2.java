//Leetcode
//791. Custom Sort String
//Time complexity: O(n), where n is the length of string s. We iterate through the characters once.
//Space complexity: O(n), where n is the length of string s. The space is used to store the character count in the map.

package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class CustomSortString_2 {

    public static void main(String[] args) {
        String order = "cba", s = "abcd";
        System.out.println(customSortString(order, s));
    }

    public static String customSortString(String order, String s) {
        // Step 1: Initialize character count map
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        // Step 2: Build result string based on the specified order
        StringBuilder result = new StringBuilder();
        for (char c : order.toCharArray()) {
            if (charCount.containsKey(c)) {
                int count = charCount.get(c);
                while (count > 0) {
                    result.append(c);
                    count--;
                }
                charCount.remove(c); // Remove processed character to avoid duplication
            }
        }
        // Step 3: Append remaining characters not present in the specified order
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            while (count > 0) {
                result.append(c);
                count--;
            }
        }
        // Step 4: Return the final result as a string
        return result.toString();
    }
}
