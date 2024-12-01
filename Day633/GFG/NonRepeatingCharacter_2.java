//GFG
//Non Repeating Character
//Time complexity: O(N)
//Space complexity: O(Number of distinct characters)

package GFG;

import java.util.HashMap;

public class NonRepeatingCharacter_2 {

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(nonRepeatingChar(s));
    }

    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        // Your code here
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        for (int i = 0; i < s.length(); i++)
            if (map.get(s.charAt(i)) == 1)
                return s.charAt(i);
        return '$';
    }
}
