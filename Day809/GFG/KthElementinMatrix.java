//GFG
//Kth element in Matrix - Brute Force
//Time complexity: O((n^2)*logn)
//Space complexity: O(n^2)

import java.util.Arrays;

public class KthElementinMatrix {

    public static void main(String[] args) {
        int mat[][] = { { 16, 28, 60, 64 }, { 22, 41, 63, 91 }, { 27, 50, 87, 93 }, { 36, 78, 87, 94 } };
        int k = 3;
        System.out.println(kthSmallest(mat, k));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        // code here
        int n = matrix.length;
        int[] oneDimentional = new int[n * n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                oneDimentional[index] = matrix[i][j];
                index++;
            }
        }
        Arrays.sort(oneDimentional);
        return oneDimentional[k - 1];
    }
}
