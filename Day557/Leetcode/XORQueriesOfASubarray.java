//Leetcode
//1310. XOR Queries of a Subarray
//Time complexity: O(n), n is the size of arr
//Space complexity: O(n)

import java.util.Arrays;

public class XORQueriesOfASubarray {

    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 8 };
        int[][] queries = { { 0, 1 }, { 1, 2 }, { 0, 3 }, { 3, 3 } };
        System.out.println(Arrays.toString(xorQueries(arr, queries)));
    }

    public static int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prefixXOR = new int[n + 1];
        for (int i = 1; i <= n; i++)
            prefixXOR[i] = prefixXOR[i - 1] ^ arr[i - 1];

        int[] output = new int[queries.length];
        int i = 0;
        for (int[] q : queries) {
            int l = q[0], r = q[1];
            output[i++] = prefixXOR[r + 1] ^ prefixXOR[l];
        }
        return output;
    }
}
