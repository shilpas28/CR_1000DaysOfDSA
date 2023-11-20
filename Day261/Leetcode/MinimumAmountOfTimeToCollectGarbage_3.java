//Leetcode
//2391. Minimum Amount of Time to Collect Garbage
//Time complexity: O(N) - Since we are iterating over our garbage array to get last index of each garbage type then it takes O(N) 
//then we are iterating over our travelling array which take also O(N) so total complexity is 2N which is O(N). Where N is 
//number of houses in garbage array. FirstNote: Complexity of first for-loop is N*house_size and since the house size is 10 then 
//its complexity is 10*N which is O(N). SecondNote: Complexity of second for-loop is N*garbage_type and since the garpage type 
//is 3 then its complexity is 3*N which is O(N).
//Space complexity: O(1) - Since we are only using constant space variables that doesn't depend on the input size.

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAmountOfTimeToCollectGarbage_3 {

    public static void main(String[] args) {
        String[] garbage = { "G", "P", "GP", "GG" };
        int[] travel = { 2, 4, 3 };
        System.out.println(garbageCollection(garbage, travel));
    }

    public static int garbageCollection(String[] garbage, int[] travel) {
        long totalMinutes = 0; // Total minutes needed for garbage collection
        long currentTravelTime = 0; // Current travel time
        // Add the initial minutes required to collect garbage at the first house
        totalMinutes += garbage[0].length();
        // Keep track of the last occurrence of each type of garbage
        List<Integer> lastGarbageIndices = new ArrayList<>(Arrays.asList(-1, -1, -1));
        // Iterate through each house starting from the second house
        for (int houseIndex = 1; houseIndex < garbage.length; houseIndex++) {
            // Add the minutes required to collect garbage at the current house
            totalMinutes += garbage[houseIndex].length();
            // Update the indices of the last occurrence of each type of garbage
            if (garbage[houseIndex].contains("M")) {
                lastGarbageIndices.set(0, houseIndex - 1);
            }
            if (garbage[houseIndex].contains("P")) {
                lastGarbageIndices.set(1, houseIndex - 1);
            }
            if (garbage[houseIndex].contains("G")) {
                lastGarbageIndices.set(2, houseIndex - 1);
            }
        }
        // Iterate through each travel segment
        for (int travelIndex = 0; travelIndex < travel.length; travelIndex++) {
            // Add the current travel time
            currentTravelTime += travel[travelIndex];
            // Add the minutes required to collect garbage if a garbage truck is at the
            // corresponding house
            for (int truckIndex = 0; truckIndex < 3; truckIndex++) {
                if (lastGarbageIndices.get(truckIndex) == travelIndex) {
                    totalMinutes += currentTravelTime;
                }
            }
        }
        return (int) totalMinutes;
    }
}
