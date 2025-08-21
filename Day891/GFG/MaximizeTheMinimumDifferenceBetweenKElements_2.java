//GFG
//Maximize the minimum difference between k elements
//Time complexity: O(NlogN)
//Space complexity: O(1)

import java.util.Arrays;

public class MaximizeTheMinimumDifferenceBetweenKElements_2 {

    public static void main(String[] args) {
        int arr[] = { 1, 4, 9, 0, 2, 13, 3 };
        int k = 4;
        System.out.println(maxMinDiff(arr, k));
    }

    public static int maxMinDiff(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int low = 0, high = arr[arr.length - 1] - arr[0], ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2, count = 1, last = arr[0];
            for (int i = 1; i < arr.length && count < k; i++) {
                if (arr[i] - last >= mid) {
                    count++;
                    last = arr[i];
                }
            }
            if (count >= k) {
                ans = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return ans;
    }
}
