//Leetcode
//1277. Count Square Submatrices with All Ones - 1D Bottom Up 
//Time complexity: O(M*N)
//Space complexity: O(1) 

public class CountSquareSubmatricesWithAllOnes_4 {

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 0, 1, 1, 1 }
        };
        System.out.println(countSquares(matrix));
    }

    public static int countSquares(int[][] matrix) {
        int[] length = new int[matrix[0].length + 1];
        int squares = 0;

        for (int row = matrix.length - 1; row >= 0; row--) {
            int prev = 0;

            for (int col = matrix[row].length - 1; col >= 0; col--) {
                if (matrix[row][col] == 0) {
                    prev = length[col];
                    length[col] = 0;
                    continue;
                }

                int current = length[col];
                length[col] = Math.min(length[col], Math.min(length[col + 1], prev)) + 1;
                prev = current;
                squares += length[col];
            }
        }
        return squares;
    }
}
