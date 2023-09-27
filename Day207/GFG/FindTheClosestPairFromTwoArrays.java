//GFG
//Find the closest pair from two arrays
//Time complexity: O(max(N,M))
//Space complexity: O(1)

package GFG;

import java.util.ArrayList;
import java.util.Arrays;

public class FindTheClosestPairFromTwoArrays {

    public static void main(String[] args) {
        int N = 4, M = 4;
        int arr[] = { 1, 4, 5, 7 };
        int brr[] = { 10, 20, 30, 40 };
        int X = 32;
        System.out.println(printClosest(arr, brr, N, M, X));
    }

    // Function for finding maximum and value pair
    public static ArrayList<Integer> printClosest(int arr[], int brr[], int n, int m, int x) {
        // code here
        int val1 = -1, val2 = -1;
        int i = 0, j = m - 1;
        int diff = Integer.MAX_VALUE;

        while (i < n && j >= 0) {
            int sum = arr[i] + brr[j];
            if (Math.abs(sum - x) < diff) {
                diff = Math.abs(sum - x);
                val1 = arr[i];
                val2 = brr[j];
            }
            if (sum <= x)
                i++;
            else
                j--;
        }
        return new ArrayList<Integer>(Arrays.asList(val1, val2));
    }
}
