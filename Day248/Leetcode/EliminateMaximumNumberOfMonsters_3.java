//Leetcode
//1921. Eliminate Maximum Number of Monsters - Greedy Approach (Optimal Method)
//Time complexity: O(N)- Calculating Arrival Times: The loop that calculates the arrival times for each monster runs in O(N) 
//time, where N is the number of monsters. Counting Monsters Arriving at Each Minute: The loop that counts the number of 
//monsters arriving at each minute also runs in O(N) time. Calculating Cumulative Counts: The loop that calculates the 
//cumulative counts of monsters arriving at or before each minute runs in O(N) time. Overall, the time complexity of the 
//code is O(N).
//Space complexity: O(N) - "arrivalTimes" Array: The space required to store the "arrivalTimes" array is O(N), as it stores 
//the arrival times for each monster. "speeds" Array: The "speeds" array is used to count the number of monsters arriving at 
//each minute. Its space complexity is also O(N). Overall, the space complexity of the code is O(N).

package Leetcode;

public class EliminateMaximumNumberOfMonsters_3 {

    public static void main(String[] args) {
        int[] dist = { 1, 3, 4 };
        int[] speed = { 1, 1, 1 };
        System.out.println(eliminateMaximum(dist, speed));
    }

    public static int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length; // Number of monsters
        // Calculate the time it takes for each monster to reach the city and store it
        // in the "arrivalTimes" array.
        int[] arrivalTimes = new int[n];
        for (int i = 0; i < n; i++) {
            arrivalTimes[i] = (int) Math.ceil((double) dist[i] / speed[i]);
            speed[i] = 0; // Initialize the "speed" array to 0 for counting monsters arriving at the same
                          // time.
        }
        // Count the number of monsters arriving at each minute.
        for (int arrivalTime : arrivalTimes) {
            if (arrivalTime >= n)
                continue;
            speed[arrivalTime]++;
        }
        // Calculate the cumulative count of monsters arriving at or before each minute.
        for (int i = 1; i < n; i++) {
            speed[i] += speed[i - 1];
            // If the cumulative count exceeds the current minute, return the maximum number
            // of eliminated monsters.
            if (speed[i] > i) {
                return i;
            }
        }
        // If no game loss occurs, return the total number of monsters, as all of them
        // can be eliminated.
        return n;
    }
}
