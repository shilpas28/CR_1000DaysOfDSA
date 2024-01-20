//Leetcode - Not accepted as TLE 
//907. Sum of Subarray Minimums
//Time complexity: O(N^2)
//Space complexity: O(1)

package Leetcode;

public class SumOfSubarrayMinimums_2 {

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 4 };
        System.out.println(sumSubarrayMins(arr));
    }

    public static int sumSubarrayMins(int[] arr) {
        int res = 0;
        int n = arr.length;
        int mod = (int) 1e9 + 7;
        for (int end = 0; end < n; end++) {
            int min = arr[end];
            for (int start = end; start >= 0; start--) {
                min = Math.min(min, arr[start]);
                res = (res + min) % mod;
            }
        }
        return res;
    }
}
