//GFG
//Longest Consecutive Subsequence - Optimal Method 
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence_3 {

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

        int longest = 1;
        Set<Integer> set = new HashSet<>();
        // put all the array elements into set
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }
        // Find the longest sequence
        for (int it : set) {
            // if 'it' is a starting number
            if (!set.contains(it - 1)) {
                // find consecutive numbers
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }
}
