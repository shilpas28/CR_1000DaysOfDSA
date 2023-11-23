//Leetcode
//1630. Arithmetic Subarrays - Without Sorting
//Time complexity: O(m*n)
//Space complexity: O(n)

package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArithmeticSubarrays_2 {

    public static void main(String[] args) {
        int[] nums = { 4, 6, 5, 9, 3, 7 };
        int[] l = { 0, 0, 2 };
        int[] r = { 2, 3, 5 };
        System.out.println(checkArithmeticSubarrays(nums, l, r));
    }

    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int[] arr = new int[r[i] - l[i] + 1];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = nums[l[i] + j];
            }
            ans.add(check(arr));
        }
        return ans;
    }

    static Boolean check(int[] arr) {
        int minElement = Integer.MAX_VALUE;
        int maxElement = Integer.MIN_VALUE;
        Set<Integer> arrSet = new HashSet<>();

        for (int num : arr) {
            minElement = Math.min(minElement, num);
            maxElement = Math.max(maxElement, num);
            arrSet.add(num);
        }
        if ((maxElement - minElement) % (arr.length - 1) != 0) {
            return false;
        }

        int diff = (maxElement - minElement) / (arr.length - 1);
        int curr = minElement + diff;
        while (curr < maxElement) {
            if (!arrSet.contains(curr)) {
                return false;
            }
            curr += diff;
        }
        return true;
    }
}
