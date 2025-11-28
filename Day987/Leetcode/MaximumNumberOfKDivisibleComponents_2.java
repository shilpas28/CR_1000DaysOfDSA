//Leetcode
//2872. Maximum Number of K-Divisible Components - BFS
//Time complexity: O(n+m)
//Space complexity: O(n+m)

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MaximumNumberOfKDivisibleComponents_2 {

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 2}, {1, 2}, {1, 3}, {2, 4}};
        int[] values = {1, 8, 1, 4, 4};
        int k = 6;
        System.out.println(maxKDivisibleComponents(n, edges, values, k));
    }

    public static int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        // Base case: if there are less than 2 nodes, return 1
        if (n < 2) {
            return 1;
        }
        int componentCount = 0;
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        // Step 1: Build the graph
        for (int[] edge : edges) {
            int node1 = edge[0], node2 = edge[1];
            graph.computeIfAbsent(node1, key -> new HashSet<>()).add(node2);
            graph.computeIfAbsent(node2, key -> new HashSet<>()).add(node1);
        }
        // Convert values to long to prevent overflow
        long[] longValues = new long[values.length];
        for (int i = 0; i < values.length; i++) {
            longValues[i] = values[i];
        }
        // Step 2: Initialize the BFS queue with leaf nodes (nodes with only one
        // connection)
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            if (entry.getValue().size() == 1) {
                queue.add(entry.getKey());
            }
        }
        // Step 3: Process nodes in BFS order
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            // Find the neighbor node
            int neighborNode = -1;
            if (graph.get(currentNode) != null
                    && !graph.get(currentNode).isEmpty()) {
                neighborNode = graph.get(currentNode).iterator().next();
            }
            if (neighborNode >= 0) {
                // Remove the edge between current and neighbor
                graph.get(neighborNode).remove(currentNode);
                graph.get(currentNode).remove(neighborNode);
            }
            // Check divisibility of the current node's value
            if (longValues[currentNode] % k == 0) {
                componentCount++;
            } else if (neighborNode >= 0) {
                // Add current node's value to the neighbor
                longValues[neighborNode] += longValues[currentNode];
            }
            // If the neighbor becomes a leaf node, add it to the queue
            if (neighborNode >= 0
                    && graph.get(neighborNode) != null
                    && graph.get(neighborNode).size() == 1) {
                queue.add(neighborNode);
            }
        }
        return componentCount;
    }
}
