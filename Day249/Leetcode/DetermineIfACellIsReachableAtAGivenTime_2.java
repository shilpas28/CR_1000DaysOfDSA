//Leetcode
//2849. Determine if a Cell Is Reachable at a Given Time - Mathematical Approach with Alternative Manhattan Distance Calculation
//Time complexity: O(1) - The time complexity of this code is O(1) because it performs a fixed number of arithmetic operations 
//and comparisons. The code calculates absolute differences, performs mathematical operations, and checks conditions, all of 
//which have constant time complexity. The number of steps executed remains constant regardless of the input values.
//Space complexity: O(1) - The space complexity is also O(1) because the code uses only a fixed amount of additional memory to 
//store the integer variables xDistance, yDistance, and min_dist. These variables occupy a constant amount of memory, and 
//their memory usage does not depend on the input size.

package Leetcode;

public class DetermineIfACellIsReachableAtAGivenTime_2 {

    public static void main(String[] args) {
        int sx = 3, sy = 1, fx = 7, fy = 3, t = 3;
        System.out.println(isReachableAtTime(sx, sy, fx, fy, t));
    }

    public static boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        // Calculate the absolute differences in x and y coordinates between the start
        // and target points.
        int xDistance = Math.abs(sx - fx);
        int yDistance = Math.abs(sy - fy);
        // Calculate the minimum Manhattan distance (minimum steps) to reach the target.
        int min_dist = Math.min(xDistance, yDistance) + Math.abs(yDistance - xDistance);
        // If the starting and target cells are the same, check if t is not 1.
        if (min_dist == 0) {
            if (t == 1) {
                return false; // If t is 1, it's impossible to stay at the same cell for that time, so return
                              // false.
            } else {
                return true; // If t is greater than 1, we can stay at the same cell for t seconds, so return
                             // true.
            }
        }
        // If the minimum distance is greater than 0, check if t is greater than or
        // equal to the minimum distance.
        return t >= min_dist; // If t is sufficient to cover the minimum distance, return true; otherwise,
                              // return false.
    }
}
