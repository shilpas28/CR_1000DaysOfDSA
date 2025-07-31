//GFG
//Powerful Integer
//Time complexity: O(Nlog N)
//Space complexity: O(N)

import java.util.Map;
import java.util.TreeMap;

public class PowerfulInteger_2 {

    public static void main(String[] args) {
        int intervals[][] = { { 1, 3 }, { 4, 6 }, { 3, 4 } };
        int k = 2;
        System.out.println(powerfulInteger(intervals, k));
    }

    public static int powerfulInteger(int[][] intervals, int k) {
        // code here
        int n = intervals.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(intervals[i][0], map.getOrDefault(intervals[i][0], 0) + 1);
            map.put(intervals[i][1] + 1, map.getOrDefault(intervals[i][1] + 1, 0) - 1);
        }
        int p_s = 0;
        int ans = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int x = e.getKey();
            int y = e.getValue();

            if (y >= 0) {
                p_s += y;
                if (p_s >= k)
                    ans = x;
            } else if (y < 0) {
                if (p_s >= k)
                    ans = x - 1;
                p_s += y; // trick here
            }

        }
        return ans > 0 ? ans : -1;
    }
}
