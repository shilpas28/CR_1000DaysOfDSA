//GFG
//Kth Smallest Number in Multiplication Table - Brute Force - Not accepted as TLE
//Time complexity: O(n^2)
//Space complexity: O(n)

import java.util.Arrays;

public class KthSmallestNumberInMultiplicationTable {

    public static void main(String[] args) {
        int m = 3, n = 3, k = 5;
        System.out.println(kthSmallest(m, n, k));
    }

    public static int kthSmallest(int m, int n, int k) {
        // code here
        int[] ar = new int[m * n];
        int x = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                ar[x] = j * i;
                x++;
            }
        }
        Arrays.sort(ar);
        return ar[k - 1];
    }
}
