//Leetcode
//2849. Determine if a Cell Is Reachable at a Given Time - Mathematical Approach with Maximum Difference Calculation
//Time complexity: O(1) - The time complexity of the code is O(1), which means it has constant time complexity. Regardless of 
//the input values or the size of the problem, the code performs a fixed number of operations. It calculates the absolute 
//differences, checks conditions, and returns a result in constant time.
//Space complexity: O(1) - The space complexity of the code is O(1) as well, indicating constant space complexity. The code 
//uses a few integer variables (e.g., xDifference, yDifference, maxDifference) to store values, and their memory usage does 
//not depend on the input size or any dynamic data structures. The space used is constant and does not grow with the problem 
//size.

package Leetcode;

public class DetermineIfACellIsReachableAtAGivenTime {

    public static void main(String[] args) {
        int sx = 3, sy = 1, fx = 7, fy = 3, t = 3;
        System.out.println(isReachableAtTime(sx, sy, fx, fy, t));
    }

    public static boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        // Check if the starting point is the same as the target point.
        if (sx == fx && sy == fy) {
            // If they are the same, check if time is 1, and return false (impossible to
            // stay at the same cell for 1 second).
            if (t == 1) {
                return false;
            }
        }
        // Calculate the absolute differences in x and y coordinates between the
        // starting and target points.
        int xDifference = sx - fx;
        int yDifference = sy - fy;
        // Ensure that xDifference and yDifference are non-negative.
        if (xDifference < 0) {
            xDifference = -xDifference;
        }
        if (yDifference < 0) {
            yDifference = -yDifference;
        }
        // Calculate the maximum difference between xDifference and yDifference.
        int maxDifference = Math.max(xDifference, yDifference);
        // Check if the maximum difference is less than or equal to the given time.
        if (maxDifference <= t) {
            return true; // It's possible to reach the target within the specified time.
        }
        // If the maximum difference is greater than the given time, return false.
        return false;
    }
}
