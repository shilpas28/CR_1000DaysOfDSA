//GFG
//Arranging The Array
//Time complexity: O(NlogN)
//Space complexity: O(logN) 

package GFG;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrangingTheArray {

    public static void main(String[] args) {
        int N = 4;
        int arr[] = { -3, 3, -2, 2 };
        rearrange(arr, N);
        System.out.println(Arrays.toString(arr));
    }

    public static void rearrange(int a[], int n) {
        // Your code goes here
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (a[i] < 0)
                temp.add(a[i]);
        }
        for (int i = 0; i < n; i++) {
            if (a[i] >= 0)
                temp.add(a[i]);
        }
        int i = 0;
        for (int x : temp) {
            a[i++] = x;
        }
    }
}
