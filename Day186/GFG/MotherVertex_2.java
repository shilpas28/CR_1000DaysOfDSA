//GFG - Solution accepted
//Mother Vertex - using DFS
//Time complexity: O(V+E)
//Space complexity: O(V)

package GFG;

import java.util.ArrayList;

public class MotherVertex_2 {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> al1 = new ArrayList<>();
        al1.add(1);
        al1.add(0);
        adj.add(al1);
        ArrayList<Integer> al2 = new ArrayList<>();
        al2.add(0);
        al2.add(2);
        adj.add(al2);
        ArrayList<Integer> al3 = new ArrayList<>();
        al3.add(2);
        al3.add(1);
        adj.add(al3);
        ArrayList<Integer> al4 = new ArrayList<>();
        al4.add(2);
        al4.add(3);
        adj.add(al4);
        ArrayList<Integer> al5 = new ArrayList<>();
        al5.add(3);
        al5.add(4);
        adj.add(al5);
        int V = 5;
        System.out.println(findMotherVertex(V, adj));
    }

    static int ans;

    // Function to find a Mother Vertex in the Graph.
    public static int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        int ans = -1;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                ans = i;
            }
        }
        // again need to check
        boolean[] visited2 = new boolean[V];
        dfs(ans, adj, visited2);
        for (boolean x : visited2) {
            if (!x)
                return -1;
        }
        return ans;
    }

    static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }
}
