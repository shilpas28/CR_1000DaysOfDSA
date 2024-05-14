//GFG
//Path With Minimum Effort
//Time complexity: O(rows*columns)
//Space complexity: O(rows*columns)

package GFG;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PathWithMinimumEffort {

    public static void main(String[] args) {
        int row = 3;
        int columns = 3;
        int[][] heights = { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } };
        System.out.println(MinimumEffort(row, columns, heights));
    }

    public static int MinimumEffort(int rows, int columns, int[][] heights) {
        // code here
        Queue<int[]> q = new LinkedList<>();
        int vis[][] = new int[rows][columns];
        for (int temp[] : vis) {
            Arrays.fill(temp, Integer.MAX_VALUE);
        }
        int x[] = { -1, 0, 1, 0 };
        int y[] = { 0, 1, 0, -1 };
        int temp[] = { 0, 0, 0 };
        q.add(temp);
        while (q.size() != 0) {
            temp = q.remove();
            int i = temp[1];
            int j = temp[2];
            int dis = temp[0];
            for (int k = 0; k < 4; k++) {
                int newi = i + x[k];
                int newj = j + y[k];
                if (newi >= 0 && newi < rows && newj >= 0 && newj < columns) {
                    int newd = Math.max(dis, Math.abs(heights[newi][newj] - heights[i][j]));
                    if (newd < vis[newi][newj]) {
                        int newArray[] = { newd, newi, newj };
                        q.add(newArray);
                        vis[newi][newj] = newd;
                    }
                }
            }
        }
        return vis[rows - 1][columns - 1] != Integer.MAX_VALUE ? vis[rows - 1][columns - 1] : 0;
    }
}
