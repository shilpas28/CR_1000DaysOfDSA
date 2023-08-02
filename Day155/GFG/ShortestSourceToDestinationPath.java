//GFG
//Shortest Source to Destination Path
//Time complexity: O(N*M)
//Space complexity: O(N*M)

package GFG;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestSourceToDestinationPath {

    public static void main(String[] args) {
        int N = 3, M = 4;
        int[][] A = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 1, 1 } };
        int X = 2, Y = 3;
        System.out.println(shortestDistance(N, M, A, X, Y));
    }

    static int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // code here
        if (A[0][0] == 0)
            return -1;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        int path = 0;
        q.add(new int[] { 0, 0 });
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                if (cur[0] == X && cur[1] == Y)
                    return path;
                if (cur[0] + 1 < N && !visited[cur[0] + 1][cur[1]] && A[cur[0] + 1][cur[1]] == 1) {
                    q.add(new int[] { cur[0] + 1, cur[1] });
                    visited[cur[0] + 1][cur[1]] = true;
                }
                if (cur[0] - 1 >= 0 && !visited[cur[0] - 1][cur[1]] && A[cur[0] - 1][cur[1]] == 1) {
                    q.add(new int[] { cur[0] - 1, cur[1] });
                    visited[cur[0] - 1][cur[1]] = true;
                }
                if (cur[1] + 1 < M && !visited[cur[0]][cur[1] + 1] && A[cur[0]][cur[1] + 1] == 1) {
                    q.add(new int[] { cur[0], cur[1] + 1 });
                    visited[cur[0]][cur[1] + 1] = true;
                }
                if (cur[1] - 1 >= 0 && !visited[cur[0]][cur[1] - 1] && A[cur[0]][cur[1] - 1] == 1) {
                    q.add(new int[] { cur[0], cur[1] - 1 });
                    visited[cur[0]][cur[1] - 1] = true;
                }
            }
            path++;
        }
        return -1;
    }
}
