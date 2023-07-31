//GFG
//BFS Of Graph
//Time complexity: O(V + E)
//Space complexity: O(V)

package GFG;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSOfGraph {

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> al0 = new ArrayList<>();
        al0.add(1);
        al0.add(2);
        al0.add(3);
        al.add(al0);
        ArrayList<Integer> al2 = new ArrayList<>();
        al2.add(4);
        al.add(al2);
        ArrayList<Integer> res = bfsOfGraph(V, al);
        System.out.println(res);
    }

    // Function to return Breadth First Traversal of given graph.
    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> al = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[V];
        q.add(0); // adding the first node
        vis[0] = true; // mark it visited.
        while (!q.isEmpty()) {
            int curr = q.poll(); // dequeueing and adding into al
            al.add(curr);
            for (int neighbour : adj.get(curr))
                if (!vis[neighbour]) {
                    vis[neighbour] = true;
                    q.add(neighbour);
                }
        }
        return al;
    }
}
