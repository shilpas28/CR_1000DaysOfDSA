//GFG
//Product array puzzle
//Time complexity: O(N)
//Space complexity: O(1) 

import java.util.Arrays;

public class ProductArrayPuzzle_2 {

    public static void main(String[] args) {
        int arr[] = { 10, 3, 5, 6, 2 };
        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }

    public static int[] productExceptSelf(int arr[]) {
        // code here
        int n = arr.length;
        int left[] = new int[n];
        left[0] = arr[0];

        for (int i = 1; i < n; i++)
            left[i] = arr[i] * left[i - 1];

        int pro = arr[n - 1];
        arr[n - 1] = left[n - 2];

        for (int i = n - 2; i > 0; i--) {
            int temp = arr[i];
            arr[i] = left[i - 1] * pro;
            pro *= temp;
        }

        arr[0] = pro;
        return arr;
    }
}
