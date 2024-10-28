//Leetcode
//2501. Longest Square Streak in an Array
//Time complexity: O(NlogN)
//Space complexity: O(N) 

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestSquareStreakInAnArray {

    public static void main(String[] args) {
        int[] nums = { 4, 3, 6, 16, 8, 2 };
        System.out.println(longestSquareStreak(nums));
    }

    public static int longestSquareStreak(int[] nums) {
        int max = -1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);

        List<Integer> setArr = new ArrayList<>(set);
        Collections.sort(setArr);

        for (int i = 0; i < setArr.size(); i++) {
            int curr = setArr.get(i);
            int count = 0;

            while (set.contains(curr)) {
                set.remove(curr);
                curr = curr * curr;
                count++;
            }
            max = Math.max(max, count);
        }
        return max > 1 ? max : -1;
    }
}
