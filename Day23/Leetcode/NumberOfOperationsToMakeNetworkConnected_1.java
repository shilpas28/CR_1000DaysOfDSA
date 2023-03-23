//Leetcode - using DFS
//1319. Number of Operations to Make Network Connected
//Time complexity: O(connections)
//Space complexity: O(N)

package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class NumberOfOperationsToMakeNetworkConnected_1 {

    public static void main(String[] args) {
        int n = 4;
        int[][] connections = { { 0, 1 }, { 0, 2 }, { 1, 2 } };
        System.out.println(makeConnected(n, connections));
    }

    public static int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1)
            return -1;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for (int[] c : connections) {
            graph[c[0]].add(c[1]);
            graph[c[1]].add(c[0]);
        }
        int components = 0;
        boolean[] visited = new boolean[n];
        for (int v = 0; v < n; v++)
            components += dfs(v, graph, visited);
        return components - 1;
    }

    static int dfs(int u, List<Integer>[] graph, boolean[] visited) {
        if (visited[u])
            return 0;
        visited[u] = true;
        for (int v : graph[u])
            dfs(v, graph, visited);
        return 1;
    }

}
