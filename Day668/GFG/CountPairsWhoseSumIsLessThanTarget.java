//GFG
//Count Pairs whose sum is less than target
//Time complexity: O(NlogN)
//Space complexity: O(1)

import java.util.Arrays;

public class CountPairsWhoseSumIsLessThanTarget {

    public static void main(String[] args) {
        int arr[] = { 7, 2, 5, 3 };
        int target = 8;
        System.out.println(countPairs(arr, target));
    }

    static int countPairs(int arr[], int target) {
        // Your code here
        Arrays.sort(arr);
        int ans = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            int upperbound = bs(arr, i, n - 1, target - arr[i]);
            ans += upperbound - i;
        }
        return ans;
    }

    static int bs(int a[], int l, int r, int x) {
        int ans = l;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] < x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
