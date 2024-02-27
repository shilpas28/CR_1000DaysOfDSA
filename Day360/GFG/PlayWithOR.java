//GFG
//Play With OR
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

import java.util.Arrays;

public class PlayWithOR {

    public static void main(String[] args) {
        int n = 5;
        int arr[] = { 10, 11, 1, 2, 3 };
        System.out.println(Arrays.toString(game_with_number(arr, n)));
    }

    // Function for finding maximum and value pair
    public static int[] game_with_number(int arr[], int n) {
        // Complete the function
        for (int i = 0; i < n - 1; i++) {
            arr[i] = arr[i] | arr[i + 1];
        }
        return arr;
    }
}
