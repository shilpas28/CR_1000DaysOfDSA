//GFG
//Longest Subarray with Sum K - Better Approach(Using Hashing)
//Time complexity: O(N) or O(N*logN) depending on which map data structure we are using, where N = size of the array
//Space complexity: O(N) as we are using a map data structure

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK_3 {

    public static void main(String[] args) {
        int arr[] = { 10, 5, 2, 7, 1, -10 };
        int k = 15;
        System.out.println(longestSubarray(arr, k));
    }

    public static int longestSubarray(int[] arr, int k) {
        // code here
        int n = arr.length; // size of the array.
        Map<Long, Integer> preSumMap = new HashMap<>();
        long sum = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            // calculate the prefix sum till index i:
            sum += arr[i];
            // if the sum = k, update the maxLen:
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }
            // calculate the sum of remaining part i.e. x-k:
            long rem = sum - k;
            // Calculate the length and update maxLen:
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            // Finally, update the map checking the conditions:
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }
        return maxLen;
    }
}
