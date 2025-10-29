//GFG
//Graph Diameter - BFS
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphDiameter_2 {

    public static void main(String[] args) {
        int V = 6;
        int edges[][] = { { 0, 1 }, { 0, 4 }, { 1, 3 }, { 1, 2 }, { 2, 5 } };
        System.out.println(diameter(V, edges));
    }

    public static int diameter(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int nodeA = bfs(0, adj, V)[0];
        int[] result = bfs(nodeA, adj, V);
        return result[1];
    }

    static int[] bfs(int start, List<List<Integer>> adj, int V) {
        int[] dist = new int[V];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;
        int farthestNode = start;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int nei : adj.get(node)) {
                if (dist[nei] == -1) {
                    dist[nei] = dist[node] + 1;
                    q.add(nei);
                    if (dist[nei] > dist[farthestNode]) {
                        farthestNode = nei;
                    }
                }
            }
        }
        return new int[] { farthestNode, dist[farthestNode] };
    }
}
