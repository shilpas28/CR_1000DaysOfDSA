//GFG
//Frequencies of Limited Range Array Elements
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

import java.util.HashMap;

public class FrequenciesOfLimitedRangeArrayElements {

    public static void main(String[] args) {
        int N = 5;
        int arr[] = { 2, 3, 2, 3, 5 };
        int P = 5;
        frequencyCount(arr, N, P);
    }

    // Function to count the frequency of all elements from 1 to N in the array.
    public static void frequencyCount(int arr[], int N, int P) {
        // code here
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        // Count the frequency of numbers in the array
        for (int i = 0; i < N; i++) {
            if (arr[i] >= 1 && arr[i] <= N) {
                frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
            }
        }
        // Modify the input array in place
        for (int i = 1; i <= N; i++) {
            arr[i - 1] = frequencyMap.getOrDefault(i, 0);
        }
    }
}
