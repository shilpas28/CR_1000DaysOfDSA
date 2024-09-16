//Leetcode
//539. Minimum Time Difference - General Sort
//Time complexity: O(NlogN)
//Space complexity: O(N)

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference {

    public static void main(String[] args) {
        // timePoints = ["23:59","00:00"]
        List<String> timePoints = new ArrayList<>();
        timePoints.add("23:59");
        timePoints.add("00:00");
        System.out.println(findMinDifference(timePoints));
    }

    public static int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = parse(timePoints.get(i));
        }

        Arrays.sort(times);

        int min = times[0] - times[n - 1] + 24 * 60;
        for (int i = 1; i < n; i++) {
            min = Math.min(min, times[i] - times[i - 1]);
        }
        return min;
    }

    static int parse(String s) {
        String[] split = s.split(":");
        int h = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        return h * 60 + m;
    }
}
