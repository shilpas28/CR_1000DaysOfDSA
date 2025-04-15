//GFG
//Bellman-Ford
//Time complexity: O(V * E)
//Space complexity: O(V)

import java.util.Arrays;

public class BellmanFord {

    public static void main(String[] args) {
        int V = 5;
        int edges[][] = { { 1, 3, 2 }, { 4, 3, -1 }, { 2, 4, 1 }, { 1, 2, 1 }, { 0, 1, 5 } };
        int src = 0;
        System.out.println(Arrays.toString(bellmanFord(V, edges, src)));
    }

    public static int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int[] dist = new int[V];
        Arrays.fill(dist, (int) (1e8));
        dist[src] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (int[] it : edges) {
                int u = it[0], v = it[1], wt = it[2];
                if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        // nth relaxation to check if thre is -ve cycle
        for (int[] it : edges) {
            int u = it[0], v = it[1], wt = it[2];
            if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        return dist;
    }
}
