//Leetcode
//2610. Convert an Array Into a 2D Array With Conditions
//Time complexity: O(n^2)
//Space complexity: O(n)

package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertAnArrayIntoA2DArrayWithConditions {

    public static void main(String[] args) {
        int[] nums = { 1, 3, 4, 1, 2, 3, 1 };
        System.out.println(findMatrix(nums));
    }

    public static List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> um = new HashMap<>();
        for (int i : nums) {
            um.put(i, um.getOrDefault(i, 0) + 1);
        }

        List<List<Integer>> ans = new ArrayList<>();
        while (!um.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            List<Integer> toErase = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : um.entrySet()) {
                int f = entry.getKey();
                int s = entry.getValue();
                temp.add(f);
                s--;
                if (s == 0) {
                    toErase.add(f);
                }
                um.put(f, s);
            }
            ans.add(temp);
            for (int i : toErase) {
                um.remove(i);
            }
        }
        return ans;
    }
}
