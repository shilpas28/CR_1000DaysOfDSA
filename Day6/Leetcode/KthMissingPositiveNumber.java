//Leetcode - Brute force solution
//1539. Kth Missing Positive Number
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class KthMissingPositiveNumber {

    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 7, 11 };
        int k = 5;
        System.out.println(findKthPositive(arr, k));
    }

    public static int findKthPositive(int[] arr, int k) {

        Set<Integer> set = new HashSet<>();
        for (int el : arr) {
            set.add(el);
        }

        int count = k;
        int start = 1;
        while (count > 0) {
            if (set.contains(start)) {
                start++;
            } else {
                count--;
                start++;

            }
        }
        return start - 1;
    }
}
