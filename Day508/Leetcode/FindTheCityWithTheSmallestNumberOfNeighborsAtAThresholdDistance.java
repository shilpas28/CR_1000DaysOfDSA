//Leetcode
//1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance - Floyd Algorithm
//Time complexity:
//Space complexity:

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("all")
public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = { { 0, 1, 3 }, { 1, 2, 1 }, { 1, 3, 4 }, { 2, 3, 1 } };
        int distanceThreshold = 4;
        System.out.println(findTheCity(n, edges, distanceThreshold));
    }

    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int INF = (int) 1e9 + 7;
        List<int[]>[] adj = new List[n];
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int d = e[2];

            adj[u].add(new int[] { v, d });
            adj[v].add(new int[] { u, d });
            dist[u][v] = d;
            dist[v][u] = d;
        }

        floyd(n, adj, dist);
        int minCity = -1;
        int minCount = n;
        for (int i = 0; i < n; i++) {
            int curCount = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (dist[i][j] <= distanceThreshold) {
                    curCount++;
                }
            }
            if (curCount <= minCount) {
                minCount = curCount;
                minCity = i;
            }
        }
        return minCity;
    }

    static void floyd(int n, List<int[]>[] adj, int[][] dist) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}
