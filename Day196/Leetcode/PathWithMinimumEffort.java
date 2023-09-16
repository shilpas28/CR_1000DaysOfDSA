//Leetcode
//1631. Path With Minimum Effort
//Time complexity: O( 4*N*M * log( N*M) ) { N*M are the total cells, for each of which we also check 4 adjacent nodes for the 
//minimum effort and additional log(N*M) for insertion-deletion operations in a priority queue } 
//Where, N = No. of rows of the binary maze and M = No. of columns of the binary maze.
//Space complexity: O( N*M ) { Distance matrix containing N*M cells + priority queue in the worst case 
    //containing all the nodes ( N*M) }. Where, N = No. of rows of the binary maze and M = No. of columns of the binary maze.

package Leetcode;

import java.util.PriorityQueue;

public class PathWithMinimumEffort {

    static class Tuple {
        int distance;
        int row;
        int col;

        public Tuple(int distance, int row, int col) {
            this.row = row;
            this.distance = distance;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        int[][] heights = { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } };
        System.out.println(minimumEffortPath(heights));
    }

    public static int minimumEffortPath(int[][] heights) {
        // Create a priority queue containing pairs of cells
        // and their respective distance from the source cell in the
        // form {diff, {row of cell, col of cell}}.
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x, y) -> x.distance - y.distance);

        int n = heights.length;
        int m = heights[0].length;
        // Create a distance matrix with initially all the cells marked as
        // unvisited and the dist for source cell (0,0) as 0.
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = (int) (1e9);
            }
        }

        dist[0][0] = 0;
        pq.add(new Tuple(0, 0, 0));
        // The following delta rows and delts columns array are created such that
        // each index represents each adjacent node that a cell may have
        // in a direction.
        int dr[] = { -1, 0, 1, 0 };
        int dc[] = { 0, 1, 0, -1 };
        // Iterate through the matrix by popping the elements out of the queue
        // and pushing whenever a shorter distance to a cell is found.
        while (pq.size() != 0) {
            Tuple it = pq.peek();
            pq.remove();
            int diff = it.distance;
            int row = it.row;
            int col = it.col;
            // Check if we have reached the destination cell,
            // return the current value of difference (which will be min).
            if (row == n - 1 && col == m - 1)
                return diff;
            // row - 1, col
            // row, col + 1
            // row - 1, col
            // row, col - 1
            for (int i = 0; i < 4; i++) {
                int newr = row + dr[i];
                int newc = col + dc[i];
                // Checking validity of the cell.
                if (newr >= 0 && newc >= 0 && newr < n && newc < m) {
                    // Effort can be calculated as the max value of differences
                    // between the heights of the node and its adjacent nodes.
                    int newEffort = Math.max(
                            Math.abs(heights[row][col] - heights[newr][newc]), diff);
                    // If the calculated effort is less than the prev value
                    // we update as we need the min effort.
                    if (newEffort < dist[newr][newc]) {
                        dist[newr][newc] = newEffort;
                        pq.add(new Tuple(newEffort, newr, newc));
                    }
                }
            }
        }
        // If the destination is unreachable.
        return 0;
    }
}
