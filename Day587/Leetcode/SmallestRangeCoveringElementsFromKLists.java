//Leetcode
//632. Smallest Range Covering Elements from K Lists
//Time complexity: O(NlogN)
//Space complexity: O(N)

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class SmallestRangeCoveringElementsFromKLists {

    public static void main(String[] args) {
        // nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(4, 10, 15, 24, 26));
        nums.add(Arrays.asList(0, 9, 12, 20));
        nums.add(Arrays.asList(5, 18, 22, 30));
        System.out.println(Arrays.toString(smallestRange(nums)));
    }

    public static int[] smallestRange(List<List<Integer>> nums) {
        // Keep index of every element
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int n : nums.get(i)) {
                if (!map.containsKey(n))
                    map.put(n, new ArrayList<>());
                map.get(n).add(i);
            }
        }
        // Create a sorted array
        List<Integer> list = new ArrayList<>(map.keySet());
        // Sliding window
        int l = 0, r = 0;
        int[] ans = new int[] { list.get(0), list.get(list.size() - 1) };
        int[] cnt = new int[nums.size()];
        while (l < list.size()) {
            // Move right pointer
            while (r < list.size() && !allIn(cnt)) {
                for (int m : map.get(list.get(r)))
                    cnt[m]++;
                r++;
            }
            // Condition match
            if (allIn(cnt) && (list.get(r - 1) - list.get(l)) < (ans[1] - ans[0])) {
                ans = new int[] { list.get(l), list.get(r - 1) };
            }
            // Move left pointer
            for (int m : map.get(list.get(l)))
                cnt[m]--;
            l++;
        }
        return ans;
    }

    static boolean allIn(int[] cnt) {
        for (int c : cnt) {
            if (c == 0)
                return false;
        }
        return true;
    }
}
