//GFG
//Rotten Oranges
//Time complexity: O ( n x n ) x 4    
//Space complexity: O ( n x n )

package GFG;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static void main(String[] args) {
        int mat[][] = { { 0, 1, 2 }, { 0, 1, 2 }, { 2, 1, 1 } };
        System.out.println(orangesRotting(mat));
    }

    public static int orangesRotting(int[][] mat) {
        // Code here
        if (mat == null || mat.length == 0)
            return 0;
        int rows = mat.length;
        int cols = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;
        // Put the position of all rotten oranges in queue
        // count the number of fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                }
                if (mat[i][j] != 0) {
                    count_fresh++;
                }
            }
        }

        if (count_fresh == 0)
            return 0;
        int countMin = 0, cnt = 0;
        int dx[] = { 0, 0, 1, -1 };
        int dy[] = { 1, -1, 0, 0 };
        // bfs starting from initially rotten oranges
        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt += size;
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];

                    if (x < 0 || y < 0 || x >= rows || y >= cols || mat[x][y] == 0 ||
                            mat[x][y] == 2)
                        continue;

                    mat[x][y] = 2;
                    queue.offer(new int[] { x, y });
                }
            }
            if (queue.size() != 0) {
                countMin++;
            }
        }
        return count_fresh == cnt ? countMin : -1;
    }
}
