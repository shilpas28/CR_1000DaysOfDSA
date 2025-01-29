//Leetcode
//684. Redundant Connection - Union Find 
//Time complexity: O(N * α(N))
//Space complexity: O(N)

import java.util.Arrays;

public class RedundantConnection_3 {

    public static void main(String[] args) {
        int[][] edges = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
        System.out.println(Arrays.toString(findRedundantConnection(edges)));
    }

    static int[] parent;

    public static int[] findRedundantConnection(int[][] edges) {
        int m = edges.length;
        parent = new int[m + 1];
        for (int i = 0; i < m; i++)
            parent[i] = i;

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1]))
                return edge;
        }
        return new int[] { -1, -1 };
    }

    static boolean union(int x, int y) {
        int p1 = find(x), p2 = find(y);
        if (p1 == p2)
            return false;
        parent[p1] = p2;
        return true;
    }

    static int find(int x) {
        while (x != parent[x]) {
            x = parent[x];
            parent[x] = parent[parent[x]];
        }
        return x;
    }
}
