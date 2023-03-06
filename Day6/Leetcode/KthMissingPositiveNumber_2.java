//Leetcode - Optimal solution
//1539. Kth Missing Positive Number
//Time complexity: O(logN)
//Space complexity: O(1)

package Leetcode;

public class KthMissingPositiveNumber_2 {

    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 7, 11 };
        int k = 5;
        System.out.println(findKthPositive(arr, k));
    }

    public static int findKthPositive(int[] arr, int k) {

        int low = 0;
        int high = arr.length;
        while (low < high) {
            int mid = (high - low) / 2 + low;

            if (arr[mid] - (mid + 1) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

}
