//Leetcode
//3355. Zero Array Transformation I - Not accepted as TLE 
//Time complexity: O(N^2)
//Space complexity: O(N)

import java.util.HashMap;
import java.util.Map;

public class ZeroArrayTransformationI {

    public static void main(String[] args) {
        int[] nums = { 1, 0, 1 };
        int[][] queries = { { 0, 2 } };
        System.out.println(isZeroArray(nums, queries));
    }

    public static boolean isZeroArray(int[] nums, int[][] queries) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int[] q : queries) {
            for (int i = q[0]; i <= q[1]; i++) {
                hm.put(i, hm.getOrDefault(i, 0) + 1);
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!hm.containsKey(i)) {
                if (nums[i] > 0)
                    return false;
            } else if (hm.get(i) < nums[i]) {
                return false;
            }
        }
        return true;
    }
}
