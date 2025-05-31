//Leetcode
//909. Snakes and Ladders
//Time complexity: O(N^2)
//Space complexity: O(N^2)

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {

    public static void main(String[] args) {
        int[][] board = { { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 },
                { -1, 35, -1, -1, 13, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, 15, -1, -1, -1, -1 } };
        System.out.println(snakesAndLadders(board));
    }

    public static int snakesAndLadders(int[][] board) {
        int n = board.length;
        int moves = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        q.add(1);
        visited[n - 1][0] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int currBoardVal = q.poll();
                if (currBoardVal == n * n)
                    return moves;
                for (int diceVal = 1; diceVal <= 6; diceVal++) {
                    if (currBoardVal + diceVal > n * n)
                        break;
                    int[] pos = findCoordinates(currBoardVal + diceVal, n);
                    int row = pos[0];
                    int col = pos[1];
                    if (visited[row][col] == false) {
                        visited[row][col] = true;
                        if (board[row][col] == -1) {
                            q.add(currBoardVal + diceVal);
                        } else {
                            q.add(board[row][col]);
                        }
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    public static int[] findCoordinates(int curr, int n) {
        int r = n - (curr - 1) / n - 1;
        int c = (curr - 1) % n;
        if (r % 2 == n % 2) {
            return new int[] { r, n - 1 - c };
        } else {
            return new int[] { r, c };
        }
    }
}
