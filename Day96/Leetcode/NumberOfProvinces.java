//Leetcode
//547. Number of Provinces - By construction an adjacency list. Using DFS.
//Time complexity: O(N) + O(V+2E) becoz we are using adjacency list
//Space complexity: O(N)

package Leetcode;

import java.util.ArrayList;

public class NumberOfProvinces {

    public static void main(String[] args) {
        int[][] isConnected = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {
        // Convert matrix to adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int V = isConnected[0].length;
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int visited[] = new int[V + 1];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                count++;
                dfs(i, adj, visited);
            }
        }
        return count;
    }

    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        visited[node] = 1;
        for (Integer i : adj.get(node)) {
            if (visited[i] == 0) {
                dfs(i, adj, visited);
            }
        }
    }

}
