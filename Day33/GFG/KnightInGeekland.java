//GFG
//Knight in Geekland
//Time complexity: O(N*M)
//Space complexity: O(N*M)

package GFG;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KnightInGeekland {

    public static void main(String[] args) {
        // int n = 9; // no of rows
        // int m = 10; // no of cols
        int start_x = 4, start_y = 5;
        int[][] arr = { { 0, 0, 0, 2, 0, 2, 0, 2, 0, 0 },
                { 0, 0, 2, 0, 2, 0, 2, 0, 2, 0 },
                { 0, 2, 0, 0, 1, 2, 0, 0, 0, 2 },
                { 0, 0, 2, 0, 2, 0, 2, 0, 2, 0 },
                { 0, 2, 0, 2, 0, 0, 0, 2, 0, 2 },
                { 0, 0, 2, 0, 2, 0, 2, 0, 2, 0 },
                { 0, 2, 0, 0, 0, 2, 0, 0, 0, 2 },
                { 0, 0, 2, 0, 2, 0, 2, 0, 2, 0 },
                { 0, 0, 0, 2, 0, 2, 0, 2, 0, 0 } };
        System.out.println(knightInGeekland(arr, start_x, start_y));
    }

    static int[] moves_x = { -2, -2, -1, -1, 1, 1, 2, 2 };
    static int[] moves_y = { -1, 1, -2, 2, 2, -2, 1, -1 };

    public static int knightInGeekland(int arr[][], int start_x, int start_y) {
        // Code Here.
        int n = arr.length, m = arr[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { start_x, start_y });

        boolean[][] visited = new boolean[n][m];
        visited[start_x][start_y] = true;
        ArrayList<Integer> points = new ArrayList<>();

        while (!q.isEmpty()) {
            int size = q.size();

            int sum = 0;
            for (int i = 0; i < size; i++) {
                int[] coor = q.poll();

                int curX = coor[0];
                int curY = coor[1];

                sum += arr[curX][curY];

                for (int index = 0; index < 8; index++) {
                    int xIndex = moves_x[index] + curX;
                    int yIndex = moves_y[index] + curY;

                    if (isValid(xIndex, yIndex, arr, visited)) {
                        visited[xIndex][yIndex] = true;
                        q.add(new int[] { xIndex, yIndex });
                    }
                }
            }
            points.add(sum);
        }

        int[] pointsArr = new int[points.size()];

        for (int i = 0; i < points.size(); i++)
            pointsArr[i] = points.get(i);

        int max = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = points.size() - 1; i >= 0; i--) {
            if (pointsArr[i] + i < points.size()) {
                pointsArr[i] += pointsArr[pointsArr[i] + i];
            }

            if (pointsArr[i] >= max) {
                max = pointsArr[i];
                ans = i;
            }
        }
        return ans;
    }

    public static boolean isValid(int i, int j, int[][] arr, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || visited[i][j] == true)
            return false;

        return true;
    }
}
