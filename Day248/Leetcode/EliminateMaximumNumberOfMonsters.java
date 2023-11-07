//Leetcode
//1921. Eliminate Maximum Number of Monsters - Brute Force Method - Not accepted as TLE
//Time complexity: (O(N^2)) - In the solution, there is a while loop that continues until all monsters are eliminated. In 
//each iteration of the loop, there is a nested loop that searches for the monster with the smallest time to reach the city. 
//The nested loop has a time complexity of O(N) as it iterates through all monsters. In the worst case, the while loop will 
//iterate n times because each time a monster is eliminated, the loop checks all remaining monsters. Therefore, the overall 
//time complexity is O(N) * O(N) = O(N^2).
//Space complexity: O(N) - The space complexity is determined by the additional space used to store the timeToCity array, 
//which has a size of n to store the time it takes for each monster to reach the city. Hence, the space complexity is O(N). 

package Leetcode;

public class EliminateMaximumNumberOfMonsters {

    public static void main(String[] args) {
        int[] dist = { 1, 3, 4 };
        int[] speed = { 1, 1, 1 };
        System.out.println(eliminateMaximum(dist, speed));
    }

    public static int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] timeToCity = new int[n]; // Array to store the time it takes for each monster to reach the city

        for (int i = 0; i < n; i++) {
            timeToCity[i] = dist[i] / speed[i]; // Calculate the time for each monster to reach the city
        }

        int eliminatedCount = 0; // Number of eliminated monsters
        int time = 0; // Current time in minutes

        while (eliminatedCount < n) {
            // Find the monster with the smallest time to reach the city
            int minTimeIndex = -1;
            for (int i = 0; i < n; i++) {
                if (timeToCity[i] >= 0 && (minTimeIndex == -1 || timeToCity[i] < timeToCity[minTimeIndex])) {
                    minTimeIndex = i;
                }
            }
            if (minTimeIndex != -1) {
                // If the monster can be eliminated before it reaches the city, eliminate it
                if (timeToCity[minTimeIndex] <= time) {
                    eliminatedCount++;
                    timeToCity[minTimeIndex] = -1; // Mark the monster as eliminated
                }
            }
            // Update the time for remaining monsters
            for (int i = 0; i < n; i++) {
                if (timeToCity[i] >= 0) {
                    timeToCity[i]--; // Decrease the time for monsters still on the way
                }
            }
            // Charge the weapon for one minute
            time++;
        }
        return n; // All monsters eliminated before any reaches the city
    }
}
