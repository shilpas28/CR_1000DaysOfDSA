//Leetcode
//3394. Check if Grid can be Cut into Sections
//Time complexity: O(NlogN)
//Space complexity: O(N) 

import java.util.Arrays;

public class CheckIfGridCanBeCutIntoSections {

    public static void main(String[] args) {
        int n = 5;
        int[][] rectangles = { { 1, 0, 5, 2 }, { 0, 2, 2, 4 }, { 3, 2, 5, 3 }, { 0, 4, 4, 5 } };
        System.out.println(checkValidCuts(n, rectangles));
    }

    public static boolean checkValidCuts(int n, int[][] rectangles) {
        return check(rectangles, 0) || check(rectangles, 1);
    }

    static boolean check(int[][] rectangles, int i) {
        int res = 0;
        Arrays.sort(rectangles, (a, b) -> Integer.compare(a[i], b[i]));
        int pre = rectangles[0][i + 2];
        for (int[] r : rectangles) {
            if (pre <= r[i]) {
                res++;
            }
            pre = Math.max(pre, r[i + 2]);
        }
        return res > 1;
    }
}
