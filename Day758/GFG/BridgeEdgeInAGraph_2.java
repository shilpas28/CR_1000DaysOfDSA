//GFG
//Bridge edge in a graph
//Time complexity: O(V+E)
//Space complexity: O(V+E)

import java.util.ArrayList;

public class BridgeEdgeInAGraph_2 {

    public static void main(String[] args) {
        int V = 4;
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 1 }, { 2, 3 } };
        int c = 1, d = 2;
        System.out.println(isBridge(V, edges, c, d));
    }

    public static boolean isBridge(int V, int[][] edges, int c, int d) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Temporarily remove the edge
        adj.get(c).remove(Integer.valueOf(d));
        adj.get(d).remove(Integer.valueOf(c));

        boolean[] visited = new boolean[V];
        dfs(c, adj, visited);
        return visited[d] == false;
    }

    static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {

        visited[node] = true;

        for (int i : adj.get(node)) {
            if (!visited[i]) {
                dfs(i, adj, visited);
            }
        }
    }
}
