//GFG
//Sum of upper and lower triangles
//Time complexity: O(N^2)
//Space complexity: O(1)

package GFG;

import java.util.ArrayList;

public class SumOfUpperAndLowerTriangles {

    public static void main(String[] args) {
        int N = 3;
        int mat[][] = { { 6, 5, 4 },
                { 1, 2, 5 },
                { 7, 9, 7 } };
        System.out.println(sumTriangles(mat, N));
    }

    // Function to return sum of upper and lower triangles of a matrix.
    static ArrayList<Integer> sumTriangles(int matrix[][], int n) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        int uts = 0, lts = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                uts += matrix[i][j];
                lts += matrix[j][i];
            }
        }
        list.add(uts);
        list.add(lts);
        return list;
    }
}
