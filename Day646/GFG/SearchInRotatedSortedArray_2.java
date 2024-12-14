//GFG
//Search in Rotated Sorted Array - Binary Search
//Time complexity: O(logN)
//Space complexity: O(1)

public class SearchInRotatedSortedArray_2 {

    public static void main(String[] args) {
        int arr[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
        int key = 3;
        System.out.println(search(arr, key));
    }

    static int search(int[] arr, int key) {
        // Complete this function
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == key)
                return mid;
            // if left side is sorted
            else if (arr[l] <= arr[mid]) {
                if (arr[l] <= key && key <= arr[mid])
                    r = mid;
                else
                    l = mid + 1;
            }
            // if right is sorted
            else if (arr[mid] <= arr[r]) {
                if (arr[mid] <= key && key <= arr[r])
                    l = mid;
                else
                    r = mid - 1;
            }
        }
        return -1;
    }
}
