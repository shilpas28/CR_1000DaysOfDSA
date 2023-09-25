//Leetcode
//389. Find the Difference
//Time complexity:O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.HashMap;

public class FindTheDifference {

    public static void main(String[] args) {
        String s = "abcd", t = "abcde";
        System.out.println(findTheDifference(s, t));
    }

    public static char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (map.containsKey(c) && map.get(c) == 0 || !map.containsKey(c))
                return c;
            else
                map.put(c, map.get(c) - 1);
        }
        return '!';
    }
}
