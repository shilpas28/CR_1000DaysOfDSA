//Leetcode
//1503. Last Moment Before All Ants Fall Out of a Plank - Two Passes with Stream and Math Operation
//Time complexity: O(n_left + n_right) - Finding the maximum position among ants moving to the left using 
//Arrays.stream(left).max() takes O(n_left) time, where n_left is the number of ants moving to the left. Finding the minimum 
//position among ants moving to the right using Arrays.stream(right).min() takes O(n_right) time, where n_right is the 
//number of ants moving to the right. The time complexity of the Math.max() operation is O(1), and the same applies to the 
//subtraction and addition operations. The overall time complexity of the code is O(n_left + n_right), where n_left and 
//n_right are the sizes of the left and right arrays, respectively.
//Space complexity: O(n_left + n_right) - The space complexity is primarily determined by the additional space used for the 
//streams and variables. The space required for the stream created from the left and right arrays is O(n_left + n_right), as 
//it effectively stores a copy of these arrays. The space used for the maxLeft and minRight variables is O(1) because they 
//are single integers. Therefore, the overall space complexity is O(n_left + n_right).

package Leetcode;

import java.util.Arrays;

public class LastMomentBeforeAllAntsFallOutOfAPlank {

    public static void main(String[] args) {
        int n = 4;
        int[] left = { 4, 3 };
        int[] right = { 0, 1 };
        System.out.println(getLastMoment(n, left, right));
    }

    public static int getLastMoment(int n, int[] left, int[] right) {
        // Find the farthest position among ants moving to the left.
        int maxLeft = Arrays.stream(left).max().orElse(0);
        // Find the nearest position among ants moving to the right.
        int minRight = n - Arrays.stream(right).min().orElse(n);
        // Calculate the time when the last ant(s) fall.
        return Math.max(maxLeft, minRight);
    }
}
