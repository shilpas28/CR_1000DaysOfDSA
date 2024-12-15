//GFG
//Peak element - Optimal
//Time complexity: O(logN)
//Space complexity: O(1)

public class PeakElement_2 {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 5, 7, 8, 3 };
        System.out.println(peakElement(arr));
    }

    public static int peakElement(int[] arr) {
        // code here
        int n = arr.length;
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
