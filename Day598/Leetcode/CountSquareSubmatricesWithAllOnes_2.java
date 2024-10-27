//Leetcode
//1277. Count Square Submatrices with All Ones - Memoization
//Time complexity: O(M*N)
//Space complexity: O(1)

public class CountSquareSubmatricesWithAllOnes_2 {

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 0, 1, 1, 1 }
        };
        System.out.println(countSquares(matrix));
    }

    public static int countSquares(int[][] matrix) {
        int[][] memo = new int[matrix.length][matrix[0].length];
        int squares = 0;

        for (int row = 0; row < matrix.length; row++)
            for (int col = 0; col < matrix[row].length; col++)
                squares += getLength(row, col, matrix, memo);

        return squares;
    }

    static int getLength(int row, int col, int[][] matrix, int[][] memo) {
        if (row >= matrix.length || col >= matrix[row].length || matrix[row][col] == 0)
            return 0;
        if (memo[row][col] != 0)
            return memo[row][col];

        memo[row][col] = Math.min(getLength(row + 1, col, matrix, memo),
                Math.min(getLength(row, col + 1, matrix, memo), getLength(row + 1, col + 1, matrix, memo))) + 1;

        return memo[row][col];
    }
}
