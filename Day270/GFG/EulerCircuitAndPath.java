//GFG
//Euler circuit and Path
//Time complexity: O(V+E) where E is the number of edges in graph.
//Space complexity: O(V)  

package GFG;

import java.util.ArrayList;
import java.util.List;

public class EulerCircuitAndPath {

    @SuppressWarnings(value = "all")
    public static void main(String[] args) {
        int V = 3;
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[0].add(1);
        adj[1].add(0);
        adj[1].add(2);
        adj[2].add(1);
        adj[2].add(0);
        adj[0].add(2);
        System.out.println(isEulerCircuit(V, adj));
    }

    public static int isEulerCircuit(int V, List<Integer>[] adj) {
        // code here
        int count = 0;
        for (int i = 0; i < V; i++)
            if (adj[i].size() % 2 == 1)
                count++;
        if (count == 0)
            return 2;
        return count == 2 ? 1 : 0;
    }
}
