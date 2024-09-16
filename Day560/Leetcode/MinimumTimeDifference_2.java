//Leetcode
//539. Minimum Time Difference - Counting Sort
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class MinimumTimeDifference_2 {

    public static void main(String[] args) {
        // timePoints = ["23:59","00:00"]
        List<String> timePoints = new ArrayList<>();
        timePoints.add("23:59");
        timePoints.add("00:00");
        System.out.println(findMinDifference(timePoints));
    }

    public static int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        boolean[] buckets = new boolean[24 * 60];
        for (int i = 0; i < n; i++) {
            int t = parse(timePoints.get(i));
            if (buckets[t])
                return 0;
            buckets[t] = true;
        }

        int min = Integer.MAX_VALUE;
        int pre = 0, first = -1;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i]) {
                if (first == -1)
                    first = i;
                else
                    min = Math.min(min, i - pre);
                pre = i;
            }
        }
        min = Math.min(min, first - pre + 24 * 60);
        return min;
    }

    static int parse(String s) {
        String[] split = s.split(":");
        int h = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        return h * 60 + m;
    }
}
