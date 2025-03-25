//Leetcode
//3394. Check if Grid can be Cut into Sections
//Time complexity: O(NlogN)
//Space complexity: O(N) 

import java.util.Arrays;

public class CheckIfGridCanBeCutIntoSections_2 {

    public static void main(String[] args) {
        int n = 5;
        int[][] rectangles = { { 1, 0, 5, 2 }, { 0, 2, 2, 4 }, { 3, 2, 5, 3 }, { 0, 4, 4, 5 } };
        System.out.println(checkValidCuts(n, rectangles));
    }

    public static boolean checkValidCuts(int n, int[][] rectangles) {
        int[][] X = new int[rectangles.length][2];
        int[][] Y = new int[rectangles.length][2];
        for (int i = 0; i < rectangles.length; i++) {
            X[i][0] = rectangles[i][0];
            Y[i][0] = rectangles[i][1];
            X[i][1] = rectangles[i][2];
            Y[i][1] = rectangles[i][3];
        }
        return check(X) || check(Y);
    }

    static boolean check(int[][] A) {
        int res = 0;
        Arrays.sort(A, (a, b) -> Integer.compare(a[0], b[0]));
        int pre = A[0][1];
        for (int[] ab : A) {
            int a = ab[0], b = ab[1];
            if (pre <= a) {
                res++;
            }
            pre = Math.max(pre, b);
        }
        return res > 1;
    }
}
