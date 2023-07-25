//Leetcode
//852. Peak Index in a Mountain Array
//Time complexity: O(logN)
//Space complexity: O(1)

package Leetcode;

public class PeakIndexInAMountainArray_2 {

    public static void main(String[] args) {
        int[] arr = { 0, 1, 0 };
        System.out.println(peakIndexInMountainArray(arr));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int n = arr.length; // Size of array
        // Edge cases:
        if (n == 1)
            return 0;
        if (arr[0] > arr[1])
            return 0;
        if (arr[n - 1] > arr[n - 2])
            return n - 1;
        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            // If arr[mid] is the peak:
            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1])
                return mid;
            // If we are in the left:
            if (arr[mid] > arr[mid - 1])
                low = mid + 1;
            // If we are in the right:
            // Or, arr[mid] is a common point:
            else
                high = mid - 1;
        }
        // Dummy return statement
        return -1;
    }
}
