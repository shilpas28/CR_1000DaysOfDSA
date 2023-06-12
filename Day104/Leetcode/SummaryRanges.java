//Leetcode
//Summary Ranges
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        System.out.println(summaryRanges(nums));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int n = nums.length;
        if (n == 0)
            return result;
        int a = nums[0];
        for (int i = 0; i < n; ++i) {
            if (i == n - 1 || nums[i + 1] != nums[i] + 1) {
                if (nums[i] != a)
                    result.add(a + "->" + nums[i]);
                else
                    result.add(a + "");
                if (i != n - 1)
                    a = nums[i + 1];
            }
        }
        return result;
    }
}
