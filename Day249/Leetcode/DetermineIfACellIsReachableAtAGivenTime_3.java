//Leetcode
//2849. Determine if a Cell Is Reachable at a Given Time - Mathematical Approach with Early Check for Same Cell
//Time complexity: O(1) - The time complexity of the code is O(1), which means it has constant time complexity. This is 
//because the code performs a fixed number of mathematical operations and comparisons, regardless of the input values. The 
//code calculates the minStep and performs a few simple comparisons, making it highly efficient and not dependent on the 
//size of the input.
//Space complexity: O(1) - The space complexity of the code is O(1) as well. The code doesn't use any data structures that 
//depend on the input size. It only uses a fixed amount of memory to store integer values and temporary variables, which 
//doesn't change with the input size. Therefore, the space complexity is constant.

package Leetcode;

public class DetermineIfACellIsReachableAtAGivenTime_3 {

    public static void main(String[] args) {
        int sx = 3, sy = 1, fx = 7, fy = 3, t = 3;
        System.out.println(isReachableAtTime(sx, sy, fx, fy, t));
    }

    public static boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        // Calculate the minimum number of steps (manhattan distance) needed to reach
        // the target.
        final int minStep = Math.max(Math.abs(sx - fx), Math.abs(sy - fy));
        // If the minimum number of steps is 0, it means we are already at the target
        // cell.
        // In this case, we can reach it only if t is not 1 (meaning we stay at the
        // current cell for t seconds).
        if (minStep == 0) {
            return t != 1;
        }
        // If the minimum number of steps is not 0, we need to check if t is greater
        // than or equal to minStep.
        // If t is greater than or equal to minStep, we can reach the target in t
        // seconds.
        return minStep <= t;
    }
}
