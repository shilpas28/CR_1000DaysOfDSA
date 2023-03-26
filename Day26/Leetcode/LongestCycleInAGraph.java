//Leetcode
//2360. Longest Cycle in a Graph
//Time complexity: O(N)
//Space complexity: O(N) 

package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestCycleInAGraph {

    public static void main(String[] args) {
        int[] edges = { 3, 3, 4, 2, 3 };
        System.out.println(longestCycle(edges));
    }

    public static int longestCycle(int[] edges) {
        int maxCycles = -1;
        int[] visited = new int[edges.length];
        for (int i = 0; i < edges.length; i++) {
            if (visited[i] == 1 || edges[i] == -1)
                continue;

            int cycle = longestCycle(i, edges, 0, visited, new HashMap<>());
            maxCycles = Math.max(maxCycles, cycle);
        }
        return maxCycles;
    }

    public static int longestCycle(int i, int[] edges, int step, int[] visited, Map<Integer, Integer> nodeToStep) {
        if (edges[i] == -1)
            return -1;

        if (nodeToStep.containsKey(i)) {
            return step - nodeToStep.get(i);
        }
        if (visited[i] == 1)
            return -1;

        visited[i] = 1;
        nodeToStep.put(i, step);
        return longestCycle(edges[i], edges, step + 1, visited, nodeToStep);
    }
}
