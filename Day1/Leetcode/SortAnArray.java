//Leetcode 
//912. Sort an Array
//Using Mergesort
//Time complexity: O(nlogn)
//Space complexity: O(n)

import java.util.Arrays;
public class SortAnArray {

    public static void main(String[] args) {
        int[] nums = { 5, 2, 3, 1 };
        System.out.println(Arrays.toString(nums));
        System.out.println("-------------------");
        nums = sortArray(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static int[] sortArray(int[] nums) {
        nums = mergeSortHelper(nums);
        return nums;
    }

    public static int[] mergeSortHelper(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }
        int mid = nums.length / 2;
        int[] left = mergeSortHelper(Arrays.copyOfRange(nums, 0, mid));
        int[] right = mergeSortHelper(Arrays.copyOfRange(nums, mid, nums.length));
        return merge(left, right);
    }

    public static int[] merge(int[] first, int[] second) {
        int[] res = new int[first.length + second.length];
        int i = 0, j = 0, k = 0;
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                res[k] = first[i];
                i++;
            } else {
                res[k] = second[j];
                j++;
            }
            k++;
        }
        while (i < first.length) {
            res[k] = first[i];
            i++;
            k++;
        }
        while (j < second.length) {
            res[k] = second[j];
            j++;
            k++;
        }
        return res;
    }

}
