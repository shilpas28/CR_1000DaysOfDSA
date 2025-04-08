//GFG
//Bridge edge in a graph
//Time complexity: O(V+E)
//Space complexity: O(V+E)

import java.util.ArrayList;
import java.util.List;

public class BridgeEdgeInAGraph {

    public static void main(String[] args) {
        int V = 4;
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 1 }, { 2, 3 } };
        int c = 1, d = 2;
        System.out.println(isBridge(V, edges, c, d));
    }

    public static boolean isBridge(int V, int[][] edges, int c, int d) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        adj.get(c).remove(Integer.valueOf(d));
        adj.get(d).remove(Integer.valueOf(c));

        boolean[] visited = new boolean[V];
        dfs(c, visited, adj);

        return !visited[d];
    }

    static void dfs(int node, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adj);
            }
        }
    }
}
