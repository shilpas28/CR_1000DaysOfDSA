//GFG
//Shortest Path in Weighted undirected graph
//Time complexity: O(m* log(n))
//Space complexity: O(n+m)

package GFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPathInWeightedUndirectedGraph {

    static class Data {
        int nbr;
        int wgt;

        Data(int nbr, int wgt) {
            this.nbr = nbr;
            this.wgt = wgt;
        }
    }

    public static void main(String[] args) {
        int n = 5, m = 6;
        int[][] edges = { { 1, 2, 2 }, { 2, 5, 5 }, { 2, 3, 4 }, { 1, 4, 1 }, { 4, 3, 3 }, { 3, 5, 1 } };
        System.out.println(shortestPath(n, m, edges));
    }

    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // Code Here.
        List<List<Data>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int e[] : edges) {
            adj.get(e[0]).add(new Data(e[1], e[2]));
            adj.get(e[1]).add(new Data(e[0], e[2]));
        }
        return dijkstra(n, adj);
    }

    static List<Integer> dijkstra(int n, List<List<Data>> adj) {
        int w[] = new int[n + 1];
        int par[] = new int[n + 1];
        Arrays.fill(w, Integer.MAX_VALUE);
        w[1] = 0;
        par[1] = 1;

        // vtx,wgt
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[] { 1, 0 });

        while (!pq.isEmpty()) {
            int pop[] = pq.remove();
            int cur_node = pop[0], cur_wgt = pop[1];

            for (Data nbr_nodes : adj.get(cur_node)) {
                int nbr_node = nbr_nodes.nbr, nbr_wgt = nbr_nodes.wgt;

                if (cur_wgt + nbr_wgt < w[nbr_node]) {
                    w[nbr_node] = cur_wgt + nbr_wgt;
                    par[nbr_node] = cur_node;
                    pq.add(new int[] { nbr_node, w[nbr_node] });
                }
            }
        }

        if (w[n] == Integer.MAX_VALUE) {
            List<Integer> ans = new ArrayList<>();
            ans.add(-1);
            return ans;
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(w[n]);
        int node = n;
        while (par[node] != node) {
            ans.add(node);
            node = par[node];
        }
        ans.add(node);
        return ans;
    }
}
