//Leetcode
//338. Counting Bits - Bit manipulation (slightly different from first solution)
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.Arrays;

public class CountingBits_2 {

    public static void main(String[] args) {
        int n = 2;
        System.out.println(Arrays.toString(countBits(n)));
    }

    public static int[] countBits(int n) {
        // notice, 0th index will contain 0. Since 0 in binary has 0 ones.
        int[] res = new int[n + 1];
        // we iterate through 1 to n
        for (int i = 1; i <= n; i++) {
            // if value of i is even and we right shift it by 1, the LSB that got
            // removed is 0. So number of 1's will be same with the value at resultant
            // index.
            // if value of i is odd and we right shift it by 1, the LSB that got
            // removed is 1. So number of 1's will be one extra than the value at resultant
            // index.
            if (i % 2 == 0)
                res[i] = res[i >> 1];
            else
                res[i] = res[i >> 1] + 1;
        }
        return res;
    }
}
