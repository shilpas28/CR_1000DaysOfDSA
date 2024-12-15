//GFG
//Peak element - Brute Force
//Time complexity: O(N)
//Space complexity: O(1)

public class PeakElement {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 5, 7, 8, 3 };
        System.out.println(peakElement(arr));
    }

    public static int peakElement(int[] arr) {
        // code here
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if ((i == 0 || arr[i - 1] <= arr[i]) && (i == n - 1 || arr[i + 1] <= arr[i]))
                return i;
        }
        return -1;
    }
}
