//Leetcode
//2182. Construct String With Repeat Limit - Heap-Optimized Greedy Character Frequency Distribution
//Time complexity: O(NlogK)
//Space complexity: O(K)

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ConstructStringWithRepeatLimit_2 {

    public static void main(String[] args) {
        String s = "cczazcc";
        int repeatLimit = 3;
        System.out.println(repeatLimitedString(s, repeatLimit));
    }

    public static String repeatLimitedString(String s, int repeatLimit) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> Character.compare(b, a));

        for (char ch : freq.keySet())
            maxHeap.offer(ch);

        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            char ch = maxHeap.poll();
            int count = freq.get(ch);

            int use = Math.min(count, repeatLimit);
            for (int i = 0; i < use; i++) {
                result.append(ch);
            }

            freq.put(ch, count - use);

            if (freq.get(ch) > 0 && !maxHeap.isEmpty()) {
                char nextCh = maxHeap.poll();
                result.append(nextCh);
                freq.put(nextCh, freq.get(nextCh) - 1);
                if (freq.get(nextCh) > 0) {
                    maxHeap.offer(nextCh);
                }
                maxHeap.offer(ch);
            }
        }
        return result.toString();
    }
}
