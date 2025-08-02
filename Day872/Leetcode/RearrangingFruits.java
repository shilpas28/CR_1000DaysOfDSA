//Leetcode
//2561. Rearranging Fruits
//Time complexity:
//Space complexity:

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RearrangingFruits {

    public static void main(String[] args) {
        int[] basket1 = { 4, 2, 2, 2 };
        int[] basket2 = { 1, 4, 1, 2 };
        System.out.println(minCost(basket1, basket2));
    }

    public static long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int c : basket1)
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        for (int c : basket2)
            cnt.put(c, cnt.getOrDefault(c, 0) - 1);
        List<Integer> last = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            int v = e.getValue();
            // if v is odd, an even distribution is never possible
            if (v % 2 != 0)
                return -1;
            // the count of transferred k is |v|/2
            for (int i = 0; i < Math.abs(v) / 2; ++i)
                last.add(e.getKey());
        }
        // find the min of two input arrays as the intermediate
        int minx = Math.min(Arrays.stream(basket1).min().getAsInt(),
                Arrays.stream(basket2).min().getAsInt());
        // Use quickselect instead of sort can get a better complexity
        Collections.sort(last);
        long res = 0;
        // The first half may be the cost
        for (int i = 0; i < last.size() / 2; ++i)
            res += Math.min(last.get(i), minx * 2);
        return res;
    }
}
