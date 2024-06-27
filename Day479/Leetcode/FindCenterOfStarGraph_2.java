//Leetcode
//1791. Find Center of Star Graph
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.HashMap;
import java.util.Map;

public class FindCenterOfStarGraph_2 {

    public static void main(String[] args) {
        int[][] edges = { { 1, 2 }, { 2, 3 }, { 4, 2 } };
        System.out.println(findCenter(edges));
    }

    public static int findCenter(int[][] edges) {
        Map<Integer, Integer> adj = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];
            adj.put(u, adj.getOrDefault(u, 0) + 1);
            adj.put(v, adj.getOrDefault(v, 0) + 1);

        }
        for (int num : adj.keySet()) {
            if (adj.get(num) == edges.length) {
                return num;
            }
        }
        return -1;
    }
}
