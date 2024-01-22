//Leetcode
//645. Set Mismatch - Maps
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class SetMismatch_4 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 4 };
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }

    public static int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] res = new int[2];
        HashMap<Integer, Integer> hs = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (hs.containsKey(nums[i])) {
                res[0] = nums[i];
            }

            hs.put(nums[i], hs.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 1; i <= n; i++) {
            if (!hs.containsKey(i)) {
                res[1] = i;
            }
        }
        return res;
    }
}
