//Leetcode
//451. Sort Characters By Frequency - Hashtable+Heap 
//Time complexity: O(nlogk) where k is the number of distinct characters
//Space complexity: O(n)

package Leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;

public class SortCharactersByFrequency_2 {

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
        // Build heap
        PriorityQueue<Character> heap = new PriorityQueue<>((a, b) -> (cnt.get(b) - cnt.get(a)));
        heap.addAll(cnt.keySet());
        // Build string
        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            char c = heap.poll();
            for (int i = 0; i < cnt.get(c); i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
