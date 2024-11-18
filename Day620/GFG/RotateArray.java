//GFG
//Rotate Array
//Time complexity: O(N)
//Space complexity: O(1) 

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        int d = 2;
        rotateArr(arr, d);
        System.out.println(Arrays.toString(arr));
    }

    // Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d) {
        // add your code here
        int n = arr.length;
        if (n == 0)
            return;

        d = d % n;
        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
    }

    static void reverse(int[] arr, int st, int end) {
        while (st < end) {
            int temp = arr[st];
            arr[st] = arr[end];
            arr[end] = temp;
            ++st;
            --end;
        }
    }
}
