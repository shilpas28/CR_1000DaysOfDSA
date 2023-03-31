//GFG 
//Even Swap- Optimal solution
//Time complexity: O(NlogN)
//Space complexity: O(1)

package GFG;

import java.util.Arrays;

public class EvenSwap_3 {

    public static void main(String[] args) {
        int N = 3;
        int a[] = { 1, 3, 5 };
        System.out.println(Arrays.toString(lexicographicallyLargest(a, N)));
    }

    static int[] lexicographicallyLargest(int[] arr, int n) {
        // Write your code here
        int i = 0;
        while (i < n) {
            int j = i + 1;

            while (j < n && (arr[j] + arr[j - 1]) % 2 == 0) {
                j++;
            }
            Arrays.sort(arr, i, j);
            reverse(arr, i, j);
            i = j;
        }
        return arr;
    }

    // static void swap(int[] arr, int i, int j) {
    //     int temp = arr[i];
    //     arr[i] = arr[j];
    //     arr[j] = temp;
    // }

    static void reverse(int[] a, int i, int j) {
        while (i < j) {
            j--;

            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;

            i++;
        }
    }
}
