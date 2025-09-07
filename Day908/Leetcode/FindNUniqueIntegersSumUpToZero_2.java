//Leetcode
//1304. Find N Unique Integers Sum up to Zero
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.Arrays;

public class FindNUniqueIntegersSumUpToZero_2 {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.toString(sumZero(n)));
    }

    public static int[] sumZero(int n) {
        int[] res = new int[n];
        int left = 0, right = n - 1, start = 1;
        while (left < right) {
            res[left++] = start;
            res[right--] = -start;
            start++;
        }
        return res;
    }
}
