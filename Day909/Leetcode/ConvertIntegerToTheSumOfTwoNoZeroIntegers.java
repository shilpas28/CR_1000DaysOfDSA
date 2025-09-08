//Leetcode
//1317. Convert Integer to the Sum of Two No-Zero Integers
//Time complexity: O(nlogn)
//Space complexity: O(logn) 

import java.util.Arrays;

public class ConvertIntegerToTheSumOfTwoNoZeroIntegers {

    public static void main(String[] args) {
        int n = 11;
        System.out.println(Arrays.toString(getNoZeroIntegers(n)));
    }

    public static int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            int j = n - i;
            if (!String.valueOf(i).contains("0") && !String.valueOf(j).contains("0")) {
                return new int[] { i, j };
            }
        }
        return new int[0];
    }
}
