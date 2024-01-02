//Leetcode
//2610. Convert an Array Into a 2D Array With Conditions
//Time complexity: O(n)
//Space complexity: O(n)

package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class ConvertAnArrayIntoA2DArrayWithConditions_3 {

    public static void main(String[] args) {
        int[] nums = { 1, 3, 4, 1, 2, 3, 1 };
        System.out.println(findMatrix(nums));
    }

    public static List<List<Integer>> findMatrix(int[] nums) {
        int[] freq = new int[nums.length + 1];
        List<List<Integer>> ans = new ArrayList<>();

        for (int c : nums) {
            if (freq[c] >= ans.size()) {
                ans.add(new ArrayList<>());
            }
            ans.get(freq[c]).add(c);
            freq[c]++;
        }

        return ans;
    }
}
