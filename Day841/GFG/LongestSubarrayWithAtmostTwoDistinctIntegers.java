//GFG
//Longest subarray with Atmost two distinct integers - Not accepted as TLE
//Time complexity: O(N^2)
//Space complexity: O(1)

import java.util.HashSet;
import java.util.Set;

public class LongestSubarrayWithAtmostTwoDistinctIntegers {

    public static void main(String[] args) {
        int arr[] = { 2, 1, 2 };
        System.out.println(totalElements(arr));
    }

    public static int totalElements(int[] arr) {
        // code here
        int n = arr.length;

        int left = 0;
        int right = 0;
        int maxLen = 0;
        Set<Integer> set = new HashSet<>();
        
        while (right < n) {
            set.add(arr[right]);
            while (set.size() > 2) {
                set.remove(arr[left]);
                left++;
            }
            // Rebuilding the set from current window since set may drop needed element
            set.clear();
            for (int k = left; k <= right; k++) {
                set.add(arr[k]);
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;

        }
        return maxLen;
    }
}
