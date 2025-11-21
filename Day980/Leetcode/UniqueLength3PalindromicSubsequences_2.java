//Leetcode
//1930. Unique Length-3 Palindromic Subsequences
//Time complexity: O(N) - Since we iterating two passes, first pass to compute first and last occurence for each character with 
//time N and second pass to compute number of unique palindromes. In the second pass we iterate over all the unique characters 
//which are 26 and we iterate between their first and last occurence to compute the number of unique characters which can be 
//at most N characters. So time complexity is 26 * N + N which is 27 * N which is also O(N). Where N is number of characters in 
//our input string.
//Space complexity: O(1) - Since we are storing two arrays to compute last and first occurence each one of them is of size 26 
//and we use hash set that can be at maximum with size 26 so the space complexity is still O(1). Since we have constant 
//space variables. 

import java.util.HashSet;

public class UniqueLength3PalindromicSubsequences_2 {

    public static void main(String[] args) {
        String s = "aabca";
        System.out.println(countPalindromicSubsequence(s));
    }

    public static int countPalindromicSubsequence(String s) {
        // Arrays to store the minimum and maximum occurrences of each character in the
        // input string
        int[] minExist = new int[26];
        int[] maxExist = new int[26];
        for (int i = 0; i < 26; i++) {
            minExist[i] = Integer.MAX_VALUE;
            maxExist[i] = Integer.MIN_VALUE;
        }
        // Populate minExist and maxExist arrays
        for (int i = 0; i < s.length(); i++) {
            int charIndex = s.charAt(i) - 'a';
            minExist[charIndex] = Math.min(minExist[charIndex], i);
            maxExist[charIndex] = Math.max(maxExist[charIndex], i);
        }
        // Variable to store the final count of unique palindromic subsequences
        int uniqueCount = 0;
        // Iterate over each character in the alphabet
        for (int charIndex = 0; charIndex < 26; charIndex++) {
            // Check if the character has occurred in the input string
            if (minExist[charIndex] == Integer.MAX_VALUE || maxExist[charIndex] == Integer.MIN_VALUE) {
                continue; // No occurrences, move to the next character
            }
            // Set to store unique characters between the minimum and maximum occurrences
            HashSet<Character> uniqueCharsBetween = new HashSet<>();
            // Iterate over the characters between the minimum and maximum occurrences
            for (int j = minExist[charIndex] + 1; j < maxExist[charIndex]; j++) {
                uniqueCharsBetween.add(s.charAt(j));
            }
            // Add the count of unique characters between the occurrences to the final count
            uniqueCount += uniqueCharsBetween.size();
        }
        // Return the total count of unique palindromic subsequences
        return uniqueCount;
    }
}
