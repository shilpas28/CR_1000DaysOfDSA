//Leetcode
//205. Isomorphic Strings - Using Hashmap
//Time complexity: O(length(s) + length(t))
//Space complexity: O(number of different characters)

package Leetcode;

import java.util.HashMap;

public class IsomorphicStrings {

    public static void main(String[] args) {
        String s = "egg", t = "add";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();

        if (s.length() != t.length())
            return false;

        for (int i = 0; i < s.length(); i++) {
            char p1 = s.charAt(i);
            char p2 = t.charAt(i);
            if (map.containsKey(p1)) {
                if (map.get(p1) != p2)
                    return false;
            } else if (map.containsValue(p2))
                return false;
            else
                map.put(p1, p2);
        }
        return true;
    }
}
