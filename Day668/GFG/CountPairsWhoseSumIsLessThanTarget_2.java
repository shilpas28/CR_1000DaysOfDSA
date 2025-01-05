//GFG
//Count Pairs whose sum is less than target
//Time complexity: O(NlogN)
//Space complexity: O(1)

import java.util.Arrays;

public class CountPairsWhoseSumIsLessThanTarget_2 {

    public static void main(String[] args) {
        int arr[] = { 7, 2, 5, 3 };
        int target = 8;
        System.out.println(countPairs(arr, target));
    }

    static int countPairs(int arr[], int target) {
        // Your code here
        Arrays.sort(arr);
        int n = arr.length, l = 0, r = n - 1, ans = 0;
        while (l < r) {
            int sum = arr[l] + arr[r];
            if (sum < target) {
                ans += (r - l);
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }
}
