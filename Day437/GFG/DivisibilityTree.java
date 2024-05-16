//GFG
//Divisibility tree
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

import java.util.ArrayList;
import java.util.Arrays;

public class DivisibilityTree {

    public static void main(String[] args) {
        int n = 10;
        int[][] edges = { { 2, 1 }, { 3, 1 }, { 4, 3 }, { 5, 2 }, { 6, 1 }, { 7, 2 }, { 8, 6 }, { 9, 8 }, { 10, 8 } };
        System.out.println(minimumEdgeRemove(n, edges));
    }

    static int ans = 0;

    public static int minimumEdgeRemove(int n, int[][] edges) {
        // code here
        ans = 0;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int x[] : edges) {
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);
        }
        int vis[] = new int[n + 1];
        Arrays.fill(vis, 0);
        for (int i = 1; i <= n; i++) {
            if (vis[i] == 0) {
                help(adj, vis, i);
            }
        }
        return ans;
    }

    static int help(ArrayList<ArrayList<Integer>> adj, int vis[], int node) {
        vis[node] = 1;
        int size = 1;
        for (int x : adj.get(node)) {
            if (vis[x] == 0) {
                int temp = help(adj, vis, x);
                size += temp;
                if (temp % 2 == 0)
                    ans++;
            }
        }
        return size;
    }
}
