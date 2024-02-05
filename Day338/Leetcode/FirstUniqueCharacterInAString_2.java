//Leetcode
//387. First Unique Character in a String
//Time complexity: O(n)
//Space complexity: O(U) - (U is the number of unique characters in the string.)

package Leetcode;

import java.util.HashMap;

public class FirstUniqueCharacterInAString_2 {

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();

        for (char a : s.toCharArray()) {
            mp.put(a, mp.getOrDefault(a, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (mp.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
