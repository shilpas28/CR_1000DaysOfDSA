//GFG
//Directed Graph Cycle - DFS
//Time complexity: O(V+E)
//Space complexity: O(V+E)

package GFG;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraphCycle {

    public static void main(String[] args) {
        int V = 4;
        int edges[][] = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 3 } };
        System.out.println(isCyclic(V, edges));
    }

    public static boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges)
            adj.get(edge[0]).add(edge[1]);

        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (dfs(i, visited, recStack, adj))
                return true;
        }

        return false;
    }

    static boolean dfs(int node, boolean[] visited, boolean[] recStack, List<List<Integer>> adj) {

        if (recStack[node])
            return true;
        if (visited[node])
            return false;

        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : adj.get(node)) {
            if (dfs(neighbor, visited, recStack, adj))
                return true;
        }

        recStack[node] = false;
        return false;
    }
}
