//GFG
//Longest subarray with sum divisible by K
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumDivisibleByK {

    public static void main(String[] args) {
        int N = 6, K = 3;
        int arr[] = { 2, 7, 6, 1, 4, 5 };
        System.out.println(longSubarrWthSumDivByK(arr, N, K));
    }

    static int longSubarrWthSumDivByK(int a[], int n, int k) {
        // Complete the function
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        int sum = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            sum %= k;
            if (sum < 0)
                sum += k;
            mp.putIfAbsent(sum, i);
            if (mp.containsKey(sum))
                ans = Math.max(ans, i - mp.get(sum));
        }
        return ans;
    }
}
