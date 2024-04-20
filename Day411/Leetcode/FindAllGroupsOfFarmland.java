//Leetcode
//1992. Find All Groups of Farmland - Using DFS
//Time complexity: O(N*M)
//Space complexity: O(N*M)

package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class FindAllGroupsOfFarmland {

    public static void main(String[] args) {
        int[][] land = { { 1, 0, 0 }, { 0, 1, 1 }, { 0, 1, 1 } };
        int[][] res = findFarmland(land);
        for (int[] row : res) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static int[][] findFarmland(int[][] land) {
        int rows = land.length;
        int cols = land[0].length;
        Set<String> visited = new HashSet<>();
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (land[i][j] == 1 && !visited.contains(i + "," + j)) {
                    int[] bounds = dfs(land, visited, i, j);
                    result.add(bounds);
                }
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    static int[] dfs(int[][] land, Set<String> visited, int x, int y) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] { x, y });
        visited.add(x + "," + y);

        int minRow = x, minCol = y;
        int maxRow = x, maxCol = y;

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int curX = current[0], curY = current[1];

            int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
            for (int[] dir : directions) {
                int nx = curX + dir[0];
                int ny = curY + dir[1];

                if (nx >= 0 && nx < land.length && ny >= 0 && ny < land[0].length &&
                        land[nx][ny] == 1 && !visited.contains(nx + "," + ny)) {
                    visited.add(nx + "," + ny);
                    stack.push(new int[] { nx, ny });
                    minRow = Math.min(minRow, nx);
                    minCol = Math.min(minCol, ny);
                    maxRow = Math.max(maxRow, nx);
                    maxCol = Math.max(maxCol, ny);
                }
            }
        }

        return new int[] { minRow, minCol, maxRow, maxCol };
    }
}
