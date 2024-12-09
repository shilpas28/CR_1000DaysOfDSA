//Leetcode
//3152. Special Array II - Using Binary Search
//Time complexity: O(N) + O(Q * LOG(N))
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpecialArrayII {

    public static void main(String[] args) {
        int[] nums = { 3, 4, 1, 2, 6 };
        int[][] queries = { { 0, 4 } };
        System.out.println(Arrays.toString(isArraySpecial(nums, queries)));
    }

    public static boolean[] isArraySpecial(int[] nums, int[][] queries) {
        List<Integer> B = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 == nums[i - 1] % 2) {
                B.add(i);
            }
        }
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int L = BinarySearch(queries[i][0], B);
            int R = BinarySearch(queries[i][1], B);
            if (R - L == 0)
                ans[i] = true;
            else
                ans[i] = false;
        }
        return ans;
    }

    static int BinarySearch(int Target, List<Integer> B) {
        int Pos = B.size();
        int low = 0, high = B.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (B.get(mid) > Target) {
                Pos = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return Pos;
    }
}
