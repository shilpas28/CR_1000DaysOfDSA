//Leetcode
//1310. XOR Queries of a Subarray
//Time complexity: O(n), n is the size of arr
//Space complexity: O(1)

import java.util.Arrays;

public class XORQueriesOfASubarray_2 {

    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 8 };
        int[][] queries = { { 0, 1 }, { 1, 2 }, { 0, 3 }, { 3, 3 } };
        System.out.println(Arrays.toString(xorQueries(arr, queries)));
    }

    public static int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        for (int i = 1; i < n; i++)
            arr[i] ^= arr[i - 1];

        int[] output = new int[queries.length];
        int i = 0;
        for (int[] q : queries) {
            int l = q[0], r = q[1];
            output[i++] = arr[r] ^ (l > 0 ? arr[l - 1] : 0);
        }
        return output;
    }
}
