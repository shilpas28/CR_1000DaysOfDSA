//Leetcode
//2642. Design Graph With Shortest Path Calculator
//Time complexity: O(E), O(1) and O(V+ElogE)
//Space complexity: O(V+E), O(1) and O(E)

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DesignGraphWithShortestPathCalculator {

    static class Graph {

        private List<List<int[]>> adjacencyList;

        public Graph(int n, int[][] edges) {
            adjacencyList = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                adjacencyList.add(new ArrayList<>());
            }

            for (int[] edge : edges) {
                addEdge(edge);
            }
        }

        public void addEdge(int[] edge) {
            int[] edgeArray = { edge[1], edge[2] };
            adjacencyList.get(edge[0]).add(edgeArray);
        }

        public int shortestPath(int node1, int node2) {
            return dijkstra(node1, node2);
        }

        private int dijkstra(int start, int end) {
            int n = adjacencyList.size();
            int[] distances = new int[n];
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[start] = 0;

            // Priority queue to efficiently retrieve the node with the minimum distance
            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
            priorityQueue.add(new int[] { 0, start });

            while (!priorityQueue.isEmpty()) {
                int[] current = priorityQueue.poll();
                int currentNode = current[1], currentCost = current[0];

                // Skip if a shorter path has already been found
                if (currentCost > distances[currentNode])
                    continue;

                // If found the target return the cost
                if (currentNode == end)
                    return currentCost;

                // Explore neighbors and update distances
                for (int[] edge : adjacencyList.get(currentNode)) {
                    int neighbor = edge[0], edgeLength = edge[1];
                    int newRouteCost = edgeLength + distances[currentNode];

                    // Update distance if a shorter route is found
                    if (distances[neighbor] > newRouteCost) {
                        distances[neighbor] = newRouteCost;
                        priorityQueue.add(new int[] { newRouteCost, neighbor });
                    }
                }
            }

            // Return the minimum distance or -1 if no path exists
            return ((distances[end] == Integer.MAX_VALUE) ? -1 : distances[end]);
        }

    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = { { 0, 2, 5 }, { 0, 1, 2 }, { 1, 2, 1 }, { 3, 0, 3 } };
        Graph g = new Graph(n, edges);
        System.out.println(g.shortestPath(3, 2)); // return 6. The shortest path from 3 to 2 in the first diagram above
                                                  // is 3 -> 0
        // -> 1 -> 2 with a total cost of 3 + 2 + 1 = 6.
        System.out.println(g.shortestPath(0, 3)); // return -1. There is no path from 0 to 3.
        int[] edge = { 1, 3, 4 };
        g.addEdge(edge); // We add an edge from node 1 to node 3, and we get the second diagram above.
        System.out.println(g.shortestPath(0, 3)); // return 6. The shortest path from 0 to 3 now is 0 -> 1 -> 3 with a
                                                  // total cost
        // of 2 + 4 = 6.
    }

}
