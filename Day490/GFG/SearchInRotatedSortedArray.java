//GFG
//Search in Rotated Sorted Array
//Time complexity: O(logn)
//Space complexity: O(1)

package GFG;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int arr[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
        int key = 10;
        System.out.println(search(arr, key));
    }

    static int search(int[] arr, int key) {
        // Complete this function
        int low = 0, high = arr.length - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < arr[0]) {
                if (key <= arr[high] && key > arr[mid])
                    low = mid + 1;
                else
                    high = mid - 1;
            } else {
                if (key < arr[mid] && key >= arr[low])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }
}
