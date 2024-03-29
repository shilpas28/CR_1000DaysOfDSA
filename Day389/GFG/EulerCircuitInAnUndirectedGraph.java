//GFG
//Euler Circuit in an Undirected Graph
//Time complexity: O(v + e)
//Space complexity: O(v)

package GFG;

import java.util.ArrayList;
import java.util.Arrays;

public class EulerCircuitInAnUndirectedGraph {

    public static void main(String[] args) {
        int v = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        adj.add(new ArrayList<>(Arrays.asList(0, 1)));
        adj.add(new ArrayList<>(Arrays.asList(0, 2)));
        adj.add(new ArrayList<>(Arrays.asList(1, 3)));
        adj.add(new ArrayList<>(Arrays.asList(2, 3)));
        System.out.println(isEularCircuitExist(v, adj));
    }

    public static boolean isEularCircuitExist(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        for (int i = 0; i < v; ++i) {
            if (adj.get(i).size() % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
