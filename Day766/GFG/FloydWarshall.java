//GFG
//Floyd Warshall
//Time complexity: O(V^3), as we have three nested loops each running for V times, where V = no. of vertices.
//Space complexity: O(V^2), where V = no. of vertices. This space complexity is due to storing the adjacency matrix of the given graph.

package GFG;

public class FloydWarshall {

    public static void main(String[] args) {
        int dist[][] = { { 0, -1, 2 }, { 1, 0, (int) Math.pow(10, 8) }, { 3, 1, 0 } };
        floydWarshall(dist);
        for (int row[] : dist) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void floydWarshall(int[][] dist) {
        // Code here
        int n = dist.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == Integer.MAX_VALUE) {
                    dist[i][j] = (int) (1e9);
                }
                if (i == j)
                    dist[i][j] = 0;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j],
                            dist[i][k] + dist[k][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == (int) (1e9)) {
                    dist[i][j] = -1;
                }
            }
        }
    }
}
