//Leetcode
//3372. Maximize the Number of Target Nodes After Connecting Trees I - Using BFS
//Time complexity: O(Nlog(E+V))
//Space complexity: O(N+O(E+V))

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximizeTheNumberOfTargetNodesAfterConnectingTreesI_2 {

    public static void main(String[] args) {
        int[][] edges1 = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 2, 4 } };
        int[][] edges2 = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 2, 7 }, { 1, 4 }, { 4, 5 }, { 4, 6 } };
        int k = 2;
        System.out.println(Arrays.toString(maxTargetNodes(edges1, edges2, k)));
    }

    public static int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<List<Integer>> adj1 = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj1.add(new ArrayList<>());
        for (int[] edge : edges1) {
            int a = edge[0];
            int b = edge[1];
            adj1.get(a).add(b);
            adj1.get(b).add(a);
        }

        List<List<Integer>> adj2 = new ArrayList<>();
        for (int i = 0; i < m; i++)
            adj2.add(new ArrayList<>());
        for (int[] edge : edges2) {
            int a = edge[0];
            int b = edge[1];
            adj2.get(a).add(b);
            adj2.get(b).add(a);
        }

        int[] t1 = new int[n];
        int[] t2 = new int[m];
        findTarget(adj1, t1, n, k);
        findTarget(adj2, t2, m, k - 1);

        int[] res = new int[n];
        int max = 0;
        
        for (int it : t2)
            max = Math.max(max, it);
        for (int i = 0; i < n; i++) {
            res[i] = t1[i] + max;
        }
        return res;
    }

    static void findTarget(List<List<Integer>> adj, int[] t, int n, int k) {
        if (k < 0)
            return;
        for (int i = 0; i < n; i++) {
            Queue<int[]> queue = new LinkedList<>();
            int[] vis = new int[n];
            queue.offer(new int[] { i, 0 });
            vis[i] = 1;
            int tar = 0;
            while (!queue.isEmpty()) {
                int node = queue.peek()[0];
                int dist = queue.peek()[1];
                queue.poll();
                tar++;
                for (int it : adj.get(node)) {
                    if (dist + 1 <= k && vis[it] == 0) {
                        vis[it] = 1;
                        queue.offer(new int[] { it, dist + 1 });
                    }
                }
            }
            t[i] = tar;
        }
    }
}
