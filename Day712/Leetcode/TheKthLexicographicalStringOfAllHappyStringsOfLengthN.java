//Leetcode
//1415. The k-th Lexicographical String of All Happy Strings of Length n - Backtracking
//Time complexity: O(n*(2^n))
//Space complexity: O(2^n)

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TheKthLexicographicalStringOfAllHappyStringsOfLengthN {

    public static void main(String[] args) {
        int n = 1, k = 3;
        System.out.println(getHappyString(n, k));
    }

    static List<String> happyStrings = new ArrayList<>();

    public static String getHappyString(int n, int k) {
        String currentString = "";
        // Generate all happy strings of length n
        generateHappyStrings(n, currentString);
        // Check if there are at least k happy strings
        if (happyStrings.size() < k)
            return "";
        // Sort the happy strings in lexicographical order
        Collections.sort(happyStrings);

        return happyStrings.get(k - 1);
    }

    protected static void generateHappyStrings(int n, String currentString) {
        // If the current string has reached the desired length, add it to the
        // list
        if (currentString.length() == n) {
            happyStrings.add(currentString);
            return;
        }
        // Try adding each character ('a', 'b', 'c') to the current string
        for (char currentChar = 'a'; currentChar <= 'c'; currentChar++) {
            // Skip if the current character is the same as the last character
            if (currentString.length() > 0 &&
                    currentString.charAt(currentString.length() - 1) == currentChar)
                continue;
            // Recursively generate the next character
            generateHappyStrings(n, currentString + currentChar);
        }
    }
}
