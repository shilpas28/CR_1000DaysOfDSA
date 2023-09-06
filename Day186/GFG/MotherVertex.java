//GFG - Not accepted as TLE
//Mother Vertex - using BFS
//Time complexity: O(V*(V+E))
//Space complexity: O(V)

package GFG;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MotherVertex {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> al1 = new ArrayList<>();
        al1.add(0);
        al1.add(1);
        adj.add(al1);
        ArrayList<Integer> al2 = new ArrayList<>();
        al2.add(0);
        al2.add(3);
        adj.add(al2);
        ArrayList<Integer> al3 = new ArrayList<>();
        al3.add(1);
        al3.add(0);
        adj.add(al3);
        ArrayList<Integer> al4 = new ArrayList<>();
        al4.add(2);
        al4.add(1);
        adj.add(al4);
        ArrayList<Integer> al5 = new ArrayList<>();
        al5.add(3);
        al5.add(4);
        adj.add(al5);
        int V = 5;
        System.out.println(findMotherVertex(V, adj));
    }

    static int ans;

    // Function to find a Mother Vertex in the Graph.
    public static int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int ans = -1;
        for (int i = 0; i < V; i++) {
            boolean[] vis = new boolean[V];
            vis[i] = true;

            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            int count = 1;
            while (!q.isEmpty()) {
                int curr = q.poll();

                for (int nei : adj.get(curr)) {
                    if (!vis[nei]) {
                        count++;
                        vis[nei] = true;
                        q.add(nei);
                    }
                }
            }
            if (count == V) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}
