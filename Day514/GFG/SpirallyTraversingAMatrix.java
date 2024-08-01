//GFG
//Spirally traversing a matrix 
//Time complexity: O(N^2)
//Space complexity: O(N^2)

import java.util.ArrayList;

public class SpirallyTraversingAMatrix {

    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        System.out.println(spirallyTraverse(matrix));
    }

    // Function to return a list of integers denoting spiral traversal of matrix.
    public static ArrayList<Integer> spirallyTraverse(int matrix[][]) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int k = 0, l = 0, i = 0;
        int last_row = m - 1;
        int last_col = n - 1;
        while (k <= last_row && l <= last_col) {

            for (i = l; i <= last_col; i++)
                res.add(matrix[k][i]);
            k++;

            for (i = k; i <= last_row; i++)
                res.add(matrix[i][last_col]);
            last_col--;

            if (k <= last_row) {
                for (i = last_col; i >= l; i--)
                    res.add(matrix[last_row][i]);
                last_row--;
            }
            if (l <= last_col) {
                for (i = last_row; i >= k; i--)
                    res.add(matrix[i][l]);
                l++;
            }
        }
        return res;
    }
}
