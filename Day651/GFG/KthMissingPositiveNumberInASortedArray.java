//GFG
//Kth Missing Positive Number in a Sorted Array
//Time complexity: O(logN)
//Space complexity: O(1) 

public class KthMissingPositiveNumberInASortedArray {

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 7, 11 };
        int k = 5;
        System.out.println(kthMissing(arr, k));
    }

    public static int kthMissing(int[] arr, int k) {
        // code here
        int lo = 0, hi = arr.length - 1;
        int ans = arr.length + k;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] > mid + k) {
                hi = mid - 1;
                ans = mid + k;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}
