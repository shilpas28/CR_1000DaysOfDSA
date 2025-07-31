//Leetcode
//898. Bitwise ORs of Subarrays
//Time complexity: O(nlogM) where ( n ) is the array size and ( M ) is the max number value (due to bit-length of integers).
//Space complexity: O(n) for storing intermediate and final sets.

import java.util.HashSet;
import java.util.Set;

public class BitwiseOrsOfSubarrays {

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2 };
        System.out.println(subarrayBitwiseORs(arr));
    }

    public static int subarrayBitwiseORs(int[] arr) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        for (int num : arr) {
            Set<Integer> next = new HashSet<>();
            next.add(num);
            for (int x : cur) {
                next.add(x | num);
            }
            cur = next;
            res.addAll(cur);
        }
        return res.size();
    }
}
