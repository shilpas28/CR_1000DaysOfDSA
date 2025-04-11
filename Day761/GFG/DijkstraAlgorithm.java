//GFG
//Dijkstra Algorithm
//Time complexity: O((V + E) log V)
//Space complexity: O(V)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    public static void main(String[] args) {
        int V = 3;
        int edges[][] = { { 0, 1, 1 }, { 1, 2, 3 }, { 0, 2, 6 } };
        int src = 2;
        System.out.println(Arrays.toString(dijkstra(V, edges, src)));
    }

    static class Edge {
        private int destination, weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Pair {
        private int dest, wt;

        public Pair(int dest, int wt) {
            this.dest = dest;
            this.wt = wt;
        }

        public int getFirst() {
            return dest;
        }

        public int getSecond() {
            return wt;
        }
    }

    public static int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new Edge(edge[1], edge[2]));
            graph.get(edge[1]).add(new Edge(edge[0], edge[2]));
        }
        int[] distances = new int[V];
        for (int i = 0; i < V; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        distances[src] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getSecond));
        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {
            int node = pq.poll().getFirst();
            for (Edge ed : graph.get(node)) {
                int v = ed.destination, w = ed.weight;
                if (distances[v] > distances[node] + w) {
                    distances[v] = distances[node] + w;
                    pq.offer(new Pair(v, w));
                }
            }
        }
        return distances;
    }
}
