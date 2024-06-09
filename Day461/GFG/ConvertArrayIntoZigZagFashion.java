//GFG
//Convert array into Zig-Zag fashion
//Time complexity: O(N)
//Space complexity: O(1) 

package GFG;

import java.util.Arrays;

public class ConvertArrayIntoZigZagFashion {

    public static void main(String[] args) {
        int n = 7;
        int arr[] = { 4, 3, 7, 8, 6, 2, 1 };
        zigZag(n, arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void zigZag(int n, int[] arr) {
        // code here
        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0 && arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            } else if (i % 2 == 1 && arr[i] < arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
    }
}
