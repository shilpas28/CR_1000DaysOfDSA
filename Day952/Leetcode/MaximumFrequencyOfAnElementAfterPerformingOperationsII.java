//Leetcode
//3347. Maximum Frequency of an Element After Performing Operations II
//Time complexity: O(NlogN)
//Space complexity: O(N) 

package Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MaximumFrequencyOfAnElementAfterPerformingOperationsII {

    public static void main(String[] args) {
        int[] nums = { 1, 4, 5 };
        int k = 1, numOperations = 2;
        System.out.println(maxFrequency(nums, k, numOperations));
    }

    public static int maxFrequency(int[] nums, int k, int numOperations) {
        Map<Integer, Integer> pointsCover = new HashMap<>();
        Map<Integer, Integer> cntPoints = new HashMap<>();
        Set<Integer> points = new TreeSet<>(); // TreeSet to keep points sorted

        for (int num : nums) {
            cntPoints.put(num, cntPoints.getOrDefault(num, 0) + 1);
            pointsCover.put(num - k, pointsCover.getOrDefault(num - k, 0) + 1);
            pointsCover.put(num + k + 1, pointsCover.getOrDefault(num + k + 1, 0) - 1);
            points.add(num);
            points.add(num - k);
            points.add(num + k + 1);
        }

        int res = 0;
        int pointsCoverThisPoint = 0;

        for (int point : points) {
            pointsCoverThisPoint += pointsCover.getOrDefault(point, 0);
            res = Math.max(res, cntPoints.getOrDefault(point, 0) +
                    Math.min(pointsCoverThisPoint - cntPoints.getOrDefault(point, 0), numOperations));
        }

        return res;
    }
}
