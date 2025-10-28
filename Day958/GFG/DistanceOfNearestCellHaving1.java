//GFG
//Distance of nearest cell having 1
//Time complexity: O(n * m)
//Space complexity: O(n * m)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellHaving1 {

    public static void main(String[] args) {
        int grid[][] = { { 0, 1, 1, 0 },
                { 1, 1, 0, 0 },
                { 0, 0, 1, 1 } };
        System.out.println(nearest(grid));
    }

    public static ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        // code here
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0)
                    grid[i][j] = -1;
                else {
                    grid[i][j] = 0;
                    q.add(new int[] { i, j });
                }
            }
        }

        while (!q.isEmpty()) {
            int r = q.peek()[0];
            int c = q.remove()[1];

            if (r + 1 < n && grid[r + 1][c] == -1) {
                grid[r + 1][c] = grid[r][c] + 1;
                q.add(new int[] { r + 1, c });
            }
            if (r - 1 >= 0 && grid[r - 1][c] == -1) {
                grid[r - 1][c] = grid[r][c] + 1;
                q.add(new int[] { r - 1, c });
            }
            if (c + 1 < m && grid[r][c + 1] == -1) {
                grid[r][c + 1] = grid[r][c] + 1;
                q.add(new int[] { r, c + 1 });
            }
            if (c - 1 >= 0 && grid[r][c - 1] == -1) {
                grid[r][c - 1] = grid[r][c] + 1;
                q.add(new int[] { r, c - 1 });
            }
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                list.add(grid[i][j]);
            }
            ans.add(list);
        }

        return ans;
    }
}
