//GFG
//Level of Nodes
//Time complexity: O(V)
//Space complexity: O(V)

package GFG;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOfNodes {

    public static void main(String[] args) {
        int X = 4;
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(1).add(4);
        adj.get(2).add(0);
        adj.get(2).add(5);
        adj.get(3).add(1);
        adj.get(4).add(1);
        adj.get(5).add(2);
        System.out.println(nodeLevel(V, adj, X));
    }

    // Function to find the level of node X.
    static int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X) {
        // code here
        int level = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];

        q.add(0);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int nn = q.poll();
                visited[nn] = true;
                if (nn == X)
                    return level;
                for (Integer neighbor : adj.get(nn)) {
                    if (visited[neighbor] == false)
                        q.add(neighbor);
                }
            }
            level++;
        }
        return -1;
    }
}
