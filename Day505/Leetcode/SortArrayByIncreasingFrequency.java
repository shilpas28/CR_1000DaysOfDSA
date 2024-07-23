//Leetcode
//1636. Sort Array by Increasing Frequency
//Time complexity: O(NLogN)
//Space complexity: O(N) 

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortArrayByIncreasingFrequency {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 2, 2, 3 };
        int[] res = frequencySort(nums);
        for (int val : res) {
            System.out.print(val + " ");
        }
    }

    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> {
            return (map.get(a) == map.get(b)) ? b - a : map.get(a) - map.get(b);
        });

        int[] res = new int[nums.length];
        int i = 0;
        for (int num : list) {
            for (int j = 0; j < map.get(num); j++) {
                res[i++] = num;
            }
        }
        return res;
    }
}
