//Leetcode
//1582. Special Positions in a Binary Matrix - Brute Force
//Time complexity: O(n^3), where n is the size of the matrix.
//Space complexity: O(1) - no extra space used.

package Leetcode;

public class SpecialPositionsInABinaryMatrix_3 {

    public static void main(String[] args) {
        int[][] mat = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
        System.out.println(numSpecial(mat));
    }

    public static int numSpecial(int[][] mat) {
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int sumR = 0;
                int sumC = 0;
                if (mat[i][j] == 1) {
                    for (int k = 0; k < mat.length; k++) {
                        sumR += mat[k][j];
                    }
                    for (int k = 0; k < mat[0].length; k++) {
                        sumC += mat[i][k];
                    }
                }
                if (sumR + sumC == 2)
                    count++;
            }
        }
        return count;
    }
}
