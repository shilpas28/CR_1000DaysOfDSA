//Leetcode
//1122. Relative Sort Array - Optimised Approach - Using Counting Sort
//Time complexity: O(m+n+k)
//Space complexity: O(k)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RelativeSortArray_3 {

    public static void main(String[] args) {
        int[] arr1 = { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 }, arr2 = { 2, 1, 4, 3, 9, 6 };
        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int maxElement = Arrays.stream(arr1).max().orElse(0);
        int[] count = new int[maxElement + 1];
        // Count occurrences of each element
        for (int element : arr1) {
            count[element]++;
        }
        List<Integer> result = new ArrayList<>();
        // Add elements as per relative order
        for (int value : arr2) {
            while (count[value] > 0) {
                result.add(value);
                count[value]--;
            }
        }
        // Add remaining elements in ascending order
        for (int num = 0; num <= maxElement; num++) {
            while (count[num] > 0) {
                result.add(num);
                count[num]--;
            }
        }
        // Convert ArrayList to array
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
