//GFG
//Boundary traversal of matrix
//Time complexity: O(N + M)
//Space complexity: O(1)

import java.util.ArrayList;

public class BoundaryTraversalOfMatrix {

    public static void main(String[] args) {
        int n = 4, m = 4;
        int matrix[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        System.out.println(boundaryTraversal(matrix, n, m));
    }

    // Function to return list of integers that form the boundary
    // traversal of the matrix in a clockwise manner.
    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; i++)
            res.add(matrix[0][i]);

        for (int i = 1; i < n; i++)
            res.add(matrix[i][m - 1]);

        if (n > 1)
            for (int i = m - 2; i >= 0; i--)
                res.add(matrix[n - 1][i]);

        if (m > 1)
            for (int i = n - 2; i >= 1; i--)
                res.add(matrix[i][0]);

        return res;
    }
}
