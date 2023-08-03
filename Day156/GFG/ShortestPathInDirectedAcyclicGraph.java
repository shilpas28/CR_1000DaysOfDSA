//GFG
//Shortest path in Directed Acyclic Graph
//Time complexity: O(N+M), where N is the number of nodes and M is edges
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInDirectedAcyclicGraph {

    public static void main(String[] args) {
        int N = 4, M = 2;
        int[][] edge = { { 0, 1, 2 }, { 0, 2, 1 } };
        System.out.println(Arrays.toString(shortestPath(N, M, edge)));
    }

    public static int[] shortestPath(int N, int M, int[][] edges) {
        // Code here
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            ArrayList<Integer> t1 = new ArrayList<>();
            t1.add(v);
            t1.add(w);
            adj.get(u).add(t1);
        }

        Queue<int[]> q = new LinkedList<>();
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        q.add(new int[] { 0, 0 });
        while (!q.isEmpty()) {
            int[] values = q.poll();
            int node = values[0];
            int distance = values[1];
            for (ArrayList<Integer> in : adj.get(node)) {
                int neighbor = in.get(0);
                int ndistance = in.get(1);
                if (distance + ndistance < dist[neighbor]) {
                    dist[neighbor] = distance + ndistance;
                    q.add(new int[] { neighbor, dist[neighbor] });
                }
            }
        }
        for (int i = 0; i < N; i++)
            if (dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;

        return dist;
    }
}
