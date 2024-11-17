//GFG
//Reverse an Array
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.Arrays;

public class ReverseAnArray {

    public static void main(String[] args) {
        int[] arr = { 1, 4, 3, 2, 6, 5 };
        reverseArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverseArray(int arr[]) {
        // code here
        int n = arr.length;
        for (int i = 0; i < n / 2; ++i) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
    }
}
