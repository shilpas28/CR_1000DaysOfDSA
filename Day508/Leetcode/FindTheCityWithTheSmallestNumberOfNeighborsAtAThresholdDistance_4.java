//Leetcode
//1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance - Bellman Ford Algorithm
//Time complexity:
//Space complexity:

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("all")
public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance_4 {

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
        }

        for (int i = 0; i < n; i++) {
            bellman(n, edges, dist[i], i);
        }

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

    static void bellman(int n, int[][] edges, int[] dist, int src) {
        for (int k = 1; k < n; k++) {
            for (int[] e : edges) {
                int u = e[0];
                int v = e[1];
                int duv = e[2];

                if (dist[u] > dist[v] + duv) {
                    dist[u] = dist[v] + duv;
                }

                if (dist[v] > dist[u] + duv) {
                    dist[v] = dist[u] + duv;
                }
            }
        }
    }
}
