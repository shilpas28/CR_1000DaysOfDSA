//Leetcode
//2658. Maximum Number of Fish in a Grid - Breadth First Search
//Time complexity: O(m*n)
//Space complexity: O(m*n) 

package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumNumberOfFishInAGrid_2 {

    public static void main(String[] args) {
        int[][] grid = { { 0, 2, 1, 0 }, { 4, 0, 0, 3 }, { 1, 0, 0, 4 }, { 0, 3, 2, 0 } };
        System.out.println(findMaxFish(grid));
    }

    public static int findMaxFish(int[][] grid) {
        int numRows = grid.length, numCols = grid[0].length, result = 0;
        boolean[][] visited = new boolean[numRows][numCols];
        // Iterating through the entire grid
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] != 0 && !visited[i][j]) {
                    result = Math.max(result, countFishes(grid, visited, i, j));
                }
            }
        }
        return result;
    }

    // Function to perform BFS and count fishes in the connected component
    static int countFishes(
            int[][] grid,
            boolean[][] visited,
            int row,
            int col) {
        int numRows = grid.length, numCols = grid[0].length, fishCount = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { row, col });
        visited[row][col] = true;
        // Directions for exploring up, down, left, right
        int[] rowDirections = { 0, 0, 1, -1 };
        int[] colDirections = { 1, -1, 0, 0 };
        // BFS traversal
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            row = cell[0];
            col = cell[1];
            fishCount += grid[row][col];
            // Exploring all four directions
            for (int i = 0; i < 4; i++) {
                int newRow = row + rowDirections[i];
                int newCol = col + colDirections[i];
                if (0 <= newRow &&
                        newRow < numRows &&
                        0 <= newCol &&
                        newCol < numCols &&
                        grid[newRow][newCol] != 0 &&
                        !visited[newRow][newCol]) {
                    q.add(new int[] { newRow, newCol });
                    visited[newRow][newCol] = true;
                }
            }
        }
        return fishCount;
    }
}
