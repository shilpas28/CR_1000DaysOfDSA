//GFG
//Minimum Operations to Connect Hospitals
//Time complexity: O(V + E)
//Space complexity: O(V + E)

import java.util.ArrayList;

public class MinimumOperationsToConnectHospitals {

    public static void main(String[] args) {
        int V = 4;
        int edges[][] = {{0, 1}, {0, 2}, {1, 2}};
        System.out.println(minConnect(V, edges));
    }

    public static int minConnect(int V, int[][] edges) {
        // code here
        if (edges.length < V - 1) {
            return -1;
        }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int count = -1;
        boolean vis[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis);
                count++;
            }
        }

        return count;
    }

    static void dfs(int curr, ArrayList<ArrayList<Integer>> adj, boolean vis[]) {
        vis[curr] = true;

        for (int i = 0; i < adj.get(curr).size(); i++) {
            int neigh = adj.get(curr).get(i);
            if (!vis[neigh]) {
                dfs(neigh, adj, vis);
            }
        }
    }
}
