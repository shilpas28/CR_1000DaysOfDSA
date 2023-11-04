//Leetcode
//1503. Last Moment Before All Ants Fall Out of a Plank - Two Passes
//Time complexity: O(N) - The time complexity of this code is O(N), where N is the length of the plank. This is because we 
//iterate through the positions of ants moving to the left and right once, comparing each ant's position with the current 
//maximum time. Both loops iterate through the left and right ant positions separately, but they do not depend on each other 
//or nest within each other, so the time complexity remains linear.
//Space complexity: O(1) - The space complexity of this code is O(1). It uses a constant amount of additional space 
//regardless of the input size. The only extra space used is for the time variable and the loop control variables (pos), 
//which do not depend on the input size. The input arrays left and right are not creating additional space in proportion to 
//the input size, so they do not contribute to the space complexity.

package Leetcode;

public class LastMomentBeforeAllAntsFallOutOfAPlank_2 {

    public static void main(String[] args) {
        int n = 4;
        int[] left = { 4, 3 };
        int[] right = { 0, 1 };
        System.out.println(getLastMoment(n, left, right));
    }

    public static int getLastMoment(int n, int[] left, int[] right) {
        // Initialize a variable to keep track of the maximum time
        int time = 0;
        // Iterate through the positions of ants moving to the left
        for (int pos : left) {
            // Update the maximum time if the current left-moving ant's position is greater
            // than the previously recorded maximum time
            time = Math.max(time, pos);
        }
        // Iterate through the positions of ants moving to the right
        for (int pos : right) {
            // Update the maximum time if the current right-moving ant's position (relative
            // to
            // the right end of the plank) is greater than the previously recorded maximum
            // time
            time = Math.max(time, n - pos);
        }
        // The final 'time' variable contains the maximum time, which is when the last
        // ant(s)
        // fall off the plank, so return it as the result.
        return time;
    }
}
