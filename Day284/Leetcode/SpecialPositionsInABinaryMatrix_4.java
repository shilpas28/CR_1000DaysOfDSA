//Leetcode
//1582. Special Positions in a Binary Matrix - Hashing
//Time complexity: O(n^2), where n is the size of the matrix.
//Space complexity: O(n) - for the rowSum and colSum arrays.

package Leetcode;

public class SpecialPositionsInABinaryMatrix_4 {

    public static void main(String[] args) {
        int[][] mat = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
        System.out.println(numSpecial(mat));
    }

    public static int numSpecial(int[][] mat) {
        int[] rowSum = new int[mat.length];
        int[] colSum = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                rowSum[i] += mat[i][j];
                colSum[j] += mat[i][j];
            }
        }
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && rowSum[i] == 1 && colSum[j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
