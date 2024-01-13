//Leetcode
//1347. Minimum Number of Steps to Make Two Strings Anagram
//Time complexity: O(n+m) - where n and m are the lengths of strings s and t
//Space complexity: O(c) - where c is the number of unique characters in the input strings

package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfStepsToMakeTwoStringsAnagram {

    public static void main(String[] args) {
        String s = "leetcode", t = "practice";
        System.out.println(minSteps(s, t));
    }

    public static int minSteps(String s, String t) {
        Map<Character, Integer> smp = new HashMap<>();
        Map<Character, Integer> tmp = new HashMap<>();
        int cnt = 0;

        for (char a : s.toCharArray()) {
            smp.put(a, smp.getOrDefault(a, 0) + 1);
        }

        for (char a : t.toCharArray()) {
            tmp.put(a, tmp.getOrDefault(a, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : smp.entrySet()) {
            char key = entry.getKey();
            if (tmp.containsKey(key)) {
                if (entry.getValue().equals(tmp.get(key))) {
                    cnt += entry.getValue();
                } else {
                    cnt += Math.min(entry.getValue(), tmp.get(key));
                }
            }
        }

        return s.length() - cnt;
    }
}
