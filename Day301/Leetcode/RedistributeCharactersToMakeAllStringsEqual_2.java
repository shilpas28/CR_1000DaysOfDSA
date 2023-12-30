//Leetcode
//1897. Redistribute Characters to Make All Strings Equal
//Time complexity: O(n).k
//Space complexity: O(1)

package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class RedistributeCharactersToMakeAllStringsEqual_2 {

    public static void main(String[] args) {
        String[] words = { "abc", "aabc", "bc" };
        System.out.println(makeEqual(words));
    }

    public static boolean makeEqual(String[] words) {

        Map<Character, Integer> counts = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                counts.put(c, counts.getOrDefault(c, 0) + 1);
            }
        }
        int n = words.length;
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            if (entry.getValue() % n != 0) {
                return false;
            }
        }
        return true;
    }
}
