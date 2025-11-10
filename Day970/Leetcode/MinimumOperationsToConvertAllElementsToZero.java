//Leetcode
//3542. Minimum Operations to Convert All Elements to Zero
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.List;

public class MinimumOperationsToConvertAllElementsToZero {

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2, 1 };
        System.out.println(minOperations(nums));
    }

    public static int minOperations(int[] nums) {
        List<Integer> s = new ArrayList<>();
        int res = 0;
        for (int a : nums) {
            while (!s.isEmpty() && s.get(s.size() - 1) > a) {
                s.remove(s.size() - 1);
            }
            if (a == 0)
                continue;
            if (s.isEmpty() || s.get(s.size() - 1) < a) {
                res++;
                s.add(a);
            }
        }
        return res;
    }
}
