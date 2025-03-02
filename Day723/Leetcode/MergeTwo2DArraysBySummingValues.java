//Leetcode
//2570. Merge Two 2D Arrays by Summing Values - HashMap
//Time complexity: O((N1+N2)*log(N1+N2))
//Space complexity: O(N1+N2)

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MergeTwo2DArraysBySummingValues {

    public static void main(String[] args) {
        int[][] nums1 = { { 1, 2 }, { 2, 3 }, { 4, 5 } };
        int[][] nums2 = { { 1, 4 }, { 3, 2 }, { 4, 1 } };
        int[][] res = mergeArrays(nums1, nums2);
        for (int[] row : res) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> keyToSum = new TreeMap<>();
        // Copying the array nums1 to the map.
        for (int[] nums : nums1) {
            keyToSum.put(nums[0], nums[1]);
        }
        // Adding the values to existing keys or create new entries.
        for (int[] nums : nums2) {
            keyToSum.put(nums[0], keyToSum.getOrDefault(nums[0], 0) + nums[1]);
        }

        List<int[]> mergedList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : keyToSum.entrySet()) {
            mergedList.add(new int[] { entry.getKey(), entry.getValue() });
        }
        // Convert the mergedList to int[][] array.
        int[][] mergedArray = new int[mergedList.size()][2];
        for (int i = 0; i < mergedList.size(); i++) {
            mergedArray[i] = mergedList.get(i);
        }
        return mergedArray;
    }
}
