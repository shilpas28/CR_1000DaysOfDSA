//Leetcode
//1122. Relative Sort Array - Better approach - Using HashMap for Counting and Sorting
//Time complexity: O(m+nlogn)
//Space complexity: O(n+m) i.e O(n)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelativeSortArray_2 {

    public static void main(String[] args) {
        int[] arr1 = { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 }, arr2 = { 2, 1, 4, 3, 9, 6 };
        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> remaining = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        // Initialize count map with relative order elements
        for (int num : arr2) {
            countMap.put(num, 0);
        }
        // Count occurrences of elements in target array
        for (int num : arr1) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                remaining.add(num);
            }
        }
        // Sort the remaining elements
        Collections.sort(remaining);
        // Add elements as per relative order
        for (int num : arr2) {
            for (int j = 0; j < countMap.get(num); j++) {
                result.add(num);
            }
        }
        // Add remaining elements
        result.addAll(remaining);
        // Convert List<Integer> to int[]
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
