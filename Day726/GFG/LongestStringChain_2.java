//GFG
//Longest String Chain
//Time complexity: O(nlogn + n*m²)
//Space complexity: O(n*m)

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain_2 {

    public static void main(String[] args) {
        String words[] = { "ba", "b", "a", "bca", "bda", "bdca" };
        System.out.println(longestStringChain(words));
    }

    public static int longestStringChain(String words[]) {
        // code here
        // Step 1: Sort the words by their lengths
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        // Step 2: Create a map to store the longest chain length for each word
        Map<String, Integer> dp = new HashMap<>();
        int maxLength = 1; // At least one word in the chain
        // Step 3: Process each word
        for (String word : words) {
            int currentLength = 1; // Start with a chain of length 1 (the word itself)
            // Generate all possible predecessors by removing one character
            for (int i = 0; i < word.length(); i++) {
                String predecessor = word.substring(0, i) + word.substring(i + 1);
                // Check if the predecessor exists in the map
                if (dp.containsKey(predecessor)) {
                    currentLength = Math.max(currentLength, dp.get(predecessor) + 1);
                }
            }
            // Update the DP map with the current word's chain length
            dp.put(word, currentLength);
            // Update the maximum chain length
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;
    }
}
