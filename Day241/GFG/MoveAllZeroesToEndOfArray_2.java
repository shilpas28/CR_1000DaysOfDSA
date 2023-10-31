//GFG
//Move all zeroes to end of array - Optimal method
//Time complexity: O(N), N = size of the array.
//Reason: We have used 2 loops and using those loops, we are basically traversing the array once.
//Space complexity: O(1) as we are not using any extra space to solve this problem.

import java.util.Arrays;

public class MoveAllZeroesToEndOfArray_2 {

    public static void main(String[] args) {
        int N = 5;
        int Arr[] = { 3, 5, 0, 0, 4 };
        pushZerosToEnd(Arr, N);
        System.out.println(Arrays.toString(Arr));
    }

    static void pushZerosToEnd(int[] arr, int n) {
        // code here
        int j = -1;
        // place the pointer j:
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }
        // no non-zero elements:
        if (j == -1)
            return;
        // Move the pointers i and j
        // and swap accordingly:
        for (int i = j + 1; i < n; i++) {
            if (arr[i] != 0) {
                // swap a[i] & a[j]:
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                j++;
            }
        }
    }
}
