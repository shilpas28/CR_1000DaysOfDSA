//Leetcode
//1277. Count Square Submatrices with All Ones - Recursion - Not accepted as TLE
//Time complexity: O(M*N)
//Space complexity: O(1)

public class CountSquareSubmatricesWithAllOnes {

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 0, 1, 1, 1 }
        };
        System.out.println(countSquares(matrix));
    }

    public static int countSquares(int[][] matrix) {
        int squares = 0;

        for (int row = 0; row < matrix.length; row++)
            for (int col = 0; col < matrix[row].length; col++)
                squares += getLength(row, col, matrix);

        return squares;
    }

    static int getLength(int row, int col, int[][] matrix) {
        if (row >= matrix.length || col >= matrix[row].length || matrix[row][col] == 0)
            return 0;

        return Math.min(getLength(row + 1, col, matrix),
                Math.min(getLength(row, col + 1, matrix), getLength(row + 1, col + 1, matrix))) + 1;
    }
}
