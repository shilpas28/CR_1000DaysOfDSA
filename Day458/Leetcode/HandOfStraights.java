//Leetcode
//846. Hand of Straights
//Time complexity: O(MlogM + MW), where M is the number of different cardsand W is the groupSize
//Space complexity: O(1)

import java.util.Map;
import java.util.TreeMap;

public class HandOfStraights {

    public static void main(String[] args) {
        int[] hand = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
        int groupSize = 3;
        System.out.println(isNStraightHand(hand, groupSize));
    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> c = new TreeMap<>();
        for (int i : hand)
            c.put(i, c.getOrDefault(i, 0) + 1);
        for (int it : c.keySet())
            if (c.get(it) > 0)
                for (int i = groupSize - 1; i >= 0; --i) {
                    if (c.getOrDefault(it + i, 0) < c.get(it))
                        return false;
                    c.put(it + i, c.get(it + i) - c.get(it));
                }
        return true;
    }
}
