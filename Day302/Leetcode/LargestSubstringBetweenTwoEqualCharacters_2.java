//Leetcode
//1624. Largest Substring Between Two Equal Characters - With Maps
//Time complexity: O(n)
//Space complexity: O(1)

package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class LargestSubstringBetweenTwoEqualCharacters_2 {

    public static void main(String[] args) {
        String s = "abca";
        System.out.println(maxLengthBetweenEqualCharacters(s));
    }

    public static int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> firstIndex = new HashMap<>();
        int ans = -1;
        for (int i = 0; i < s.length(); i++) {
            if (firstIndex.containsKey(s.charAt(i))) {
                ans = Math.max(ans, i - firstIndex.get(s.charAt(i)) - 1);
            } else {
                firstIndex.put(s.charAt(i), i);
            }
        }
        return ans;
    }
}
