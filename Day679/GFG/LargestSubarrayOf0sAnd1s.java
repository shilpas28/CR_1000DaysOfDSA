//GFG
//Largest subarray of 0's and 1's
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

import java.util.HashMap;

public class LargestSubarrayOf0sAnd1s {

    public static void main(String[] args) {
        int arr[] = { 1, 0, 1, 1, 1, 0, 0 };
        System.out.println(maxLen(arr));
    }

    public static int maxLen(int[] arr) {
        // Your code here
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        int n = arr.length, sum = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i] == 1 ? 1 : -1;
            if (sum == 0) {
                ans = i + 1;
            }
            if (prefixSum.get(sum) != null) {
                ans = Math.max(ans, i - prefixSum.get(sum));
            } else {
                prefixSum.put(sum, i);
            }
        }
        return ans;
    }
}
