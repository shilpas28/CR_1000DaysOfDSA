//GFG
//Search in an almost Sorted Array
//Time complexity: O(logN) 
//Space complexity: O(1)

public class SearchInAnAlmostSortedArray_2 {

    public static void main(String[] args) {
        int[] arr = { 10, 3, 40, 20, 50, 80, 70 };
        int target = 40;
        System.out.println(findTarget(arr, target));
    }

    public static int findTarget(int arr[], int target) {
        // code here
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == target)
                return mid;
            else if (mid < arr.length - 1 && arr[mid + 1] == target)
                return mid + 1;
            else if (mid > 0 && arr[mid - 1] == target)
                return mid - 1;
            else if (arr[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }
}
