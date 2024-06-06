//Leetcode
//846. Hand of Straights
//Time complexity: O(NlogM)
//Space complexity: O(1)

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class HandOfStraights_2 {

    public static void main(String[] args) {
        int[] hand = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
        int groupSize = 3;
        System.out.println(isNStraightHand(hand, groupSize));
    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> c = new TreeMap<>();
        for (int i : hand)
            c.put(i, c.getOrDefault(i, 0) + 1);
        Queue<Integer> start = new LinkedList<>();
        int last_checked = -1, opened = 0;
        for (int i : c.keySet()) {
            if (opened > 0 && i > last_checked + 1 || opened > c.get(i))
                return false;
            start.add(c.get(i) - opened);
            last_checked = i;
            opened = c.get(i);
            if (start.size() == groupSize)
                opened -= start.remove();
        }
        return opened == 0;
    }
}
