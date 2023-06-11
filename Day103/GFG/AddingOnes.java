//GFG
//Adding Ones
//Time complexity: O(N)
//Space complexity: O(1) 

package GFG;

import java.util.Arrays;

public class AddingOnes {

    public static void main(String[] args) {
        int N = 3, K = 4;
        int[] updates = { 1, 1, 2, 3 };
        int a[] = new int[N];
        update(a, N, updates, K);
        System.out.println(Arrays.toString(a));
    }

    public static void update(int a[], int n, int updates[], int k) {
        // Your code goes here
        for (int i = 0; i < k; i++) {
            a[updates[i] - 1]++;
        }
        int temp = 0;
        for (int i = 0; i < n; i++) {
            a[i] += temp;
            temp = a[i];
        }
    }
}
