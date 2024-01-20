//Leetcode - Not accepted as TLE 
//907. Sum of Subarray Minimums
//Time complexity: O(N^3)
//Space complexity: O(1)

package Leetcode;

public class SumOfSubarrayMinimums {

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 4 };
        System.out.println(sumSubarrayMins(arr));
    }

    public static int sumSubarrayMins(int[] arr) {
        int res = 0;
        int n = arr.length;
        int mod = (int) 1e9 + 7;
        for (int end = 0; end < n; end++) {
            for (int start = 0; start <= end; start++) {
                int min = Integer.MAX_VALUE;
                for (int i = start; i <= end; i++)
                    min = Math.min(min, arr[i]);
                res = (res + min) % mod;
            }
        }
        return res;
    }
}
