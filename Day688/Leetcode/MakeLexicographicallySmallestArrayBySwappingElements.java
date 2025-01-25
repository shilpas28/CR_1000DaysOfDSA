//Leetcode
//2948. Make Lexicographically Smallest Array by Swapping Elements
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.Arrays;
import java.util.*;

public class MakeLexicographicallySmallestArrayBySwappingElements {

    public static void main(String[] args) {
        int[] nums = { 1, 5, 3, 9, 8 };
        int limit = 2;
        System.out.println(Arrays.toString(lexicographicallySmallestArray(nums, limit)));
    }

    public static int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] nums2 = new int[n][2];
        int[] result = new int[n];
        List<List<Integer>> indices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums2[i][0] = nums[i];
            nums2[i][1] = i;
        }
        Arrays.sort(nums2, (x1, x2) -> Integer.compare(x1[0], x2[0]));
        for (int i = 0; i < n; i++) {
            if (i == 0 || nums2[i][0] - nums2[i - 1][0] > limit) {
                indices.add(new ArrayList<>());
            }
            indices.get(indices.size() - 1).add(nums2[i][1]);
        }
        for (List<Integer> index: indices) { // index is one set of sortable numbers
            List<Integer> sortedIndex = new ArrayList<>(index);
            Collections.sort(sortedIndex);
            for (int j = 0; j < index.size(); j++) {
                result[sortedIndex.get(j)] = nums[index.get(j)];
            }
        }
        return result;
    }
}
