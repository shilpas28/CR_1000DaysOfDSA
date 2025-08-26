//Leetcode
//3000. Maximum Area of Longest Diagonal Rectangle
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class MaximumAreaOfLongestDiagonalRectangle {

    public static void main(String[] args) {
        int[][] dimensions = { { 9, 3 }, { 8, 6 } };
        System.out.println(areaOfMaxDiagonal(dimensions));
    }

    public static int areaOfMaxDiagonal(int[][] dimensions) {
        int n = dimensions.length;
        int maxArea = 0, maxDiag = 0;

        for (int i = 0; i < n; i++) {
            int l = dimensions[i][0];
            int w = dimensions[i][1];
            int currDiag = l * l + w * w;

            if (currDiag > maxDiag || (currDiag == maxDiag && l * w > maxArea)) {
                maxDiag = currDiag;
                maxArea = l * w;
            }
        }
        return maxArea;
    }
}
