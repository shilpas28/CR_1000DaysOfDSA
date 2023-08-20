//GFG
//Number of occurrence - Using Binary Search
//Time complexity: O(logN)
//Space complexity: O(1)

public class NumberOfOccurrence_3 {

    public static void main(String[] args) {
        int N = 7, X = 2;
        int Arr[] = { 1, 1, 2, 2, 2, 2, 3 };
        System.out.println(count(Arr, N, X));
    }

    static int count(int[] arr, int n, int x) {
        // code here
        int first = l_idx(arr, x);
        int last = h_idx(arr, x);
        // System.out.println(first + " " + last);
        if (last == -1)
            return 0;
        return last - first + 1;
    }

    static int h_idx(int arr[], int x) {
        int n = arr.length;
        int idx = -1;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > x)
                high = mid - 1;
            else if (arr[mid] == x) {
                idx = mid;
                low = mid + 1;
            }
            // if(arr[mid] < x)
            else
                low = mid + 1;
        }
        return idx;
    }

    static int l_idx(int arr[], int x) {
        int n = arr.length;
        int idx = -1;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > x)
                high = mid - 1;
            else if (arr[mid] == x) {
                idx = mid;
                high = mid - 1;
            }
            // if(arr[mid] < x)
            else
                low = mid + 1;
        }
        return idx;
    }
}
