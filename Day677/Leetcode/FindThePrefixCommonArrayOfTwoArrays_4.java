//Leetcode
//2657. Find the Prefix Common Array of Two Arrays - Using Bitmasking
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.Arrays;

public class FindThePrefixCommonArrayOfTwoArrays_4 {

    public static void main(String[] args) {
        int[] A = { 1, 3, 2, 4 };
        int[] B = { 3, 1, 2, 4 };
        System.out.println(Arrays.toString(findThePrefixCommonArray(A, B)));
    }

    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        boolean[] seen = new boolean[n + 1];
        int[] result = new int[n];
        int commonCount = 0;

        for (int i = 0; i < n; i++) {
            // Check for A[i]
            if (seen[A[i]])
                commonCount++;
            else
                seen[A[i]] = true;
            // Check for B[i]
            if (seen[B[i]])
                commonCount++;
            else
                seen[B[i]] = true;

            result[i] = commonCount;
        }
        return result;
    }
}
