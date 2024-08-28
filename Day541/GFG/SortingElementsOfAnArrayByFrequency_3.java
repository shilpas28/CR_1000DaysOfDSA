//GFG
//Sorting Elements of an Array by Frequency
//Time complexity: O(n*logn)
//Space complexity: O(n)

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortingElementsOfAnArrayByFrequency_3 {

    public static void main(String[] args) {
        int arr[] = { 5, 5, 4, 6, 4 };
        System.out.println(sortByFreq(arr));
    }

    // Function to sort the array according to frequency of elements.
    public static ArrayList<Integer> sortByFreq(int arr[]) {
        // add your code here
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freqMap.entrySet());
        Collections.sort(list, (a, b) -> {
            if (a.getValue().equals(b.getValue())) {
                return a.getKey() - b.getKey();
            } else {
                return b.getValue() - a.getValue();
            }
        });

        ArrayList<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            int element = entry.getKey();
            int frequency = entry.getValue();
            for (int i = 0; i < frequency; i++) {
                result.add(element);
            }
        }
        return result;
    }
}
