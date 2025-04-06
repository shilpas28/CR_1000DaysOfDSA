//GFG
//Topological sort - Using DFS
//Time complexity: O(V+E)
//Space complexity: O(V)

package GFG;

import java.util.ArrayList;
import java.util.Arrays;

public class TopologicalSort {

    public static void main(String[] args) {
        int V = 4;
        int edges[][] = { { 3, 0 }, { 1, 0 }, { 2, 0 } };
        System.out.println(topoSort(V, edges));
    }

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> revadj = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++)
            revadj.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            revadj.get(v).add(u);
        }
        int visited[] = new int[V];
        Arrays.fill(visited, 0);
        for (int i = 0; i < V; i++)
            if (visited[i] == 0)
                solve(visited, revadj, i, ans);
        return ans;
    }

    public static void solve(int visited[], ArrayList<ArrayList<Integer>> revadj, int u, ArrayList<Integer> ans) {
        for (int w : revadj.get(u)) {
            if (visited[w] == 0)
                solve(visited, revadj, w, ans);
        }
        visited[u] = 1;
        ans.add(u);
    }
}
