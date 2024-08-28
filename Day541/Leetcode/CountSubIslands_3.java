//Leetcode
//1905. Count Sub Islands - Optimized BFS
//Time complexity: O(m * n)
//Space complexity: O(m * n)

import java.util.LinkedList;
import java.util.Queue;

public class CountSubIslands_3 {

    public static void main(String[] args) {
        int[][] grid1 = { { 1, 1, 1, 0, 0 }, { 0, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0 },
                { 1, 1, 0, 1, 1 } };
        int[][] grid2 = { { 1, 1, 1, 0, 0 }, { 0, 0, 1, 1, 1 }, { 0, 1, 0, 0, 0 }, { 1, 0, 1, 1, 0 },
                { 0, 1, 0, 1, 0 } };
        System.out.println(countSubIslands(grid1, grid2));
    }

    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int count = 0;
        int[] dir = { 1, 0, -1, 0, 1 };

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid2[i][j] == 0)
                    continue;

                Queue<int[]> queue = new LinkedList<>();
                boolean flag = true;
                grid2[i][j] = 0;

                queue.add(new int[] { i, j });

                while (!queue.isEmpty()) {
                    int[] vtx = queue.remove();

                    if (grid1[vtx[0]][vtx[1]] == 0)
                        flag = false;

                    for (int k = 0; k < 4; ++k) {
                        int x = vtx[0] + dir[k];
                        int y = vtx[1] + dir[k + 1];

                        if (x >= 0 && x < m && y >= 0 && y < n && grid2[x][y] == 1) {
                            grid2[x][y] = 0;

                            queue.add(new int[] { x, y });
                        }
                    }
                }
                if (flag)
                    ++count;
            }
        }
        return count;
    }
}
