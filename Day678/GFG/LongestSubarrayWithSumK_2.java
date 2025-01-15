//GFG
//Longest Subarray with Sum K - Optimizing the Naive Approach (Using two loops) - Not accepted as TLE
//Time complexity: O(N^2) approx., where N = size of the array
//Space complexity: O(1) as we are not using any extra space

public class LongestSubarrayWithSumK_2 {

    public static void main(String[] args) {
        int arr[] = { 10, 5, 2, 7, 1, -10 };
        int k = 15;
        System.out.println(longestSubarray(arr, k));
    }

    public static int longestSubarray(int[] arr, int k) {
        // code here
        int n = arr.length; // size of the array.
        int len = 0;

        for (int i = 0; i < n; i++) { // starting index
            long s = 0; // Sum variable
            for (int j = i; j < n; j++) { // ending index
                // add the current element to
                // the subarray a[i...j-1]:
                s += arr[j];

                if (s == k)
                    len = Math.max(len, j - i + 1);
            }
        }
        return len;
    }
}
