//GFG
//Search in Rotated Sorted Array - Linear Search
//Time complexity: O(N)
//Space complexity: O(1)

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int arr[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
        int key = 3;
        System.out.println(search(arr, key));
    }

    static int search(int[] arr, int key) {
        // Complete this function
        int n = arr.length;
        for (int i = 0; i < n; i++)
            if (arr[i] == key)
                return i;
        return -1;
    }
}
