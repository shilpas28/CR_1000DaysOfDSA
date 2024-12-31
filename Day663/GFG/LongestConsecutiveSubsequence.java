//GFG
//Longest Consecutive Subsequence - Brute Force
//Time complexity: O(N^2)
//Space complexity: O(1) 

public class LongestConsecutiveSubsequence {

    public static void main(String[] args) {
        int[] arr = { 2, 6, 1, 9, 4, 5, 3 };
        System.out.println(longestConsecutive(arr));
    }

    // Function to return length of longest subsequence of consecutive integers.
    public static int longestConsecutive(int[] arr) {
        // code here
        int n = arr.length; // size of array
        int longest = 1;
        // pick a element and search for its
        // consecutive numbers:
        for (int i = 0; i < n; i++) {
            int x = arr[i];
            int cnt = 1;
            // search for consecutive numbers
            // using linear search:
            while (linearSearch(arr, x + 1) == true) {
                x += 1;
                cnt += 1;
            }
            longest = Math.max(longest, cnt);
        }
        return longest;
    }

    static boolean linearSearch(int[] a, int num) {
        int n = a.length; // size of array
        for (int i = 0; i < n; i++) {
            if (a[i] == num)
                return true;
        }
        return false;
    }
}
