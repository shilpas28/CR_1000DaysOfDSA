//Leetcode
//1207. Unique Number of Occurrences
//Time complexity: O(n)
//Space complexity: O(n)

package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences_2 {

    public static void main(String[] args) {
        int[] arr = { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 };
        System.out.println(uniqueOccurrences(arr));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        Set<Integer> s = new HashSet<>();
        for (int x : freq.values()) {
            s.add(x);
        }

        return freq.size() == s.size();
    }
}
