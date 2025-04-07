//GFG
//Directed Graph Cycle - BFS (Using Topological Sort)
//Time complexity: O(V+E)
//Space complexity: O(V+E)

package GFG;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DirectedGraphCycle_2 {

    public static void main(String[] args) {
        int V = 4;
        int edges[][] = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 3 } };
        System.out.println(isCyclic(V, edges));
    }

    public static boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            result.add(node);
            for (int nbr : graph.get(node)) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) {
                    q.offer(nbr);
                }
            }
        }
        
        return result.size() != V;
    }
}
