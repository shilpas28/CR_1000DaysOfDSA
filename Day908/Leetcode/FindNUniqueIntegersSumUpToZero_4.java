//Leetcode
//1304. Find N Unique Integers Sum up to Zero
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.Arrays;

public class FindNUniqueIntegersSumUpToZero_4 {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.toString(sumZero(n)));
    }

    public static int[] sumZero(int n) {
        int[] A = new int[n];
        for (int i = 0; i < n; ++i)
            A[i] = i * 2 - n + 1;
        return A;
    }
}
