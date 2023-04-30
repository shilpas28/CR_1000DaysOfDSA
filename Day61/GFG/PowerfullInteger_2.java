//GFG
//Powerfull Integer
//Time complexity: O(Nlog N)
//Space complexity: O(N)

import java.util.Map;
import java.util.TreeMap;

public class PowerfullInteger_2 {
    public static void main(String[] args) {
        int n = 3;
        int[][] intervals = { { 1, 3 }, { 4, 6 }, { 3, 4 } };
        int k = 2;
        System.out.println(powerfullInteger(n, intervals, k));
    }

    public static int powerfullInteger(int n, int interval[][], int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(interval[i][0], map.getOrDefault(interval[i][0], 0) + 1);
            map.put(interval[i][1] + 1, map.getOrDefault(interval[i][1] + 1, 0) - 1);
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
