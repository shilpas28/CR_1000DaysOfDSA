//Leetcode
//1460. Make Two Arrays Equal by Reversing Subarrays - Sorting
//Time complexity: O(NlogN) 
//Space complexity: O(1)

import java.util.Arrays;

public class MakeTwoArraysEqualByReversingSubarrays_2 {

    public static void main(String[] args) {
        int[] target = { 1, 2, 3, 4 };
        int[] arr = { 2, 4, 1, 3 };
        System.out.println(canBeEqual(target, arr));
    }

    public static boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }
}
