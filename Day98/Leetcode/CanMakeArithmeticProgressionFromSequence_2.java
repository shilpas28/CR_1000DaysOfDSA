//Leetcode
//1502. Can Make Arithmetic Progression From Sequence
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class CanMakeArithmeticProgressionFromSequence_2 {
    public static void main(String[] args) {
        int[] arr = { 3, 5, 1 };
        System.out.println(canMakeArithmeticProgression(arr));
    }

    public static boolean canMakeArithmeticProgression(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            set.add(num);
        }
        int n = arr.length;
        int d = max - min;
        if (d % (n - 1) != 0)
            return false;
        d /= n - 1;
        int i = 0;
        while (i < n) {
            if (!set.contains(min))
                return false;
            min += d;
            i++;
        }
        return true;
    }
}
