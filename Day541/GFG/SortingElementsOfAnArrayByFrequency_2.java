//GFG
//Sorting Elements of an Array by Frequency
//Time complexity: O(n*logn)
//Space complexity: O(n)

import java.util.ArrayList;
import java.util.Arrays;

public class SortingElementsOfAnArrayByFrequency_2 {

    public static void main(String[] args) {
        int arr[] = { 5, 5, 4, 6, 4 };
        System.out.println(sortByFreq(arr));
    }

    // Function to sort the array according to frequency of elements.
    public static ArrayList<Integer> sortByFreq(int arr[]) {
        // add your code here
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        // Initialize a frequency array
        int[][] temp = new int[max + 1][2]; // [element, frequency]
        for (int i = 0; i < max + 1; i++) {
            temp[i][0] = i; // Store the element itself
            temp[i][1] = 0; // Initialize frequency to 0
        }
        // Count frequencies of each element
        for (int e : arr) {
            temp[e][1]++;
        }
        // Sort the temp array by frequency, and by element value for ties
        Arrays.sort(temp, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0]; // If frequencies are the same, sort by element value
            } else {
                return b[1] - a[1]; // Sort by frequency in descending order
            }
        });
        // Create the result array list
        ArrayList<Integer> ans = new ArrayList<>();
        // Populate the result list based on sorted frequencies
        for (int i = 0; i < temp.length; i++) {
            int element = temp[i][0];
            int frequency = temp[i][1];
            while (frequency-- > 0) {
                ans.add(element); // Add the element 'frequency' times
            }
        }
        return ans;
    }
}
