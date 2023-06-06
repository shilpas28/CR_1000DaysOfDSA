//Leetcode
//1502. Can Make Arithmetic Progression From Sequence
//Time complexity: O(NlogN)
//Space complexity: O(N)

package Leetcode;

import java.util.Arrays;

public class CanMakeArithmeticProgressionFromSequence {

    public static void main(String[] args) {
        int[] arr = { 3, 5, 1 };
        System.out.println(canMakeArithmeticProgression(arr));
    }

    public static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int d = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++)
            if (arr[i] - arr[i - 1] != d)
                return false;
        return true;
    }
}
