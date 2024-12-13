//GFG
//Sorted and Rotated Minimum
//Time complexity: O(logN)
//Space complexity: O(1)

package GFG;

public class SortedAndRotatedMinimum {

    public static void main(String[] args) {
        int arr[] = { 5, 6, 1, 2, 3, 4 };
        System.out.println(findMin(arr));
    }

    public static int findMin(int[] arr) {
        // complete the function here
        int n = arr.length, low = 0, high = n - 1, mid = 0;
        while (low < high) {
            mid = (low + high) / 2;
            if (arr[mid] <= arr[high])
                high = mid;
            else
                low = mid + 1;
        }
        return arr[low];
    }
}
