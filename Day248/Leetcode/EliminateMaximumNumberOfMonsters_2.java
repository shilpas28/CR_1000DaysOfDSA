//Leetcode
//1921. Eliminate Maximum Number of Monsters - Better Method
//Time complexity: O(N * log(N)) - The code calculates the arrival times for each monster, which requires iterating through 
//the dist and speed arrays, resulting in O(N) operations. Sorting the arrivalTime array using Arrays.sort has a time 
//complexity of O(N * log(N)). The final loop iterates through the sorted arrivalTime array, performing a constant-time 
//comparison for each element, which is also O(N). Therefore, the overall time complexity of the code 
//is O(N + N * log(N) + N), which simplifies to O(N * log(N)) because the sorting dominates the time complexity.
//Space complexity: O(N) - The code uses an additional integer array arrivalTime of size N to store the arrival times for 
//each monster. Other variables used in the code are of constant space. Therefore, the space complexity is O(N) due to the 
//arrivalTime array, and the space used for other variables is considered constant.

package Leetcode;

import java.util.Arrays;

public class EliminateMaximumNumberOfMonsters_2 {

    public static void main(String[] args) {
        int[] dist = { 1, 3, 4 };
        int[] speed = { 1, 1, 1 };
        System.out.println(eliminateMaximum(dist, speed));
    }

    public static int eliminateMaximum(int[] dist, int[] speed) {
        final int n = dist.length;
        int[] arrivalTime = new int[n];
        // Calculate the arrival time for each monster
        for (int i = 0; i < n; ++i) {
            arrivalTime[i] = (dist[i] - 1) / speed[i];
            // The formula calculates the time it takes for a monster to reach the city.
            // We subtract 1 from dist[i] because we lose if the monster reaches the city at
            // the exact moment the weapon is charged.
        }
        // Sort the arrival times in ascending order
        Arrays.sort(arrivalTime);
        // Iterate through the sorted arrival times and check if the game can be lost
        for (int i = 0; i < n; ++i) {
            if (i > arrivalTime[i]) {
                // If the current monster arrives later than the minute when it should be
                // eliminated, return the index.
                // This means that you cannot eliminate all monsters before they reach the city.
                return i;
            }
        }
        // If you reach this point, it means that you can eliminate all monsters before
        // they reach the city.
        return n;
    }
}
