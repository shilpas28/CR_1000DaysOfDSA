//GFG
//Geek's Village and Wells
//Time complexity: O(n * m)
//Space complexity: O(n * m)

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GeeksVillageAndWells {
    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        char c[][] = { { 'H', 'H', 'H' },
                { 'H', 'W', 'H' },
                { 'H', 'H', 'H' } };
        int[][] res = chefAndWells(n, m, c);
        for (int[] i : res) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static int[][] chefAndWells(int n, int m, char c[][]) {
        // code here
        // Initialize the distances array with all values as -1
        int[][] distances = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distances[i], -1);
        }

        // Define the directions of movement
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        // Create a queue for breadth-first search
        Queue<int[]> q = new LinkedList<>();
        // Find all wells and set their distances to 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (c[i][j] == 'W') {
                    q.offer(new int[] { i, j, 0 }); // Add well coordinates to queue
                    distances[i][j] = 0; // Set distance to well as 0
                } else if (c[i][j] == 'N') {
                    distances[i][j] = 0; // Set distance to prohibited area as 0
                }
            }
        }
        // Perform breadth-first search to find shortest distance to houses from wells
        while (!q.isEmpty()) {
            int[] curr = q.poll(); // Get coordinates and distance of current node from queue
            int currX = curr[0], currY = curr[1], currD = curr[2];
            for (int i = 0; i < 4; i++) { // Check all four directions of movement
                int nextX = currX + dx[i], nextY = currY + dy[i];
                // Check if next node is within grid limits and has not been visited before
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && distances[nextX][nextY] == -1) {
                    if (c[nextX][nextY] == '.') {
                        q.offer(new int[] { nextX, nextY, currD + 2 }); // Add coordinates and distance of next node to
                                                                        // queue
                        distances[nextX][nextY] = 0; // Set distance to water as 0
                    } else if (c[nextX][nextY] == 'H') {
                        // Add coordinates and distance of next node to queue
                        q.offer(new int[] { nextX, nextY, currD + 2 });
                        // Set distance to house as current distance + 2
                        distances[nextX][nextY] = currD + 2;
                    }
                }
            }
        }
        // Set distances to water bodies as 0 and to unreachable houses as -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (c[i][j] == '.') {
                    distances[i][j] = 0;
                }
            }
        }
        // Return the distances array
        return distances;
    }
}
