//Leetcode
//1931. Painting a Grid With Three Different Colors
//Time complexity: O(K*(N^2))
//Space complexity: O(K)

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PaintingAGridWithThreeDifferentColors {

    public static void main(String[] args) {
        int m = 1, n = 1;
        System.out.println(colorTheGrid(m, n));
    }

    static int mod = (int) 1e9 + 7;

    public static int colorTheGrid(int m, int n) {
        Map<Integer, Long> state = new HashMap<>();
        dfs(state, 0, m, -1, 0);
        Set<Integer> set = new HashSet<>(state.keySet());
        for (int i = 1; i < n; ++i) {
            Map<Integer, Long> dp = new HashMap<>();
            for (int a : set) {
                for (int b : set) {
                    if (0 == (a & b))
                        dp.put(a, (dp.getOrDefault(a, 0L) + state.get(b)) % mod);
                }
            }
            state = dp;
        }
        long res = 0L;
        for (long val : state.values())
            res = (res + val) % mod;
        return (int) res;
    }

    static void dfs(Map<Integer, Long> state, int j, int m, int prev, int cur) {
        if (j == m) {
            state.put(cur, state.getOrDefault(cur, 0L) + 1);
            return;
        }
        for (int i = 0; i < 3; ++i) {
            if (i == prev)
                continue;
            dfs(state, j + 1, m, i, (cur << 3) | (1 << i));
        }
    }
}
