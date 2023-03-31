//GFG 
//Even Swap
//Time complexity: O(NlogN)
//Space complexity: O(1)

package GFG;

import java.util.Arrays;

public class EvenSwap {

    public static void main(String[] args) {
        int N = 3;
        int a[] = { 1, 3, 5 };
        System.out.println(Arrays.toString(lexicographicallyLargest(a, N)));
    }

    static int[] lexicographicallyLargest(int[] arr, int n) {
        // Write your code here
        int i = 0;
        while (i < n) {
            int j;
            for (j = i + 1; j < n && arr[j] % 2 == arr[j - 1] % 2; j++) {
            }
            help_sort_primitive(arr, i, j);
            i = j; // update the ith ptr to check next possible swap
        }
        return arr;
    }

    static void help_sort_primitive(int arr[], int i, int j) {
        Arrays.sort(arr, i, j);
        while (i < j) {
            j--;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
        }
    }

}
