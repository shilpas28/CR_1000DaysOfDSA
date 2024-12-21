//Leetcode
//2872. Maximum Number of K-Divisible Components - Topological Sort
//Time complexity: O(n+m)
//Space complexity: O(n+m)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumNumberOfKDivisibleComponents_3 {

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = { { 0, 2 }, { 1, 2 }, { 1, 3 }, { 2, 4 } };
        int[] values = { 1, 8, 1, 4, 4 };
        int k = 6;
        System.out.println(maxKDivisibleComponents(n, edges, values, k));
    }

    public static int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        if (n < 2)
            return 1; // Handle the base case where the graph has fewer than 2 nodes.
        int componentCount = 0;
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n];
        // Build the graph and calculate in-degrees
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>()); // Initialize the adjacency list for each node.
        }
        for (int[] edge : edges) {
            int node1 = edge[0], node2 = edge[1];
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
            inDegree[node1]++;
            inDegree[node2]++;
        }
        // Convert values to long to prevent overflow
        long[] longValues = new long[n];
        for (int i = 0; i < n; i++) {
            longValues[i] = values[i];
        }
        // Initialize the queue with nodes having in-degree of 1 (leaf nodes)
        Queue<Integer> queue = new LinkedList<>();
        for (int node = 0; node < n; node++) {
            if (inDegree[node] == 1) {
                queue.offer(node);
            }
        }

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            inDegree[currentNode]--;

            long addValue = 0;
            // Check if the current node's value is divisible by k
            if (longValues[currentNode] % k == 0) {
                componentCount++;
            } else {
                addValue = longValues[currentNode];
            }
            // Propagate the value to the neighbor nodes
            for (int neighborNode : graph.get(currentNode)) {
                if (inDegree[neighborNode] == 0) {
                    continue;
                }
                inDegree[neighborNode]--;
                longValues[neighborNode] += addValue;
                // If the neighbor node's in-degree becomes 1, add it to the queue
                if (inDegree[neighborNode] == 1) {
                    queue.offer(neighborNode);
                }
            }
        }
        return componentCount;
    }
}
