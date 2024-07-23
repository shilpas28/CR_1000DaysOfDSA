//Leetcode
//1636. Sort Array by Increasing Frequency
//Time complexity: O(NlogN)
//Space complexity: O(N) 

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortArrayByIncreasingFrequency_2 {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 2, 2, 3 };
        int[] res = frequencySort(nums);
        for (int val : res) {
            System.out.print(val + " ");
        }
    }

    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        // count frequency of each number
        Arrays.stream(nums).forEach(n -> map.put(n, map.getOrDefault(n, 0) + 1));
        // custom sort
        return Arrays.stream(nums).boxed()
                .sorted((a, b) -> map.get(a) != map.get(b) ? map.get(a) - map.get(b) : b - a)
                .mapToInt(n -> n)
                .toArray();
    }
}
