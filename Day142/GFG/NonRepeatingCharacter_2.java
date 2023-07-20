//GFG
//Non Repeating Character - Using hashmap
//Time complexity: O(N)
//Space complexity: O(Number of distinct characters)

package GFG;

import java.util.HashMap;

public class NonRepeatingCharacter_2 {

    public static void main(String[] args) {
        String S = "hello";
        System.out.println(nonrepeatingCharacter(S));
    }

    // Function to find the first non-repeating character in a string.
    static char nonrepeatingCharacter(String S) {
        // Your code here
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++)
            map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0) + 1);
        for (int i = 0; i < S.length(); i++)
            if (map.get(S.charAt(i)) == 1)
                return S.charAt(i);
        return '$';
    }
}
