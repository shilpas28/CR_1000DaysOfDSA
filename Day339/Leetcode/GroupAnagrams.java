//Leetcode
//49. Group Anagrams
//Time complexity: O(n∗k) where K is the length of the longest string
//Space complexity: O(n∗k) where K is the length of the longest string

package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            groups.computeIfAbsent(getSignature(s), k -> new ArrayList<>()).add(s);
        }
        result.addAll(groups.values());
        return result;
    }

    public static String getSignature(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                sb.append((char) ('a' + i)).append(count[i]);
            }
        }
        return sb.toString();
    }

}
