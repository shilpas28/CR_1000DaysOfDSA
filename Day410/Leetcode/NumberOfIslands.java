//Leetcode
//200. Number of Islands
//Time complexity: O(M*N)
//Space complexity: O(M*N)

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {

        char[][] grid = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    count++;
                    bfs(i, j, vis, grid);
                }
            }
        }
        return count;
    }

    public static void bfs(int row, int col, int[][] vis, char[][] grid) {
        vis[row][col] = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(row, col));
        int m = grid.length;
        int n = grid[0].length;
        int[] delRow = { -1, +0, +1, +0 };
        int[] delCol = { +0, +1, +0, -1 };
        while (!q.isEmpty()) {
            row = q.peek().first;
            col = q.peek().second;
            q.remove();
            for (int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1') {
                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1;
                }
            }
        }
    }
}
