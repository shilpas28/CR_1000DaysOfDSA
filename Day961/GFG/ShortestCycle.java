//GFG
//Shortest Cycle
//Time complexity: O(V * (V + E))
//Space complexity: O(V)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestCycle {

    public static void main(String[] args) {
        int V = 7;
        int edges[][] = { { 0, 5 }, { 0, 6 }, { 5, 1 }, { 6, 1 }, { 6, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 } };
        System.out.println(shortCycle(V, edges));
    }

    public static int shortCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        int ans = Integer.MAX_VALUE;
        for (int src = 0; src < V; src++) {
            int[] dist = new int[V];
            int[] parent = new int[V];
            Arrays.fill(dist, -1);
            Arrays.fill(parent, -1);
            Queue<Integer> q = new LinkedList<>();
            q.add(src);
            dist[src] = 0;
            while (!q.isEmpty()) {
                int node = q.poll();

                for (int nbr : adj.get(node)) {
                    if (dist[nbr] == -1) {
                        dist[nbr] = dist[node] + 1;
                        parent[nbr] = node;
                        q.add(nbr);
                    } else if (parent[node] != nbr) {
                        ans = Math.min(ans, dist[node] + dist[nbr] + 1);
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
