//Leetcode
//2685. Count the Number of Complete Components - Adjacency List
//Time complexity: O(n+mlogn)
//Space complexity: O(n+m+S)

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public class CountTheNumberOfCompleteComponents {

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 3, 4 } };
        System.out.println(countCompleteComponents(n, edges));
    }

    public static int countCompleteComponents(int n, int[][] edges) {
        // Adjacency lists for each vertex
        List<Integer>[] graph = new ArrayList[n];
        // Map to store frequency of each unique adjacency list
        Map<List<Integer>, Integer> componentFreq = new HashMap<>();
        // Initialize adjacency lists with self-loops
        for (int vertex = 0; vertex < n; vertex++) {
            graph[vertex] = new ArrayList<>();
            graph[vertex].add(vertex);
        }
        // Build adjacency lists from edges
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        // Count frequency of each unique adjacency pattern
        for (int vertex = 0; vertex < n; vertex++) {
            List<Integer> neighbors = graph[vertex];
            Collections.sort(neighbors);
            componentFreq.put(
                    neighbors,
                    componentFreq.getOrDefault(neighbors, 0) + 1);
        }
        // Count complete components where size equals frequency
        int completeCount = 0;
        for (Map.Entry<List<Integer>, Integer> entry : componentFreq.entrySet()) {
            if (entry.getKey().size() == entry.getValue()) {
                completeCount++;
            }
        }
        return completeCount;
    }
}
