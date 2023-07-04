//Leetcode
//137. Single Number II
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.HashMap;

public class SingleNumberII {

    public static void main(String[] args) {
        int[] nums = { 2, 2, 3, 2 };
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }
}
