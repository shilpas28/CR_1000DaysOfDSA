//GFG
//BFS of graph
//Time complexity: O(V + E)
//Space complexity: O(V)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSOfGraph {

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
        ArrayList<Integer> res = bfs(adj);
        System.out.println(res);

    }

    // Function to return Breadth First Search Traversal of given graph.
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V = adj.size();
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean vis[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            for (Integer it : adj.get(node)) {
                if (vis[it] == false) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }
}
