//Leetcode
//3016. Minimum Number of Pushes to Type Word II
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumNumberOfPushesToTypeWordII_2 {

    public static void main(String[] args) {
        String word = "abcde";
        System.out.println(minimumPushes(word));
    }

    public static int minimumPushes(String word) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : word.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> freqHeap = new PriorityQueue<>(Collections.reverseOrder());
        freqHeap.addAll(charCount.values());

        int totalPresses = 0;
        int keyPosition = 0;

        while (!freqHeap.isEmpty()) {
            totalPresses += (keyPosition / 8 + 1) * freqHeap.poll();
            keyPosition++;
        }
        return totalPresses;
    }
}
