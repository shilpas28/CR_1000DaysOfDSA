//Leetcode
//1368. Minimum Cost to Make at Least One Valid Path in a Grid - Depth-First Search + Breadth-First Search
//Time complexity: O(n*m)
//Space complexity: O(n*m) 

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumCostToMakeAtLeastOneValidPathInAGrid_4 {

    public static void main(String[] args) {
        int[][] grid = { { 1, 1, 1, 1 }, { 2, 2, 2, 2 }, { 1, 1, 1, 1 }, { 2, 2, 2, 2 } };
        System.out.println(minCost(grid));
    }

    // Direction vectors: right, left, down, up (matching grid values 1,2,3,4)
    static final int[][] dirs = new int[][] {
            { 0, 1 },
            { 0, -1 },
            { 1, 0 },
            { -1, 0 },
    };

    public static int minCost(int[][] grid) {
        int numRows = grid.length, numCols = grid[0].length, cost = 0;
        // Track minimum cost to reach each cell
        int[][] minCost = new int[numRows][numCols];
        for (int row = 0; row < numRows; row++) {
            Arrays.fill(minCost[row], Integer.MAX_VALUE);
        }
        // Queue for BFS part - stores cells that need cost increment
        Queue<int[]> queue = new LinkedList<>();
        // Start DFS from origin with cost 0
        dfs(grid, 0, 0, minCost, cost, queue);
        // BFS part - process cells level by level with increasing cost
        while (!queue.isEmpty()) {
            cost++;
            int levelSize = queue.size();

            while (levelSize-- > 0) {
                int[] curr = queue.poll();
                int row = curr[0], col = curr[1];
                // Try all 4 directions for next level
                for (int dir = 0; dir < 4; dir++) {
                    dfs(
                            grid,
                            row + dirs[dir][0],
                            col + dirs[dir][1],
                            minCost,
                            cost,
                            queue);
                }
            }
        }
        return minCost[numRows - 1][numCols - 1];
    }

    // DFS to explore all reachable cells with current cost
    static void dfs(
            int[][] grid,
            int row,
            int col,
            int[][] minCost,
            int cost,
            Queue<int[]> queue) {
        if (!isUnvisited(minCost, row, col))
            return;

        minCost[row][col] = cost;
        queue.offer(new int[] { row, col });
        // Follow the arrow direction without cost increase
        int nextDir = grid[row][col] - 1;
        dfs(
                grid,
                row + dirs[nextDir][0],
                col + dirs[nextDir][1],
                minCost,
                cost,
                queue);
    }

    // Check if cell is within bounds and unvisited
    static boolean isUnvisited(int[][] minCost, int row, int col) {
        return (row >= 0 &&
                col >= 0 &&
                row < minCost.length &&
                col < minCost[0].length &&
                minCost[row][col] == Integer.MAX_VALUE);
    }
}
