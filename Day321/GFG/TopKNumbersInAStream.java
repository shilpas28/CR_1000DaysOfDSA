//GFG
//Top k numbers in a stream
//Time complexity: O(N*K)
//Space complexity: O(N)

package GFG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class TopKNumbersInAStream {

    public static void main(String[] args) {
        int N = 5, K = 4;
        int arr[] = { 5, 2, 1, 3, 2 };
        System.out.println(kTop(arr, N, K));
    }

    public static ArrayList<ArrayList<Integer>> kTop(int[] arr, int N, int K) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        TreeMap<Integer, TreeSet<Integer>> sortedFrequencyMap = new TreeMap<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int num = arr[i];
            int frequency = frequencyMap.getOrDefault(num, 0) + 1;

            if (frequency > 1) {
                // Remove the old frequency from the TreeSet
                sortedFrequencyMap.get(frequency - 1).remove(num);
                if (sortedFrequencyMap.get(frequency - 1).isEmpty()) {
                    sortedFrequencyMap.remove(frequency - 1);
                }
            }

            // Update the frequency in the map
            frequencyMap.put(num, frequency);
            // Add the number to the TreeSet with the updated frequency
            sortedFrequencyMap.computeIfAbsent(frequency, k -> new TreeSet<>()).add(num);
            // Build the result list
            ArrayList<Integer> currentResult = new ArrayList<>();
            int count = 0;
            for (Map.Entry<Integer, TreeSet<Integer>> entry : sortedFrequencyMap.entrySet()) {
                for (int value : entry.getValue()) {
                    currentResult.add(value);
                    count++;
                    if (count == K) {
                        break;
                    }
                }
                if (count == K) {
                    break;
                }
            }
            result.add(new ArrayList<>(currentResult));
        }
        return result;
    }
}
