//Leetcode
//1277. Count Square Submatrices with All OnesOnes - 2D Bottom Up
//Time complexity: O(M*N)
//Space complexity: O(1) 

public class CountSquareSubmatricesWithAllOnes_3 {

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 0, 1, 1, 1 }
        };
        System.out.println(countSquares(matrix));
    }

    public static int countSquares(int[][] matrix) {
        int[][] length = new int[matrix.length + 1][matrix[0].length + 1];
        int squares = 0;

        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int col = matrix[row].length - 1; col >= 0; col--) {
                if (matrix[row][col] == 0)
                    continue;

                length[row][col] = Math.min(length[row + 1][col],
                        Math.min(length[row][col + 1], length[row + 1][col + 1])) + 1;
                squares += length[row][col];
            }
        }
        return squares;
    }
}
