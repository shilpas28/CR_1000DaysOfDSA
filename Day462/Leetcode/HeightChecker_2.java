//Leetcode
//1051. Height Checker
//Time complexity: O(n), where n = heights.length.
//Space complexity: O(n), where n = heights.length.

public class HeightChecker_2 {

    public static void main(String[] args) {
        int[] heights = { 1, 1, 4, 2, 1, 3 };
        System.out.println(heightChecker(heights));
    }

    public static int heightChecker(int[] heights) {
        int[] cnt = new int[101];
        for (int h : heights) {
            ++cnt[h];
        }
        for (int i = 1; i <= 100; ++i) {
            cnt[i] += cnt[i - 1];
        }
        int ans = 0;
        for (int i = heights.length - 1; i >= 0; --i) {
            if (heights[--cnt[heights[i]]] != heights[i])
                ++ans;
        }
        return ans;
    }
}
