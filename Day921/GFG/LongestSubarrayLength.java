//GFG
//Longest Subarray Length
//Time complexity: O(N)
//Space complexity: O(N) 

import java.util.Stack;

public class LongestSubarrayLength {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        System.out.println(longestSubarray(arr));
    }

    public static int longestSubarray(int[] arr) {
        // code here
        int n = arr.length;
        int res = 0;
        // Stack stores indices in decreasing order of values
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i <= n; i++) {
            // If end of array, take a "virtual" element = +∞
            int curr = (i == n) ? Integer.MAX_VALUE : arr[i];
            // Maintain decreasing stack
            while (!st.isEmpty() && arr[st.peek()] < curr) {
                int j = st.pop(); // index of the smallest element
                int prevIndex = st.isEmpty() ? -1 : st.peek();
                int len = i - 1 - prevIndex; // subarray length
                // Check condition
                if (arr[j] <= len) {
                    res = Math.max(res, len);
                }
            }
            // Push current index (except the virtual one at end)
            if (i < n)
                st.push(i);
        }
        return res;
    }
}
