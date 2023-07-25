//Leetcode
//852. Peak Index in a Mountain Array
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class PeakIndexInAMountainArray {

    public static void main(String[] args) {
        int[] arr = { 0, 1, 0 };
        System.out.println(peakIndexInMountainArray(arr));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int n = arr.length; // Size of array.
        for (int i = 0; i < n; i++) {
            // Checking for the peak:
            if ((i == 0 || arr[i - 1] < arr[i])
                    && (i == n - 1 || arr[i] > arr[i+1])) {
                return i;
            }
        }
        // Dummy return statement
        return -1;
    }
}
