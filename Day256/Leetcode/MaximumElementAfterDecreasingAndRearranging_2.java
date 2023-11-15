//Leetcode
//1846. Maximum Element After Decreasing and Rearranging
//Time complexity: O(N) - The algorithm iterates through the input array once to update the counter array and then iterates 
//through the counter array.
//Space complexity: O(N) - Additional space is used for the counter array.

package Leetcode;

public class MaximumElementAfterDecreasingAndRearranging_2 {

    public static void main(String[] args) {
        int[] arr = { 2, 2, 1, 2, 1 };
        System.out.println(maximumElementAfterDecrementingAndRearranging(arr));
    }

    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int l = arr.length;
        int[] counter = new int[l];
        for (int i = 0; i < l; i++) {
            ++counter[Math.min(arr[i] - 1, l - 1)];
        }
        int ans = 1;
        for (int i = 1; i < l; i++) {
            ans = Math.min(i + 1, ans + counter[i]);
        }
        return ans;
    }
}
