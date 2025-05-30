//Leetcode
//2359. Find Closest Node to Given Two Nodes - DFS
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.Arrays;

public class FindClosestNodeToGivenTwoNodes {

    public static void main(String[] args) {
        int[] edges = { 2, 2, 3, -1 };
        int node1 = 0, node2 = 1;
        System.out.println(closestMeetingNode(edges, node1, node2));
    }

    public static int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n], dist2 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dist1[node1] = 0;
        dist2[node2] = 0;

        Boolean[] visit1 = new Boolean[n], visit2 = new Boolean[n];
        Arrays.fill(visit1, Boolean.FALSE);
        Arrays.fill(visit2, Boolean.FALSE);

        dfs(node1, edges, dist1, visit1);
        dfs(node2, edges, dist2, visit2);

        int minDistNode = -1, minDistTillNow = Integer.MAX_VALUE;
        for (int currNode = 0; currNode < n; currNode++) {
            if (minDistTillNow > Math.max(dist1[currNode], dist2[currNode])) {
                minDistNode = currNode;
                minDistTillNow = Math.max(dist1[currNode], dist2[currNode]);
            }
        }

        return minDistNode;
    }

    static void dfs(int node, int[] edges, int[] dist, Boolean[] visit) {
        visit[node] = true;
        int neighbor = edges[node];
        if (neighbor != -1 && !visit[neighbor]) {
            dist[neighbor] = 1 + dist[node];
            dfs(neighbor, edges, dist, visit);
        }
    }
}
