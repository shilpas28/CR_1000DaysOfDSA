//Leetcode
//2273. Find Resultant Array After Removing Anagrams - Hashmap
//Time complexity: O(n*L)
//Space complexity: O(n)

package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindResultantArrayAfterRemovingAnagrams {

    public static void main(String[] args) {
        String[] words = { "abba", "baba", "bbaa", "cd", "cd" };
        System.out.println(removeAnagrams(words));
    }

    public static List<String> removeAnagrams(String[] words) {
        int n = words.length;
        List<Map<Character, Integer>> freq = new ArrayList<>();
        for (String w : words) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : w.toCharArray())
                map.put(c, map.getOrDefault(c, 0) + 1);
            freq.add(map);
        }

        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        for (int i = 1; i < n; i++) {
            if (!freq.get(i).equals(freq.get(i - 1)))
                ans.add(words[i]);
        }
        return ans;
    }
}
