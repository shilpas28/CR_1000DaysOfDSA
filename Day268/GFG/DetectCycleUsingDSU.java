//GFG
//Detect Cycle using DSU
//Time complexity: O(V+E)
//Space complexity: O(V) 

package GFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DetectCycleUsingDSU {

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(0, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0, 3)));
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.add(new ArrayList<>(Arrays.asList(2, 4)));
        adj.add(new ArrayList<>(Arrays.asList(1, 3)));
        System.out.println(detectCycle(V, adj));
    }

    static int[] parent;
    static int[] depth;

    static int findparent(int vertex) {
        if (vertex == parent[vertex]) {
            return vertex;
        }
        return parent[vertex] = findparent(parent[vertex]);
    }

    // Function to detect cycle using DSU in an undirected graph.
    public static int detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int n = V;
        parent = new int[n];
        depth = new int[n];
        Map<Integer, Map<Integer, Integer>> mp = new HashMap<>();
        Arrays.fill(depth, 1);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int a = 0; a < n; a++) {
            for (int b : adj.get(a)) {
                if (mp.containsKey(a) && mp.get(a).containsKey(b)) {
                    continue;
                }
                if (mp.containsKey(b) && mp.get(b).containsKey(a)) {
                    continue;
                }
                if (!mp.containsKey(a)) {
                    mp.put(a, new HashMap<>());
                }
                mp.get(a).put(b, 1);
                int a_parent = findparent(a);
                int b_parent = findparent(b);
                if (a_parent != b_parent) {
                    if (depth[a_parent] > depth[b_parent]) {
                        parent[b_parent] = a_parent;
                        depth[a_parent] += depth[b_parent];
                    } else if (depth[a_parent] < depth[b_parent]) {
                        parent[a_parent] = b_parent;
                        depth[b_parent] += depth[a_parent];
                    } else {
                        parent[a_parent] = b_parent;
                        depth[b_parent] += depth[a_parent];
                    }
                } else {
                    return 1;
                }
            }
        }
        return 0;
    }
}
