//GFG
//Minimize the Heights II
//Time complexity: O(NlogN)
//Space complexity: O(N) 

import java.util.Arrays;

public class MinimizeTheHeightsII {

    public static void main(String[] args) {
        int k = 2;
        int arr[] = { 1, 5, 8, 10 };
        System.out.println(getMinDiff(arr, k));
    }

    public static int getMinDiff(int[] arr, int k) {
        // code here
        int n = arr.length;
        if (n == 1)
            return 0;
        Arrays.sort(arr);
        int ans = arr[n - 1] - arr[0], mn = 0, mx = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] - k < 0)
                continue;
            mn = Math.min(arr[0] + k, arr[i] - k);
            mx = Math.max(arr[n - 1] - k, arr[i - 1] + k);
            ans = Math.min(ans, mx - mn);
        }
        return ans;
    }
}
