//Leetcode
//1971. Find if Path Exists in Graph - Breadth First Search
//Time complexity: Graph formation is O(V + E) and BFS is additional O(V + E)
//Space complexity: O(V)

package Leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("all")
public class FindIfPathExistsInGraph_2 {

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 0 } };
        int source = 0, destination = 2;
        System.out.println(validPath(n, edges, source, destination));
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        HashSet<Integer>[] graph = new HashSet[n];
        int i, j;

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

        Queue<Integer> queue = new LinkedList<Integer>();
        int N, current;
        queue.offer(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            N = queue.size();
            current = queue.poll();
            if (current == destination) {
                return true;
            }

            for (Integer neighbor : graph[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        return false;
    }
}
