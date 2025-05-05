//GFG
//Search in an almost Sorted Array - Brute Force
//Time complexity: O(N)
//Space complexity: O(1)

public class SearchInAnAlmostSortedArray {

    public static void main(String[] args) {
        int[] arr = { 10, 3, 40, 20, 50, 80, 70 };
        int target = 40;
        System.out.println(findTarget(arr, target));
    }

    public static int findTarget(int arr[], int target) {
        // code here
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }
}
