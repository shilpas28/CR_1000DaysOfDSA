//Leetcode
//684. Redundant Connection - BFS 
//Time complexity: O(N^2)
//Space complexity: O(N)

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class RedundantConnection_2 {

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
            if (bfs(map, edge[0], edge[1]))
                return edge;
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        return new int[] { -1, -1 };
    }

    static boolean bfs(Map<Integer, Set<Integer>> map,
            int src, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        Set<Integer> visited = new HashSet<>();
        visited.add(src);

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == target)
                return true;
            for (int next : map.get(cur)) {
                if (visited.add(next)) {
                    q.offer(next);
                }
            }
        }
        return false;
    }
}
