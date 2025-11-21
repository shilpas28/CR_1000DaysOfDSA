//Leetcode
//757. Set Intersection Size At Least Two
//Time complexity: O(NlogN)
//Space complexity: O(1)

import java.util.Arrays;

public class SetIntersectionSizeAtLeastTwo_2 {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {3, 7}, {8, 9}};
        System.out.println(intersectionSizeTwo(intervals));
    }

    public static int intersectionSizeTwo(int[][] intervals) {

        Arrays.sort(intervals, (x, y) -> {
            if (x[1] == y[1]) {
                return y[0] - x[0];
            }
            return x[1] - y[1];
        });
        
        int ans = 0, a = -1, b = -1;
        for (int[] interval : intervals) {
            int l = interval[0];
            int r = interval[1];
            if (l > b) {
                a = r - 1;
                b = r;
                ans += 2;
            } else if (l > a) {
                a = b;
                b = r;
                ans += 1;
            }
        }
        return ans;
    }
}
