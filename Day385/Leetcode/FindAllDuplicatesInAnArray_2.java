//Leetcode
//442. Find All Duplicates in an Array
//Time complexity: O(n)
//Space complexity: O(1) using cycle sort algorithm, hence no extra space

package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray_2 {

    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(findDuplicates(nums));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int i = 0; // Cyclic sort code
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
        // Searching for the duplicate numbers after sorting and add to list
        for (int index = 0; index < nums.length; index++) {
            if (index + 1 != nums[index])
                list.add(nums[index]);
        }
        return list;
    }

    // Code for swapping two numbers
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
