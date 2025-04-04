//GFG
//Undirected Graph Cycle 
//Time complexity: O(V + E) 
//Space complexity: O(V)

public class UndirectedGraphCycle {

    public static void main(String[] args) {
        int V = 4;
        int edges[][] = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 3 } };
        System.out.println(isCycle(V, edges));
    }

    public static boolean isCycle(int V, int[][] edges) {
        // Code here
        int[] parent = new int[V];
        int[] rank = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            int rootU = find(u, parent);
            int rootV = find(v, parent);

            if (rootU == rootV)
                return true;

            union(u, v, parent, rank);
        }
        return false;
    }

    static int find(int node, int[] parent) {
        if (parent[node] != node) {
            parent[node] = find(parent[node], parent);
        }
        return parent[node];
    }

    static void union(int node1, int node2, int[] parent, int[] rank) {
        int root1 = find(node1, parent);
        int root2 = find(node2, parent);

        if (root1 != root2) {
            if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } else {
                parent[root2] = root1;
                rank[root1]++;
            }
        }
    }
}
