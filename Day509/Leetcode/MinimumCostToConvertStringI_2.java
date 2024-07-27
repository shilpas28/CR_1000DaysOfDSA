//Leetcode
//2976. Minimum Cost to Convert String I
//Time complexity: O((V + E) log V)
//Space complexity: O(V^2)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import javafx.util.Pair;

@SuppressWarnings("all")
public class MinimumCostToConvertStringI_2 {

    public static void main(String[] args) {
        String source = "abcd", target = "acbe";
        char[] original = { 'a', 'b', 'c', 'c', 'e', 'd' };
        char[] changed = { 'b', 'c', 'b', 'e', 'b', 'e' };
        int[] cost = { 2, 5, 5, 1, 2, 20 };
        System.out.println(minimumCost(source, target, original, changed, cost));
    }

    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        List<int[]>[] adj = new List[30];
        for (int i = 0; i < 30; i++) {
            adj[i] = new ArrayList<>();
        }
        int n = original.length;
        for (int i = 0; i < n; i++) {
            adj[original[i] - 'a'].add(new int[] { changed[i] - 'a', cost[i] });
        }

        Map<Integer, long[]> m = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            long[] k = solve(i, adj);
            m.put(i, k);
        }

        n = source.length();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (source.charAt(i) != target.charAt(i)) {
                long k = m.get(source.charAt(i) - 'a')[target.charAt(i) - 'a'];
                if (k == -1) {
                    return -1;
                }
                ans += k;
            }
        }
        return ans;
    }

    static long[] solve(int a, List<int[]>[] adj) {
        PriorityQueue<Pair<Long, Integer>> q = new PriorityQueue<>(Comparator.comparingLong(Pair::getKey));
        q.add(new Pair<>(0L, a));
        long[] dist = new long[26];
        Arrays.fill(dist, -1L);

        while (!q.isEmpty()) {
            Pair<Long, Integer> p = q.poll();
            for (int[] i : adj[p.getValue()]) {
                if (dist[i[0]] == -1 || p.getKey() + i[1] < dist[i[0]]) {
                    dist[i[0]] = p.getKey() + i[1];
                    q.add(new Pair<>(dist[i[0]], i[0]));
                }
            }
        }
        return dist;
    }
}
