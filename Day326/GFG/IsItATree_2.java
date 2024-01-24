//GFG
//Is it a tree ?
//Time complexity: O(N+M)
//Space complexity: O(N)

package GFG;

import java.util.ArrayList;
import java.util.Arrays;

public class IsItATree_2 {

    public static void main(String[] args) {
        int N = 4, M = 3;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(Arrays.asList(0, 1)));
        edges.add(new ArrayList<>(Arrays.asList(1, 2)));
        edges.add(new ArrayList<>(Arrays.asList(1, 3)));
        System.out.println(isTree(N, M, edges));
    }

    @SuppressWarnings("all")
    public static boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        // code here
        if (n - m != 1)
            return false;
        ArrayList<Integer>[] adj = new ArrayList[n];
        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            adj[edges.get(i).get(0)].add(edges.get(i).get(1));
            adj[edges.get(i).get(1)].add(edges.get(i).get(0));
        }

        dfs(0, adj, arr);

        for (int k : arr)
            if (k == 0)
                return false;
        return true;
    }

    static void dfs(int n, ArrayList<Integer>[] adj, int arr[]) {
        arr[n] = 1;
        for (int x : adj[n])
            if (arr[x] == 0)
                dfs(x, adj, arr);
    }
}
