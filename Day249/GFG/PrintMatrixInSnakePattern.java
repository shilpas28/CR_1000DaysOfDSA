//GFG
//Print Matrix in snake Pattern
//Time complexity: O(N^2)
//Space complexity: O(N^2)

package GFG;

import java.util.ArrayList;

public class PrintMatrixInSnakePattern {

    public static void main(String[] args) {
        // int N = 3;
        int matrix[][] = { { 45, 48, 54 },
                { 21, 89, 87 },
                { 70, 78, 15 } };
        System.out.println(snakePattern(matrix));
    }

    // Function to return list of integers visited in snake pattern in matrix.
    static ArrayList<Integer> snakePattern(int matrix[][]) {
        // code here
        int n = matrix.length;
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                for (int j = 0; j < n; j++) {
                    al.add(matrix[i][j]);
                }
            else
                for (int j = n - 1; j >= 0; j--) {
                    al.add(matrix[i][j]);
                }
        }
        return al;
    }
}
