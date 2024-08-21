//GFG
//Shortest path in Undirected Graph
//Time complexity: O(N + E), where N is the number of nodes and E is the edges
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInUndirectedGraph {

    public static void main(String[] args) {
        int n = 9, m = 10;
        int[][] edges = { { 0, 1 }, { 0, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 1, 2 }, { 2, 6 }, { 6, 7 }, { 7, 8 },
                { 6, 8 } };
        int src = 0;
        System.out.println(Arrays.toString(shortestPath(edges, n, m, src)));
    }

    public static int[] shortestPath(int[][] edges, int n, int m, int src) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        // A dist array of size N initialised with a large number to
        // indicate that initially all the nodes are untraversed.
        int dist[] = new int[n];
        for (int i = 0; i < n; i++)
            dist[i] = (int) 1e9;
        dist[src] = 0;
        // BFS Implementation
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            for (int it : adj.get(node)) {
                if (dist[node] + 1 < dist[it]) {
                    dist[it] = 1 + dist[node];
                    q.add(it);
                }
            }
        }
        // Updated shortest distances are stored in the resultant array ‘ans’.
        // Unreachable nodes are marked as -1.
        for (int i = 0; i < n; i++) {
            if (dist[i] == 1e9) {
                dist[i] = -1;
            }
        }
        return dist;
    }
}
