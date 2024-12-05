//GFG
//Sort 0s, 1s and 2s - Better Approach
//Time complexity: O(N) + O(N), where N = size of the array. First O(N) for counting the number of 0s, 1s, 2s, and 
//second O(N) for placing them correctly in the original array.
//Space complexity: O(1) as we are not using any extra space.

import java.util.Arrays;

public class Sort0s1sAnd2s_2 {

    public static void main(String[] args) {
        int arr[] = { 0, 1, 2, 0, 1, 2 };
        sort012(arr);
        System.out.println(Arrays.toString(arr));
    }

    // Function to sort an array of 0s, 1s, and 2s
    public static void sort012(int[] arr) {
        // code here
        int cnt0 = 0, cnt1 = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0)
                cnt0++;
            else if (arr[i] == 1)
                cnt1++;
        }
        // Replace the places in the original array:
        for (int i = 0; i < cnt0; i++)
            arr[i] = 0; // replacing 0's
        for (int i = cnt0; i < cnt0 + cnt1; i++)
            arr[i] = 1; // replacing 1's
        for (int i = cnt0 + cnt1; i < n; i++)
            arr[i] = 2; // replacing 2's
    }
}
