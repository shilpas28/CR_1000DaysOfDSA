//Leetcode
//3350. Adjacent Increasing Subarrays Detection II
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.ArrayList;
import java.util.List;

public class AdjacentIncreasingSubarraysDetectionII_2 {

    public static void main(String[] args) {
        // nums = [2,5,7,8,9,2,3,4,3,1]
        List<Integer> nums = new ArrayList<Integer>();
        nums.add(2);
        nums.add(5);
        nums.add(7);
        nums.add(8);
        nums.add(9);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(3);
        nums.add(1);
        System.out.println(maxIncreasingSubarrays(nums));
    }

    public static int maxIncreasingSubarrays(List<Integer> nums) {
        int prev = 0;
        int curr = 1;
        int ans = 0;

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) < nums.get(i)) {
                curr++;
            } else {
                prev = curr;
                curr = 1;
            }
            ans = Math.max(ans, Math.max(curr / 2, Math.min(prev, curr)));
        }

        return ans;
    }
}
