//Leetcode
//624. Maximum Distance in Arrays
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumDistanceInArrays {

    public static void main(String[] args) {
        // arrays = [[1,2,3],[4,5],[1,2,3]]
        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(Arrays.asList(1, 2, 3));
        arrays.add(Arrays.asList(4, 5));
        arrays.add(Arrays.asList(1, 2, 3));
        System.out.println(maxDistance(arrays));
    }

    public static int maxDistance(List<List<Integer>> arrays) {
        int result = Integer.MIN_VALUE;
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int min = arrays.get(0).get(0);

        for (int i = 1; i < arrays.size(); i++) {
            result = Math.max(result, Math.abs(arrays.get(i).get(0) - max));
            result = Math.max(result, Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - min));
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
            min = Math.min(min, arrays.get(i).get(0));
        }
        return result;
    }
}
