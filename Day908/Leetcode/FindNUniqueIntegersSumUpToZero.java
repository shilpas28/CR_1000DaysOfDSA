//Leetcode
//1304. Find N Unique Integers Sum up to Zero
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.Arrays;

public class FindNUniqueIntegersSumUpToZero {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.toString(sumZero(n)));
    }

    public static int[] sumZero(int n) {
        int[] result = new int[n];
        int sum = 0;

        for (int i = 0; i < n - 1; i++) {
            result[i] = i + 1;
            sum += result[i];
        }
        result[n - 1] = -1 * sum;
        return result;
    }
}
