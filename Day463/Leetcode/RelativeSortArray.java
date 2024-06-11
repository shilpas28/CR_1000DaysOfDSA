//Leetcode
//1122. Relative Sort Array - Brute force - Using Two Loops and Sorting
//Time complexity: O(m+n + nlogn)
//Space complexity: O(n) or O(logn)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RelativeSortArray {

    public static void main(String[] args) {
        int[] arr1 = { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 }, arr2 = { 2, 1, 4, 3, 9, 6 };
        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] == arr2[i]) {
                    result.add(arr1[j]);
                    arr1[j] = -1;
                }
            }
        }

        Arrays.sort(arr1);
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != -1) {
                result.add(arr1[i]);
            }
        }
        // Convert List<Integer> to int[]
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
