//GFG
//Substrings with same first and last characters
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

import java.util.HashMap;

public class SubstringsWithSameFirstAndLastCharacters {

    public static void main(String[] args) {
        String s = "abcab";
        System.out.println(countSubstring(s));
    }

    public static int countSubstring(String s) {
        // code here
        int n = s.length();
        int count = 0;
        HashMap<Character, Integer> ans = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            ans.put(ch, ans.getOrDefault(ch, 0) + 1);
            count += ans.get(ch);
        }
        return count;
    }
}
