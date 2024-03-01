//GFG
//Peak element - Brute Force
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class PeakElement {

    public static void main(String[] args) {
        int n = 7;
        int arr[] = { 1, 1, 1, 2, 1, 1, 1 };
        System.out.println(peakElement(arr, n));
    }

    // Function to find the peak element
    // arr[]: input array
    // n: size of array a[]
    public static int peakElement(int[] arr, int n) {
        // add code here.
        for (int i = 0; i < n; i++) {
            if ((i == 0 || arr[i - 1] <= arr[i]) && (i == n - 1 || arr[i + 1] <= arr[i]))
                return i;
        }
        return -1;
    }
}
