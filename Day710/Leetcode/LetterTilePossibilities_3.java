//Leetcode
//1079. Letter Tile Possibilities - Permutations and Combinations
//Time complexity: O((2^n)*n)
//Space complexity: O((2^n)*n)

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LetterTilePossibilities_3 {

    public static void main(String[] args) {
        String tiles = "AAB";
        System.out.println(numTilePossibilities(tiles));
    }

    public static int numTilePossibilities(String tiles) {
        Set<String> seen = new HashSet<>();
        // Sort characters to handle duplicates efficiently
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        String sortedTiles = new String(chars);
        // Find all unique sequences and their permutations
        return generateSequences(sortedTiles, "", 0, seen) - 1;
    }

    static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }

        int result = 1;
        for (int num = 2; num <= n; num++) {
            result *= num;
        }
        return result;
    }

    static int countPermutations(String seq) {
        // Count frequency of each character
        int[] charCount = new int[26];
        for (char ch : seq.toCharArray()) {
            charCount[ch - 'A']++;
        }
        // Calculate permutations using factorial formula
        int total = factorial(seq.length());
        for (int count : charCount) {
            total /= factorial(count);
        }
        return total;
    }

    static int generateSequences(
            String tiles,
            String current,
            int pos,
            Set<String> seen) {
        if (pos >= tiles.length()) {
            // If new sequence found, count its unique permutations
            if (seen.add(current)) {
                return countPermutations(current);
            }
            return 0;
        }
        // Try including and excluding current character
        return (generateSequences(tiles, current, pos + 1, seen) +
                generateSequences(tiles, current + tiles.charAt(pos), pos + 1, seen));
    }
}
