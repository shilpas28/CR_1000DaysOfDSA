//GFG
//Avoid Explosion - Brute force
//Time complexity:
//Space complexity:
package GFG;

import java.util.ArrayList;

public class AvoidExplosion {

    public static void main(String[] args) {
        int n = 5, m = 2;
        int[][] mix = { { 1, 2 }, { 2, 3 }, { 4, 5 }, { 3, 5 }, { 2, 4 } };
        int[][] danger = { { 1, 3 }, { 4, 2 } };
        System.out.println(avoidExplosion(mix, n, danger, m));
    }

    public static ArrayList<String> avoidExplosion(int mix[][], int n, int danger[][], int m) {

        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = mix[i][0], y = mix[i][1];
            graph.get(x).add(y);
            graph.get(y).add(x);

            boolean safe = true;

            for (int[] dd : danger) {
                int u = dd[0], v = dd[1];

                if (pathExists(u, v, graph)) {
                    safe = false;
                    break;
                }
            }

            ans.add(safe ? "Yes" : "No");
            if (!safe) {
                graph.get(x).remove(graph.get(x).size() - 1);
                graph.get(y).remove(graph.get(y).size() - 1);
            }
        }
        return ans;
    }

    static boolean pathExists(int u, int v, ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[graph.size() + 1];
        return solve(u, v, graph, visited);
    }

    static boolean solve(int u, int v, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        if (u == v)
            return true;
        boolean ans = false;
        visited[u] = true;
        for (Integer in : graph.get(u)) {
            if (visited[in] == false)
                ans = ans || solve(in, v, graph, visited);
        }
        return ans;
    }

}
