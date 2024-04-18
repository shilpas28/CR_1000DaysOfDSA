//GFG
//Two Repeated Elements
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

import java.util.Arrays;

public class TwoRepeatedElements {

    public static void main(String[] args) {
        int n = 4;
        int arr[] = { 1, 2, 1, 3, 4, 3 };
        System.out.println(Arrays.toString(twoRepeated(arr, n)));
    }

    // Function to find two repeated elements.
    public static int[] twoRepeated(int arr[], int n) {
        // Your code here
        boolean first = false;
        int[] res = new int[2];
        for (int p = 0; p < n + 2; p++) {
            if (arr[Math.abs(arr[p])] > 0)
                arr[Math.abs(arr[p])] = -arr[Math.abs(arr[p])];
            else {
                if (first == false) {
                    res[0] = Math.abs(arr[p]);
                    first = true;
                } else
                    res[1] = Math.abs(arr[p]);
            }
        }
        return res;
    }
}
