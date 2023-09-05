//GFG
//Print adjacency list
//Time complexity: O(V + E)
//Space complexity: O(V + E)

package GFG;

import java.util.ArrayList;
import java.util.List;

public class PrintAdjacencyList {

    public static void main(String[] args) {
        int[][] edges = { { 0, 1 }, { 0, 4 }, { 4, 1 }, { 4, 3 }, { 1, 3 }, { 1, 2 }, { 3, 2 } };
        int V = 5;
        List<List<Integer>> res = printGraph(V, edges);
        System.out.println(res);
    }

    public static List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < V; i++)
            list.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }
        return list;
    }
}
