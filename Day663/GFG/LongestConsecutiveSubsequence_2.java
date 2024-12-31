//GFG
//Longest Consecutive Subsequence - Better Method 
//Time complexity: O(NlogN)
//Space complexity: O(1)

import java.util.Arrays;

public class LongestConsecutiveSubsequence_2 {

    public static void main(String[] args) {
        int[] arr = { 2, 6, 1, 9, 4, 5, 3 };
        System.out.println(longestConsecutive(arr));
    }

    // Function to return length of longest subsequence of consecutive integers.
    public static int longestConsecutive(int[] arr) {
        // code here
        int n = arr.length;
        if (n == 0)
            return 0;
        // sort the array:
        Arrays.sort(arr);
        int lastSmaller = Integer.MIN_VALUE;
        int cnt = 0;
        int longest = 1;
        // find longest sequence:
        for (int i = 0; i < n; i++) {
            if (arr[i] - 1 == lastSmaller) {
                // a[i] is the next element of the
                // current sequence.
                cnt += 1;
                lastSmaller = arr[i];
            } else if (arr[i] != lastSmaller) {
                cnt = 1;
                lastSmaller = arr[i];
            }
            longest = Math.max(longest, cnt);
        }
        return longest;
    }
}
