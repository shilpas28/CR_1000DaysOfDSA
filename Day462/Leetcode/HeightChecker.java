//Leetcode
//1051. Height Checker
//Time complexity: O(nlogn)
//Space complexity: O(n), where n = heights.length, space includes the returning array h.

import java.util.Arrays;

public class HeightChecker {

    public static void main(String[] args) {
        int[] heights = { 1, 1, 4, 2, 1, 3 };
        System.out.println(heightChecker(heights));
    }

    public static int heightChecker(int[] heights) {
        int[] h = heights.clone();
        Arrays.sort(h);
        int ans = 0;
        for (int i = 0; i < h.length; ++i) {
            if (h[i] != heights[i])
                ++ans;
        }
        return ans;
    }
}
