//GFG
//City With the Smallest Number of Neighbors at a Threshold Distance
//Time complexity: O(n^2 + length(edges)*nlog(n) )
//Space complexity: O(n^3)

package GFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class CityWithSmallestNumberOfNeighborsAtAThresholdDistance_2 {

    public static void main(String[] args) {
        int n = 4, m = 4;
        int[][] edges = { { 0, 1, 3 },
                { 1, 2, 1 },
                { 1, 3, 4 },
                { 2, 3, 1 } };
        int distanceThreshold = 4;
        System.out.println(findCity(n, m, edges, distanceThreshold));
    }

    static class Node {
        int v, w;

        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        // code here
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        // Constructing adjacency list
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Node(edge[1], edge[2]));
            adj.get(edge[1]).add(new Node(edge[0], edge[2])); // Considering bidirectional edges
        }

        int minCities = Integer.MAX_VALUE;
        int result = -1;
        // running dijkstras for reach city
        for (int i = 0; i < n; i++) {
            int[] dis = new int[n];
            Arrays.fill(dis, Integer.MAX_VALUE);
            dijkstra(adj, i, dis);

            int reachableCities = 0;
            for (int j = 0; j < n; j++) {
                if (dis[j] <= distanceThreshold) {
                    reachableCities++;
                }
            }
            // tracking min
            if (reachableCities <= minCities) {
                minCities = reachableCities;
                result = i;
            }
        }
        return result;
    }

    // Dijkstra's Algorithm
    static void dijkstra(List<List<Node>> adj, int start, int[] dis) {
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.w - y.w);
        dis[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node currNode = pq.poll();
            for (Node nei : adj.get(currNode.v)) {
                if (dis[nei.v] > dis[currNode.v] + nei.w) {
                    dis[nei.v] = dis[currNode.v] + nei.w;
                    pq.add(new Node(nei.v, dis[nei.v]));
                }
            }
        }
    }
}
