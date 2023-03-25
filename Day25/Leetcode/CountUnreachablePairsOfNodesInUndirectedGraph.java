//Leetcode
//2316. Count Unreachable Pairs of Nodes in an Undirected Graph
//Time Complexity: O(N)
//Space Complexity: O(N)

package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class CountUnreachablePairsOfNodesInUndirectedGraph {

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 2 } };
        System.out.println(countPairs(n, edges));
    }

    static List<List<Integer>> x = new ArrayList<>();

    public static long countPairs(int n, int[][] edges) {
        for (int i = 0; i < n; i++)
            x.add(new ArrayList<>());
        for (int[] edge : edges) {
            x.get(edge[0]).add(edge[1]);
            x.get(edge[1]).add(edge[0]);
        }
        long sum = (Long.valueOf(n) * (n - 1)) / 2;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++)
            if (!visited[i]) {
                int cnt = dfs(i, visited, new int[1]);
                sum -= (Long.valueOf(cnt) * (cnt - 1)) / 2;
            }
        return sum;
    }

    static int dfs(int node, boolean[] visited, int[] count) {
        if (visited[node])
            return count[0];
        visited[node] = true;
        count[0]++;
        for (int curr : x.get(node))
            dfs(curr, visited, count);
        return count[0];
    }
}
