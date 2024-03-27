//Leetcode
//442. Find All Duplicates in an Array
//Time complexity: O(n)
//Space complexity: O(n) using extra hashset

package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindAllDuplicatesInAnArray {

    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(findDuplicates(nums));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                list.add(nums[i]);
            else
                set.add(nums[i]);
        }
        return list;
    }
}
