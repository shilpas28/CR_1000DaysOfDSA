//GFG
//Sum of dependencies in a graph
//Time complexity: O(V)
//Space complexity: O(1)

package GFG;

import java.util.ArrayList;

public class SumOfDependenciesInAGraph {

    public static void main(String[] args) {

        // Creating a graph with 4vertices
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());
        // Adding edges one by one.
        addEdge(adj, 0, 2);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 3);
        System.out.println(sumOfDependencies(adj, V));
    }

    static int sumOfDependencies(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        int res = 0;
        for (ArrayList<Integer> list : adj) {
            res += list.size();
        }
        return res;
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj,
            int u, int v) {
        adj.get(u).add(v);
    }

}
