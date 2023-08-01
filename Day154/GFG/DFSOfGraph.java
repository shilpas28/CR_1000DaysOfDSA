//GFG
//DFS of Graph
//Time complexity: O(V + E)
//Space complexity: O(V)

import java.util.ArrayList;

public class DFSOfGraph {

    static void addEdge(ArrayList<ArrayList<Integer>> adj,
            int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void printAdjacencyList(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("Adjacency list of " + i);
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // V = 5 , adj = [[2,3,1] , [0], [0,4], [0], [2]]
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());
        addEdge(adj, 0, 2);
        addEdge(adj, 0, 3);
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 0);
        addEdge(adj, 2, 0);
        addEdge(adj, 2, 4);
        addEdge(adj, 3, 0);
        addEdge(adj, 4, 2);
        printAdjacencyList(adj);
        ArrayList<Integer> res = dfsOfGraph(V, adj);
        System.out.println(res);
    }

    // Function to return a list containing the DFS traversal of the graph.
    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[V];
        dfs(0, adj, ans, visited);
        return ans;
    }

    public static void dfs(int i, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans, boolean[] visited) {
        visited[i] = true;
        ans.add(i);
        for (Integer in : adj.get(i)) {
            if (visited[in] == false)
                dfs(in, adj, ans, visited);
        }
    }
}
