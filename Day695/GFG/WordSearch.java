//GFG
//Word Search
//Time complexity: O(N * M * 4L) where N = No. of rows in board, M = No. of columns in board, L = Length of word
//Space complexity: O(L), L is length of word.

package GFG;

public class WordSearch {

    public static void main(String[] args) {

        char[][] mat = { { 'T', 'E', 'E' }, { 'S', 'G', 'K' }, { 'T', 'E', 'L' } };
        String word = "GEEK";
        System.out.println(isWordExist(mat, word));
    }

    static public boolean isWordExist(char[][] mat, String word) {
        // Code here
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == word.charAt(0)) {
                    boolean[][] visit = new boolean[mat.length][mat[0].length];
                    if (check(mat, i, j, 0, word, visit))
                        return true;
                }
            }
        }
        return false;
    }

    static boolean check(char[][] mat, int i, int j, int ind, String word, boolean[][] visit) {
        if (ind == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || visit[i][j] || mat[i][j] != word.charAt(ind)) {
            return false;
        }
        visit[i][j] = true;
        if (check(mat, i, j - 1, ind + 1, word, visit) ||
                check(mat, i, j + 1, ind + 1, word, visit) ||
                check(mat, i + 1, j, ind + 1, word, visit) ||
                check(mat, i - 1, j, ind + 1, word, visit))
            return true;

        visit[i][j] = false;
        return false;
    }
}
