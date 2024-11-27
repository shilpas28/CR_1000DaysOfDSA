//Leetcode
//3243. Shortest Distance After Road Addition Queries I - BFS
//Time complexity: O(N^2)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ShortestDistanceAfterRoadAdditionQueriesI_2 {

    public static void main(String[] args) {
        int n = 5;
        int[][] queries = { { 2, 4 }, { 0, 2 }, { 0, 4 } };
        System.out.println(Arrays.toString(shortestDistanceAfterQueries(n, queries)));
    }

    public static int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            adj.get(i).add(i + 1);
        }

        List<Integer> resList = new ArrayList<>();
        for (int[] query : queries) {
            adj.get(query[0]).add(query[1]);
            resList.add(shortestPath(adj, n));
        }
        return resList.stream().mapToInt(Integer::intValue).toArray();
    }

    static int shortestPath(List<List<Integer>> adj, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0 }); // node, length
        Set<Integer> visit = new HashSet<>();
        visit.add(0);

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int cur = curr[0];
            int length = curr[1];

            if (cur == n - 1)
                return length;

            for (int nei : adj.get(cur)) {
                if (!visit.contains(nei)) {
                    q.offer(new int[] { nei, length + 1 });
                    visit.add(nei);
                }
            }
        }
        return -1;
    }
}
