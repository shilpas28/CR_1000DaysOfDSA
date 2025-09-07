//Leetcode
//1304. Find N Unique Integers Sum up to Zero
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.Arrays;

public class FindNUniqueIntegersSumUpToZero_3 {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.toString(sumZero(n)));
    }

    public static int[] sumZero(int n) {
        int[] a = new int[n];
        for (int i = 1; i < n; i++) {
            a[i] = i;
            a[0] -= i;
        }
        return a;
    }
}
