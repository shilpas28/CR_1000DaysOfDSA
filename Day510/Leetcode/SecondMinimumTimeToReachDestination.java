//Leetcode
//2045. Second Minimum Time to Reach Destination
//Time complexity: O((V+E)logV), where V is the number of vertices and E is the number of edges.
//Space complexity: O(V+E) for storing the graph and O(V) for the uniqueVisit and dis arrays.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

@SuppressWarnings("all")
public class SecondMinimumTimeToReachDestination {

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = { { 1, 2 }, { 1, 3 }, { 1, 4 }, { 3, 4 }, { 4, 5 } };
        int time = 3, change = 5;
        System.out.println(secondMinimum(n, edges, time, change));
    }

    public static int secondMinimum(int n, int[][] edges, int time, int change) {
        Map<Integer, List<Integer>> g = new HashMap();
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g.computeIfAbsent(u, x -> new ArrayList()).add(v);
            g.computeIfAbsent(v, x -> new ArrayList()).add(u);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.offer(new int[] { 1, 0 });
        int[] uniqueVisit = new int[n + 1];
        int[] dis = new int[n + 1];
        Arrays.fill(dis, -1);
        while (!q.isEmpty()) {
            int size = q.size();
            int[] cur = q.poll();
            int node = cur[0], t = cur[1];
            if (dis[node] == t || uniqueVisit[node] >= 2)
                continue;
            uniqueVisit[node]++;
            dis[node] = t;
            if (node == n && uniqueVisit[node] == 2)
                return dis[node];
            if ((t / change) % 2 != 0)
                t = (t / change + 1) * change;
            for (int nei : g.getOrDefault(node, new ArrayList<>())) {
                q.offer(new int[] { nei, t + time });
            }
        }
        return -1;
    }
}
