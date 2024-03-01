//GFG
//Peak element - Optimal
//Time complexity: O(logN)
//Space complexity: O(1)

package GFG;

public class PeakElement_2 {

    public static void main(String[] args) {
        int n = 7;
        int arr[] = { 1, 1, 1, 2, 1, 1, 1 };
        System.out.println(peakElement(arr, n));
    }

    // Function to find the peak element
    // arr[]: input array
    // n: size of array a[]
    public static int peakElement(int[] arr, int n) {
        int start = 0, end = n - 1, mid;
        while (start <= end) {
            mid = (start + end) / 2;
            int prev = mid - 1 >= 0 ? mid - 1 : 0;
            int next = mid + 1 < n ? mid + 1 : n - 1;
            if (arr[mid] >= arr[prev] && arr[mid] >= arr[next])
                return mid;
            else if (arr[mid] < arr[next])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return 0;
    }
}
