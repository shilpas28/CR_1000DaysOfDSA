//Leetcode
//785. Is Graph Bipartite? - Using BFS
//Time complexity: O(V+2E)
//Space complexity: O(V)

package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {

    public static void main(String[] args) {

        // int[][] graph = { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };
        int[][] graph = { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } };
        System.out.println(isBipartite(graph));
    }

    public static boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int color[] = new int[V];
        for (int i = 0; i < V; i++)
            color[i] = -1;

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (check(i, V, graph, color) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean check(int start, int V, int[][] adj, int color[]) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        color[start] = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();

            for (int it : adj[node]) {
                // if the adjacent node is yet not colored
                // you will give the opposite color of the node
                if (color[it] == -1) {

                    color[it] = 1 - color[node];
                    q.add(it);
                }
                // is the adjacent guy having the same color
                // someone did color it on some other path
                else if (color[it] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}
