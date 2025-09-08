//Leetcode
//1317. Convert Integer to the Sum of Two No-Zero Integers
//Time complexity: O(nlogn)
//Space complexity: O(1)

import java.util.Arrays;

public class ConvertIntegerToTheSumOfTwoNoZeroIntegers_2 {

    public static void main(String[] args) {
        int n = 11;
        System.out.println(Arrays.toString(getNoZeroIntegers(n)));
    }

    public static int[] getNoZeroIntegers(int n) {
        for (int a = 1; a < n; a++) {
            int b = n - a;
            if (noZero(a) && noZero(b)) {
                return new int[] { a, b };
            }
        }
        return new int[] {};
    }

    static boolean noZero(int x) {
        while (x > 0) {
            if (x % 10 == 0)
                return false;
            x /= 10;
        }
        return true;
    }
}
