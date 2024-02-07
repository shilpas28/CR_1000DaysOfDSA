//Leetcode
//451. Sort Characters By Frequency - Hashtable+Sort 
//Time complexity: O(nlogn) since we sort the characters
//Space complexity: O(n)

package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SortCharactersByFrequency {

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }

    public static String frequencySort(String s) {
        // Count the occurence on each character
        HashMap<Character, Integer> cnt = new HashMap<>();
        for (char c : s.toCharArray()) {
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        }
        // Sorting
        List<Character> chars = new ArrayList<>(cnt.keySet());
        Collections.sort(chars, (a, b) -> (cnt.get(b) - cnt.get(a)));
        // Build string
        StringBuilder sb = new StringBuilder();
        for (Object c : chars) {
            for (int i = 0; i < cnt.get(c); i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
