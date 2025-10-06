//GFG
//The Knight's tour problem
//Time complexity: O(8 ^ (n * n) )
//Space complexity: O(n ^ 2)

import java.util.ArrayList;

public class TheKnightsTourProblem {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(knightTour(n));
    }

    static int dr[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
    static int dc[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

    public static ArrayList<ArrayList<Integer>> knightTour(int n) {
        // code here
        ArrayList<ArrayList<Integer>> board = new ArrayList<>(n);
        for (int i = 0; i < n; ++i)
            board.add(new ArrayList<>(n));
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                board.get(i).add(-1);
        if (!helper(board, n, 0, 0, new boolean[n][n], 0))
            board = new ArrayList<>();
        return board;
    }

    static boolean helper(ArrayList<ArrayList<Integer>> board, int n, int r, int c, boolean isV[][], int s) {
        if (r < 0 || c < 0 || r >= n || c >= n || isV[r][c])
            return false;
        board.get(r).set(c, s);
        isV[r][c] = true;
        if (s == (n * n) - 1)
            return true;
        for (int i = 0; i < 8; i++)
            if (helper(board, n, r + dr[i], c + dc[i], isV, s + 1))
                return true;
        isV[r][c] = false;
        return false;
    }
}
