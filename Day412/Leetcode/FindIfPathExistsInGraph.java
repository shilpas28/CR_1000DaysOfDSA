//Leetcode
//1971. Find if Path Exists in Graph - Depth First Search
//Time complexity: Graph formation is O(V + E) and DFS is additional O(V + E)
//Space complexity: O(V) 

package Leetcode;

import java.util.HashSet;

@SuppressWarnings("all")
public class FindIfPathExistsInGraph {

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 0 } };
        int source = 0, destination = 2;
        System.out.println(validPath(n, edges, source, destination));
    }

    static boolean seen;

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        HashSet<Integer>[] graph = new HashSet[n];
        int i;

        for (i = 0; i < n; i++) {
            graph[i] = new HashSet<Integer>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        if (graph[source].contains(destination)) { // direct connection exists
            return true;
        }

        seen = false;
        dfs(graph, visited, source, destination);
        return seen;
    }

    static void dfs(HashSet<Integer>[] graph, boolean[] visited, int start, int end) {
        if (!visited[start] && !seen) {
            if (start == end) {
                seen = true;
                return;
            }

            visited[start] = true;
            for (Integer neighbor : graph[start]) {
                dfs(graph, visited, neighbor, end);
            }
        }
    }
}
