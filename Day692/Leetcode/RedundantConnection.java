//Leetcode
//684. Redundant Connection - DFS 
//Time complexity: O(N^2)
//Space complexity: O(N)

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RedundantConnection {

    public static void main(String[] args) {
        int[][] edges = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
        System.out.println(Arrays.toString(findRedundantConnection(edges)));
    }

    public static int[] findRedundantConnection(int[][] edges) {
        int m = edges.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            map.put(i, new HashSet<>());
        }

        for (int[] edge : edges) {
            if (dfs(new HashSet<>(), map, edge[0], edge[1]))
                return edge;
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        return new int[] { -1, -1 };
    }

    static boolean dfs(Set<Integer> visited, Map<Integer, Set<Integer>> map,
            int src, int target) {
        if (src == target)
            return true;
        visited.add(src);
        for (int next : map.get(src)) {
            if (!visited.contains(next)) {
                if (dfs(visited, map, next, target))
                    return true;
            }
        }
        return false;
    }
}
